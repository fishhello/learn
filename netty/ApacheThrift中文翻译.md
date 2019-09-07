Apache软件框架，用于可扩展的跨语言服务开发，将软件栈和代码引擎组合起来，能够使C++, Java, Python, PHP, Ruby, Erlang, Perl, Haskell, C#, Cocoa, JavaScript, Node.js, Smalltalk, OCaml and Delphi无缝地高效地工作。

``入门``
- 下载Apache Thrift
[下载链接](http://thrift.apache.org/download)，可以在项目中使用gradle导入，暂时不用管
- 下载thrift编译器
[installing Thrift ](http://thrift.apache.org/docs/install/) 选择window安装，然而我是使用 -- [scoop](https://shafish.cn/825.html#toc-window%E5%B9%B3%E5%8F%B0%E4%B8%80%E4%B8%AA%E5%8C%85%E7%AE%A1%E7%90%86%E5%B7%A5%E5%85%B7%20--%20Scoop)安装的
```
scoop search thrift
scoop install thrift
```
- 写一个.thrift结尾的文件
当安装完thrift编译器后，就需要编写一个thrift文件,这个文件是由thrift类型和services组成的接口定义，你在文件中定义的services会在服务端体现和在客户端响应。thrift编译器是将你编写的thrift文件转化为符合客户端与服务端的源代码。编译器生成格式如下:
```
thrift --gen <language> <Thrift filename>
```
更多关于thrift可以读 -- [白皮书](http://thrift.apache.org/static/files/thrift-20070401.pdf)

``例子``
Apache thrift使用数据类型和service接口来简单定义一个thrift文件。Thrift编译器可以很容易地build 那些跨语言编译的prc客户端和服务端。与那些按模板编写好代码去序列化传输对象和远程调用方法不同，你可以按照一下内容去business

下面是一个简单的存储(store)来自web的对象数据。

thrift文件
```
/**
 * Ahh, now onto the cool part, defining a service. Services just need a name
 * and can optionally inherit from another service using the extends keyword.
 */
service Calculator extends shared.SharedService {

  /**
   * A method definition looks like C code. It has a return type, arguments,
   * and optionally a list of exceptions that it may throw. Note that argument
   * lists and exception lists are specified using the exact same syntax as
   * field lists in struct or exception definitions.
   */

   void ping(),

   i32 add(1:i32 num1, 2:i32 num2),

   i32 calculate(1:i32 logid, 2:Work w) throws (1:InvalidOperation ouch),

   /**
    * This method has a oneway modifier. That means the client only makes
    * a request and does not listen for any response at all. Oneway methods
    * must be void.
```
python 编写的客户端
```
def main():
    # Make socket
    transport = TSocket.TSocket('localhost', 9090)

    # Buffering is critical. Raw sockets are very slow
    transport = TTransport.TBufferedTransport(transport)

    # Wrap in a protocol
    protocol = TBinaryProtocol.TBinaryProtocol(transport)

    # Create a client to use the protocol encoder
    client = Calculator.Client(protocol)

    # Connect!
    transport.open()

    client.ping()
    print('ping()')

    sum_ = client.add(1, 1)
```
java编写的服务端
```
//init
 try {
      TServerTransport serverTransport = new TServerSocket(9090);
      TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

      // Use this for a multithreaded server
      // TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

      System.out.println("Starting the simple server...");
      server.serve();
    } catch (Exception e) {
      e.printStackTrace();
    }

//handler
public class CalculatorHandler implements Calculator.Iface {

  private HashMap<Integer,SharedStruct> log;

  public CalculatorHandler() {
    log = new HashMap<Integer, SharedStruct>();
  }

  public void ping() {
    System.out.println("ping()");
  }

  public int add(int n1, int n2) {
    System.out.println("add(" + n1 + "," + n2 + ")");
    return n1 + n2;
  }

  public int calculate(int logid, Work work) throws InvalidOperation {
    System.out.println("calculate(" + logid + ", {" + work.op + "," + work.num1 + "," + work.num2 + "})");
    int val = 0;
    switch (work.op) {
    case ADD:
      val = work.num1 + work.num2;
      break;
    case SUBTRACT:
      val = work.num1 - work.num2;
      break;
    case MULTIPLY:
      val = work.num1 * work.num2;
      break;
    case DIVIDE:
      if (work.num2 == 0) {
        InvalidOperation io = new InvalidOperation();
        io.whatOp = work.op.getValue();
        io.why = "Cannot divide by 0";
        throw io;
      }
      val = work.num1 / work.num2;
      break;
    default:
      InvalidOperation io = new InvalidOperation();
      io.whatOp = work.op.getValue();
      io.why = "Unknown operation";
      throw io;
    }

    SharedStruct entry = new SharedStruct();
    entry.key = logid;
    entry.value = Integer.toString(val);
    log.put(logid, entry);

    return val;
  }

  public SharedStruct getStruct(int key) {
    System.out.println("getStruct(" + key + ")");
    return log.get(key);
  }

  public void zip() {
    System.out.println("zip()");
  }

}
```

[更多重要内容请点我看](http://thrift.apache.org/docs/types)

代码具体是说明意思，可以下一节再详细讲解，从服务端代码可以看出跟之前protobuf的格式差不多(init,handler)。但是跟protobuf比较而言的话，明显thrift支持的语言更多，而且thrift是由Facebook捐献给apache的顶级开源项目，是否比Google的protobuf更好用或者更好优势呢，to be continu。