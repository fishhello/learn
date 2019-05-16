## container容器组件

```dart
Container(
    child: new Text("hello shafish", style:TextStyle(fontSize:30.0)), //使用容器包含一个子组件
    alignment:Alignment.center,//设置容器内容对齐
    width:500.0,
    height:400.0,
    padding:const EdgeInsets.fromLTRB(10.0,100.0,0.0,0.0,),//设置容器内容的内边距，使用ltrb设置左上右下的边距。const表示常量
    margin:const EdgeInsets.all(20.0), //外边距
    //color:Colors.red, //设置容器背景颜色
    decoration:new BoxDecoration(
        gradeient:const LinearGraddient( //设置渐变色
            colors: [Colors.lightBlue,Colors.greenAccent,Colors.pruple]
        ),
        border:Border.all(width:5.0,color:Colors.red)//设置容器的边框粗细，颜色
    )
)
```
