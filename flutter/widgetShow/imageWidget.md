## image图片组件

```dart
Container(
    child:new Image.network(//network调用网络图片
        "图片url",
        //fit:BoxFit.fill,//图片填充整个容器，boxFit参考：https://www.jianshu.com/p/8810bacfe5d4
        repeat:ImageRepeat.repeat,//图片重复填满容器
    ),
    width:400.0,
    height:300.0,
    color:Colors.lightBule
)
```