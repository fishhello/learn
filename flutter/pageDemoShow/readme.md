## 一。使用StatefulWidget随机显示一组单词

1.0 需要导入english_words包,使用wordPair
```
import 'package:flutter/material.dart';
import 'package:english_words/english_words.dart';

// => 符号是dark中单行函数/方法的简写
void main() => runApp(new MyApp());

// 本应用程序继承了statelesswidget,是不可变的,意味着他们的属性不能改变所有值都是最终的
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

2.0 添加一个有状态的部件,使用一个可变化的组件在屏幕中间显示一个英文单词
- StatelessWidget是不可变的,属性不可变,所有的值都是最终的
- StatefulWidget 则是可以变化的

2.1 创建一个StatefulWidget需要一个State类
```
class RandomWords extends StatefulWidget {
  @override
  createState() => new RandomWordsState();
}
```
2.2 创建State类
```
class RandomWordsState extends State<RandomWords> {
  @override
  Widget build(BuildContext context) {
    final wordPair = new WordPair.random();
    return new Text(wordPair.asPascalCase);
  }
}
```
2.3 在主类中调用
```
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'Welcome to Flutter',
      home: new Scaffold(
        appBar: new AppBar(
          title: new Text('Welcome to Flutter'),
        ),
        body: new Center(
          //child: new Text(wordPair.asPascalCase),
          child: new RandomWords(),
        ),
      ),
    );
  }
}
```

## 二。根据图片构建实例

![示例图片](https://github.com/fishhello/learn/blob/master/flutter/images/Screenshot_1551336612.png)
```
import 'package:flutter/material.dart';
//add import to rendering library
import 'package:flutter/rendering.dart';

void main(){
  //debugPaintSizeEnabled=true;
  runApp(MyApp());
}
  

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    Widget titleSection = Container(
      padding: const EdgeInsets.all(32),
      child: Row(
        children: [
          Expanded(
            /*1*/
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                /*2*/
                Container(
                  padding: const EdgeInsets.only(bottom: 8),
                  child: Text(
                    'Oeschinen Lake Campground',
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ),
                Text(
                  'Kandersteg, Switzerland',
                  style: TextStyle(
                    color: Colors.grey[500],
                  ),
                ),
              ],
            ),
          ),
          /*3*/
          Icon(
            Icons.star,
            color: Colors.red[500],
          ),
          Text('41'),
        ],
      ),
    );

    Color color = Theme.of(context).primaryColor;

    Widget buttonSection = Container(
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: [
          _buildButtonColumn(color, Icons.call, 'CALL'),
          _buildButtonColumn(color, Icons.near_me, 'ROUTE'),
          _buildButtonColumn(color, Icons.share, 'SHARE'),
        ],
      ),
    );

    Widget textSection = Container(
      padding: const EdgeInsets.all(32),
      child: Text(
        'Lake Oeschinen lies at the foot of the Blüemlisalp in the Bernese '
            'Alps. Situated 1,578 meters above sea level, it is one of the '
            'larger Alpine Lakes. A gondola ride from Kandersteg, followed by a '
            'half-hour walk through pastures and pine forest, leads you to the '
            'lake, which warms to 20 degrees Celsius in the summer. Activities '
            'enjoyed here include rowing, and riding the summer toboggan run.',
        softWrap: true,
      ),
    );

    return MaterialApp(
      title: 'Flutter layout demo',
      home: Scaffold(
        appBar: AppBar(
          title: Text('Flutter layout demo'),
        ),
        body: ListView(
          children: [
            Image.asset(
              'images/lake.jpg',
              width: 600,
              height: 240,
              fit: BoxFit.cover,
            ),
            titleSection,
            buttonSection,
            textSection,
          ],
        ),
      ),
    );
  }

  Column _buildButtonColumn(Color color, IconData icon, String label) {
    return Column(
      mainAxisSize: MainAxisSize.min,
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Icon(icon, color: color),
        Container(
          margin: const EdgeInsets.only(top: 8),
          child: Text(
            label,
            style: TextStyle(
              fontSize: 12,
              fontWeight: FontWeight.w400,
              color: color,
            ),
          ),
        ),
      ],
    );
  }
}
```

## 三。页面布局2

![](https://github.com/fishhello/learn/blob/master/flutter/images/Screenshot_1551359520.png)

```
import 'package:flutter/material.dart';
//add import to rendering library
import 'package:flutter/rendering.dart';

void main(){
  //debugPaintSizeEnabled=true;
  runApp(MyApp());
}
  

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "falutter layout demo",
      home: buildHomePages("Strawberry Pavlova Recipe"),
    );
  }

  Widget buildHomePages(String title) {
    final titleText =Container(
      padding: EdgeInsets.all(20),
      child: Text(
        "Strawberry Pavlova",
        style: TextStyle(
          fontWeight: FontWeight.w800,
          letterSpacing: 0.5,
          fontSize: 30,
        ),
      ),
    );

    final subTitle =Text(
      'Pavlova is a meringue-based dessert named after the Russian ballerina '
          'Anna Pavlova. Pavlova features a crisp crust and soft, light inside, '
          'topped with fruit and whipped cream.',
      textAlign: TextAlign.center,
      style: TextStyle(
        fontFamily: "Georgia",
        fontSize: 25,
      ),
    );

    var stars = Row(
      mainAxisSize: MainAxisSize.min,
      children: [
        Icon(Icons.star,color: Colors.green[500]),
        Icon(Icons.star,color: Colors.green[500]),
        Icon(Icons.star,color: Colors.green[500]),
        Icon(Icons.star,color: Colors.black),
        Icon(Icons.star,color: Colors.black),
      ],
    );

    final ratings =Container(
      padding: EdgeInsets.all(20),  
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: [
          stars,
          Text(
            '170 Reviews',
            style: TextStyle(
            color: Colors.black,
            fontWeight: FontWeight.w800,
            fontFamily: 'Roboto',
            letterSpacing: 0.5,
            fontSize: 20,
            ),
          )
        ],
      ),
    );

    final descTextStyle =TextStyle(
      color: Colors.black,
      fontWeight: FontWeight.w800,
      fontFamily: 'Roboto',
      letterSpacing: 0.5,
      fontSize: 18,
      height: 2,
    );

    final iconList = DefaultTextStyle.merge(
      style: descTextStyle,
      child: Container(
        padding: EdgeInsets.all(20),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            Column(
              children: [
                Icon(Icons.kitchen, color: Colors.green[500]),
                Text('PREP:'),
                Text('25 min'),
              ],
            ),
            Column(
              children: [
                Icon(Icons.timer, color: Colors.green[500]),
                Text('COOK:'),
                Text('1 hr'),
              ],
            ),
            Column(
              children: [
                Icon(Icons.restaurant, color: Colors.green[500]),
                Text('FEEDS:'),
                Text('4-6'),
              ],
            ),
          ],
        ),
      ),
    );

    final leftColumn = Container(
      padding: EdgeInsets.fromLTRB(20, 30, 20, 20),
      child: Column(
        children: [
          titleText,
          subTitle,
          ratings,
          iconList,
        ],
      ),
    );

    final mainImage = Image.asset(
      'images/lake.jpg',
      fit: BoxFit.cover,
    );

    return Scaffold(
      appBar: AppBar(
        title: Text(title),
      ),
      // #docregion body
      body: Center(
        child: Container(
          margin: EdgeInsets.fromLTRB(0, 40, 0, 30),
          height: 600,
          child: Card(
            child: Row(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Container(
                  width: 440,
                  child: leftColumn,
                ),
                mainImage,
              ],
            ),
          ),
        ),
      ),
    );

  }
}
```