```java
List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
List<String> listString = Arrays.asList("hello","world","hello,world");
```

## 外部迭代
> 利用外部迭代器后移进行取值

```java
for(int i = 0;i<list.size();++i) {
    System.out.println(list.get(i));
}

for (Integer i:list) {
    System.out.println(i);
}
```

## 内部迭代
> 依次拿出集合的结果传递给lamdba函数进行处理(输出)

```java
//使用lamdba表达式
list.forEach(i -> {
    System.out.println(i);
});

//使用方法引用 :: 引用了 Consumer接口 进行处理.(先了解，后面会介绍)
list.forEach(System.out::println);
```
```java
//使用内部迭代遍历list,改成大写后保存成新的list中,然后输出新list内容
List<String> resultList = new ArrayList<>();
list.forEach(item -> resultList.add(item));
resultList.forEach(item -> System.out.println(item));

//使用流的方式完成以上需求 (先了解，后面会介绍)
list.stream().map(item -> item.toUpperCase()).forEach(item -> System.out.println(item));
list.stream().map(String::toUpperCase).forEach(item -> System.out.println(item));
```