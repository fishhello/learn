## flutter使用外部包

1. 在pubspec.yaml文件中导入外部包
```
dependencies:
  flutter:
    sdk: flutter

  # The following adds the Cupertino Icons font to your application.
  # Use with the CupertinoIcons class for iOS style icons.
  cupertino_icons: ^0.1.2
  english_words: ^3.1.5
```

2. 在main.dark顶部导入使用
```
import 'package:english_words/english_words.dart';
```
3. 代码--新建一个随机英文变量wordPair
> 将lib/main.dark替换成下面内容：
>> 结果会在屏幕中心显示hello world

```flutter
import 'package:flutter/material.dart';
import 'package:english_words/english_words.dart';

// => 符号是dark中单行函数/方法的简写
void main() => runApp(new MyApp());

// 本应用程序继承了statelesswidget，所以本应用一成文了一个widget
// widget 的主要工作是提供一个build()方法来描述如何根据其他低级别的widget来显示自身内容
// 如:body的widget树中包含了一个center widget ,center widget 又包含了一个text 子 widget
class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {

    // 使用englishworld库,随机显示一个英文单词
    final wordPair = new WordPair.random();

    // material 是一种移动端和web端的视觉设计语言，flutter提供了丰富的material组件
    return new MaterialApp(
      title: 'Welcome to Flutter',

      // scaffold  是 material library中提供的一种wedget,提供了默认的导航栏，标题，主屏幕widget树（复杂）的body属性
      home: new Scaffold(
        appBar: new AppBar(
          title: new Text('Welcome to Flutter'),
        ),
        body: new Center(
          //child: new Text('Hello World'),
          child: new Text(wordPair.asPascalCase),
        ),
      ),
    );
  }
}
```