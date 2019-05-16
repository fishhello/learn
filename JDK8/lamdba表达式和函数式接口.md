## Lamdba表达式
>  java中无法将一个函数 作为参数传递给另一个方法，也无法声明返回一个函数的方法

### Lamdba表示式结构:
> param是函数体参数的数据类型，如下例子中的ActionEvent,如果没有参数就直接省略、如果没有返回值(void)，函数体可以直接省略
> 在java中lamdba表达式是一个对象

```java
(param1,param2,param3) -> {
    函数体
}

() -> {
    函数体
}

() -> {}
```

### 使用Lamdba表达式例子
```java

    JButton jButton = new JButton("my jbutton");
    jButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("点击了按钮");
        }
    });
```
```java
    JButton jButton = new JButton("my jbutton");
    //java进行类型的推断，event是ActionEvent类型，就不需要显式定义event
    jButton.addActionListener(event -> {
        System.out.println("点击了按钮");
    });
```

## 函数式接口

接口只有一个抽象方法，如果接口声明FunctionInterface注解，编译器会按照函数式接口来要求该接口，比如 Ruunable接口
：jdk8接口新增了一个默认实现的方法 default xxx

### 函数式接口例子

```java
//MyInterFace父类为Object,toString方法为父类重写
@FunctionalInterface
interface MyInterFace {
    void face();
    String toString();
}

public class MyInterFaceLamdba {

    public void myTestInterface(MyInterFace myInterFace) {
        System.out.println(1);
        myInterFace.face();
        System.out.println(2);
    }

    public static void main(String[] args) {
        MyInterFaceLamdba test = new MyInterFaceLamdba();
        test.myTestInterface(() -> {//实现了抽象方法face()
            System.out.println("MyTestInterFace");
        });

        System.out.println("---------------");

        MyInterFace myInterFace = () -> {};

        System.out.println(myInterFace.getClass());
        System.out.println(myInterFace.getClass().getSuperclass());
        System.out.println(myInterFace.getClass().getInterfaces()[0]);
    }
}

1
MyTestInterFace
2
---------------
class ch.shafish.jdk8.MyInterFaceLamdba$$Lambda$2/1078694789
class java.lang.Object
interface ch.shafish.jdk8.MyInterFace
```


