## main.dart函数作用说明

> 将lib/main.dark替换成下面内容：
>> 结果会在屏幕中心显示hello world

```flutter
import 'package:flutter/material.dart';

// => 符号是dark中单行函数/方法的简写
void main() => runApp(new MyApp());

// 本应用程序继承了statelesswidget，所以本应用一成文了一个widget
// widget 的主要工作是提供一个build()方法来描述如何根据其他低级别的widget来显示自身内容
// 如:body的widget树中包含了一个center widget ,center widget 又包含了一个text 子 widget
class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {

    // material 是一种移动端和web端的视觉设计语言，flutter提供了丰富的material组件
    return new MaterialApp(
      title: 'Welcome to Flutter',

      // scaffold  是 material library中提供的一种wedget,提供了默认的导航栏，标题，主屏幕widget树（复杂）的body属性
      home: new Scaffold(
        appBar: new AppBar(
          title: new Text('Welcome to Flutter'),
        ),
        body: new Center(
          child: new Text('Hello World'),
        ),
      ),
    );
  }
}
```