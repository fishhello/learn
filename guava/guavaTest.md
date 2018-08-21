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
        //.of方法-- 返回要用作参数Optional类的实例。检查传递的值是否为null。
        Optional<Integer> a =  Optional.of(invalidInput);
        Optional<Integer> b =  Optional.of(new Integer(10));
        //System.out.println(a+""+b);
        System.out.println(guavaTester.sum(a,b));
    }
    public Integer sum(Optional<Integer> a, Optional<Integer> b){
        //.get--获取输入存储在Optional 类的值。
        return a.get() + b.get();
    }        
```