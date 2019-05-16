## Text组件

```dart
Text(
    "text中需要显示的内容，后面再设置文本的各种属性"，
    textAlign:TextAlign.left,//文字显示居左边
    maxLies:1,//如果显示内容太多，设置显示的行数，
    overflow:TextOverflow.ellipsis, //设置内容溢出时的显示内容，ellipsis显示三个点
    stlye:TextStyle( //设置内容文本的属性
        fontSize:25.0,
        color:Colors.red,
        decoration:TextDecoration.underline,//设置文本下划线
        decorationStyle:TextDecorationStyle.solid,//设置下划线的类型，solid实线
    )
)
```
