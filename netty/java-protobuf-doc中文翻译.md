指南会提供一个基本的java程序来介绍protocol buffers的使用，
通过这个简单的应用程序你可以知道:
- 怎么定义一个 .proto结尾的数据格式
- 怎么使用protocol 编译器
- 怎么使用Java protocol buffer API接口去读写数据

这不是一个全面学习protocol buffers in Java的指南，更多细节参考信息可以看[Protocol Buffer Language Guide](https://developers.google.com/protocol-buffers/docs/proto)、[Java API Reference](https://developers.google.com/protocol-buffers/docs/reference/java/index.html)、[Java Generated Code Guide](https://developers.google.com/protocol-buffers/docs/reference/java-generated)、[Encoding Reference.](https://developers.google.com/protocol-buffers/docs/encoding)

## 为什么要使用Protocol Buffers捏
我们打算使用的程序是一个简单的地址簿程序，可以从文件中读写联系人详细信息。地址簿中的每个联系人都包含姓名、id、邮箱、电话号码。

你是怎么编解码数据结构的？？下面有几种解决方法:
- 使用java的序列化功能。这是语言默认的解决途径，但是这种方法也有很多知名的问题（看书Effective Java, by Josh Bloch，第213✌），而且也不是很好的解决方法让你去与那些用cpp、python语言的程序进行数据分享(share data)。
- 你可以发明个临时的编码方法将数据项转成单个字符串，比如:将4编码成"12:3:-23:67" -- （我也不知道为什么，有时间查查）。尽管这种方法是一个一次性需求的编解码方法(复用不了)，外加解码方面时间的损失，但是也是一个simple and flexible的方法
- 使用xml/json的方式编解码，自从xml成为对人类可读性不错，加上很多编程语言库的支持，这种方法是非常有吸引滴（attractive ），而且这也是与程序/应用数据交流的不二之选（good choice）。但是！XML是臭名昭著的空间密集型(可能就是树枝多点，就notoriously)，在程序编解码时候会造成巨大的性能损失(impose a huge performance penalty),遍历xml的dom树通常也比遍历类中一个简单字段更复杂。

Protocol Buffers可以灵活地、高效地、自动化地、精准地 解决此等问题，用protobuf,你创建一个.proto结尾的数据结构描述文件，然后保存好（.....），做好这些呢，protobuf编译器就会创建一个类，实现了自动编解码的，高效字节码格式的 protocol buffer data。这个初始化好的类会提供 有getters and setters的字段，而且是向下兼容的。xxxxxx

## 示例代码在哪捏~(￣▽￣)~*

[download it here](https://developers.google.com/protocol-buffers/docs/downloads.html) 源代码在examples目录下

## Protocol格式定义

为了创建这个地址簿程序，你要建一个.proto结尾的数据描述文件，这个文件的定义简单:加个message，指定下name 、type(same to 说了跟没说),下面示例:

addressbook.proto
```
syntax = "proto2";

package tutorial;

option java_package = "com.example.tutorial";
option java_outer_classname = "AddressBookProtos";

message Person {
  required string name = 1;
  required int32 id = 2;
  optional string email = 3;

  enum PhoneType {
    MOBILE = 0;
    HOME = 1;
    WORK = 2;
  }

  message PhoneNumber {
    required string number = 1;
    optional PhoneType type = 2 [default = HOME];
  }

  repeated PhoneNumber phones = 4;
}

message AddressBook {
  repeated Person people = 1;
}
```
- protocol有2和3两个版本 -- 对映文件中的`syntax`
- package:包声明，可以避免项目命名冲突
- java_package:类在java项目中的包路径，如果没有设这个值，protobuf会不恰当地根据package进行声明
- java_outer_classname:声明文件的类名，文件内可能有新的类，所以指定的是最外层的类名，如果没有设这个值，会根据文件名进行驼峰处理再声明（my_proto.proto  --> MyProto） -- 看一眼，跑程序就知道了
接下来就进行message的声明
- message:类型字段的聚合，包括bool, int32, float, double, and string等类型的数据，还可以新建一个message进行嵌套，例子中Person嵌套的PhoneNumber,AddressBook 中的Person,你也可以定义一个enum类型进行单选，如例子中的PhoneType:MOBILE, HOME, WORK
- '=0'、'=1' 给每个元素一个唯一的标识，方便二进制编码使用，1-15常用或重复元素，16以上用于那些不常用可选的元素
每个字段都必须使用一下三个注解之一：(不建议使用required来定义元素，)
- required：传输时必须存在的数据
- optional：可选
- repeated：字段可以任意重复多次，保存在protocol缓存中，视为动态大小的数组。

## 使用protobuf编程
现在有了.proto文件，下一步需要做的是生成你需要读写的AdressBook消息体(具体的类)。 为了做到这些，你需要使用protobuf编译器编译你的.proto文件
- 下载protobuf编译器，[下载地址](https://developers.google.com/protocol-buffers/docs/downloads.html)（最新版本下载地址的最后protoc-xxx-win64.zip
）
- 现在启动编译器，确认proto文件目录和代码生成的目标目录，例子:
```
//--java_out是生成java类的指令
protoc -I=$SRC_DIR --java_out=$DST_DIR $SRC_DIR/addressbook.proto
protoc --java_out=src/main/java src/protobuf/Student.proto
protoc -I=src/protobuf --java_out=src/main/java src/protobuf/Student.proto
```
确认上面的示例代码中的java_package指定的目录，在目标目录生成的类路径为:`com/example/tutorial/AddressBookProtos.java`

## protobuf api接口
分析一下生成的代码中一下类、方法、字段。每个类都有一个Builder class用于生成类的实例[Builders vs. Messages](https://developers.google.com/protocol-buffers/docs/javatutorial#builders)

messages方法只能生成类的getters方法，而builders方法能生成getters和settings方法。可以看看下面的例子（按照.proto文件生成的代码解析）:

### 按照message方法解析

```java
// required string name = 1; 文件中定义的name可以生成getName和hasName两个方法，
// hasName用于判断字段是否存在，getName用于获取name值
public boolean hasName();
public String getName();

// required int32 id = 2; 同上
public boolean hasId();
public int getId();

// optional string email = 3; 同上
public boolean hasEmail();
public String getEmail();
```

```
  //repeated PhoneNumber phones = 4;或者repeated .tutorial.Person.PhoneNumber phones = 4;
  //repeated生成的是一个list集合类型的数据，因为该字段的数据类型是一个类(message) PhoneNumber
  //有三个方法 ，getPhoneList -- 获取集合全部数据、getPhoneSize -- 获取集合大小、getPhones -- 获取特定手机号

  public List<PhoneNumber> getPhonesList();
  public int getPhonesCount();
  public PhoneNumber getPhones(int index);
```

### 按照builds方法解析
> 生成的代码比message比较全面，每个字段有clear方法，可以置(un-sets)为空状态

```java
// required string name = 1;
public boolean hasName();
public java.lang.String getName();
public Builder setName(String value);
public Builder clearName();

// required int32 id = 2;
public boolean hasId();
public int getId();
public Builder setId(int value);
public Builder clearId();

// optional string email = 3;
public boolean hasEmail();
public String getEmail();
public Builder setEmail(String value);
public Builder clearEmail();

// repeated .tutorial.Person.PhoneNumber phones = 4;
public List<PhoneNumber> getPhonesList();
public int getPhonesCount();
public PhoneNumber getPhones(int index);
public Builder setPhones(int index, PhoneNumber value);
public Builder addPhones(PhoneNumber value);
public Builder addAllPhones(Iterable<PhoneNumber> value);
public Builder clearPhones();
```

### Builders vs. Messages
使用protobuf生成的类是不变的(immutable),message对象一旦创建就不可修改，就好像java中的String类，构造一个message,首先需要构造一个builder,为所选的字段赋值，然后调用build()方法

可以发现每个修改message的方法都会返回其他的builders,其实返回的对象跟调用方法的对象是一样的。返回可以很方便处理，在单行代码中设置值，例子:
```
Person john =
  Person.newBuilder()
    .setId(1234)
    .setName("John Doe")
    .setEmail("jdoe@example.com")
    .addPhones(
      Person.PhoneNumber.newBuilder()
        .setNumber("555-4321")
        .setType(Person.PhoneType.HOME))
    .build();
```

## 枚举和嵌套类
实例中的PhoneType为Person类的嵌套数据
```java
public static enum PhoneType {
  MOBILE(0, 0),
  HOME(1, 1),
  WORK(2, 2),
  ;
  ...
}
```

## 标准message方法
每个message和builder类中都包含很多其他的方法，方便你去检查和操作整个message，比如:
```java
isInitialized() -- 检查是否全都的必需字段都被设置好
toString() -- 顾名思义
mergeFrom(Message other) -- 合并复合字段，并连接重复的字段。(看代码了解)
clear() --  to the empty state.
```

## 编解码/序列化与反序列化
每个protobuf类都提供了二进制格式参数的方法用于读写message，[ Message API reference ](https://developers.google.com/protocol-buffers/docs/reference/java/com/google/protobuf/Message)比如：
```java
byte[] toByteArray() -- 序列化一个message返回原生字节数组
static Person parseFrom(byte[] data) -- 从一个字节数组中反序列化message

void writeTo(OutputStream output) -- 序列化message，写进OutputStream
static Person parseFrom(InputStream input) -- 从一个InputStream中反序列化message
```

`You should never add behaviour to the generated classes by inheriting from them`，protobuf中没有继承

## 扩展
在以后的使用过程中，你可能会改进你的protobuf message定义,让你的新message向后兼容，旧的message向前兼容(？？)，此时你需要遵守以下规则:
- 不能改变已有字段的tag num (=1 、=2这些)
- 不能改动(新增/删除)所有required(必需)的字段
- 可以删除 optional/repeated 修饰的字段
- 可以新增 optional/repeated 类型的字段，但是要注意更新后面的tag num

## 高级用法
[ Java API reference ](https://developers.google.com/protocol-buffers/docs/reference/java/index.html)继承后发扬 with your imagination