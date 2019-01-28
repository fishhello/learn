`Guava--一个Java库，方便编码，减少编码错误。标准+高效+优化`

- 1.检查参数是否为null的操作（前提：null运行会出错）
```xml
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>26.0-jre</version>
</dependency>
```
```java
//未使用Guava时
import com.google.common.base.Optional;
public class ReadGuava {
	public static void main(String args[]){
		  ReadGuava guavaTester = new ReadGuava();
	      Integer a =  null;
	      Integer b =  new Integer(10);
	      //sum() 不采取任何的保护传递的参数为null。
	      System.out.println(guavaTester.sum(a,b));
	   }
	   public Integer sum(Integer a, Integer b){
	      return a + b;
	   } 
}       
```
```java
//运行结果--使用了null值进行运算报错
Exception in thread "main" java.lang.NullPointerException
	at po.ReadGuava.sum(ReadGuava.java:15)
	at po.ReadGuava.main(ReadGuava.java:11)
```
```java
//使用Optional类，可以方便地查看调用者方法来传递参数正确与否。
    public static void main(String args[]){
        ReadGuava guavaTester = new ReadGuava();
        Integer invalidInput = null;
        //.of方法-- 返回要用作参数Optional类的实例。如果传入的参数为null就会抛出空指针异常。
        Optional<Integer> a =  Optional.of(invalidInput);
        Optional<Integer> b =  Optional.of(new Integer(10));
        //System.out.println(a+""+b);
        System.out.println(guavaTester.sum(a,b));
    }
    public Integer sum(Optional<Integer> a, Optional<Integer> b){
        //.get--获取实例。
        return a.get() + b.get();
    }
```
```java
Exception in thread "main" java.lang.NullPointerException
	at com.google.common.base.Preconditions.checkNotNull(Preconditions.java:877)
	at com.google.common.base.Optional.of(Optional.java:103)
	at po.ReadGuava.main(ReadGuava.java:22)
```

**Optional**
>An immutable object that may contain a non-null reference to another object(一个不可变的对象，它可以包含对另一个对象的非空引用)
此类型的每个实例要么包含非空引用（--引用存在），要么不包含任何引用（引用缺失）。轻率地使用null可能会导致许多问题，使用guava的快速失败操作拒绝null会更有帮助。

```java
Optional<Integer> a = Optional.of(3);
a.isPresent();//判断Optional实例是否为非空引用，非空返回true
```

- 2.Preconditions前置条件
>让方法调用的前置条件更简单
