位于java.util.function包下的一个函数式接口Function
## Function<V,R>
v代表接收参数的类型，r代表返回结果的类型，接收一个参数并返回一个结果
看看代码示例:
- 代码：
```java
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        // 传递一个动作
        int result = test.compute(1,value -> {return 2*value;});
        System.out.println(result);
        System.out.println(test.convert(4,value -> value+" - hello"));
        System.out.println(test.convert(4,value -> String.valueOf(value + " - hello,world")));
        System.out.println(test.compute(4,value -> value*value)); //计算一个数的平方
        System.out.println(test.compute(5,value -> value-2)); //减法
    }

    // 类似这种接收函数作为参数的函数又称为高阶函数
    public int compute(int a,Function<Integer,Integer> function) {
        // apply执行function中的语句
        int result = function.apply(a);
        return result;
    }

    //输入一个整形，输出一个字符串
    public String convert(int a,Function<Integer,String> function) {
        return function.apply(a);
    }

    public String method1(int a){
        return a + " - hello,world";
    }

    public int method2(int a) {
        return a * a;
    }

    public int method3(int a) {
        return a - 2;
    }
}
```
- 结果：
```java
2
4 - hello
4 - hello,world
```

- 高阶函数
示例中的compute、convert都是高阶函数，可以接收函数类型参数的函数也称为高阶函数，是jdk8中新引进的操作。
使用高阶函数就可以在调用时定义动作行为。
- 示例:
```java
System.out.println(test.compute(4,value -> value*value)); //计算一个数的平方
System.out.println(test.compute(5,value -> value-2)); //减法
```
使用频率不高的操作可以使用如示例的操作，比如有一组数需要分别计算平方，减法等，就不用新建一个方法分别定义平方、减法的方法体了。

## 