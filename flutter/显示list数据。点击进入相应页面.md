```dart
import 'package:flutter/material.dart';

class Product {
    final String title;
    final String description;
    Product(this.title,this.description);
}

void main() => runApp(MyApp());

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context) {

    // material 是一种移动端和web端的视觉设计语言，flutter提供了丰富的material组件
    return new  MaterialApp(
      title: "导航的数据传递和接收",
      home: ProductList(
        products:List.generate(//新建一个ProductList函数，传递一个20数组
          20,
          (i)=>Product("shafish $i 的技术商品","编号为 $i"))
      ),
    );
  }

}

class  ProductList extends StatelessWidget {
  final List<Product> products;
  ProductList({Key key,@required this.products}):super(key:key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title:Text("shafish商品列表")),
      body: ListView.builder(
        itemCount: products.length,
        itemBuilder: (context,index){
          return ListTile(
            title: Text(products[index].title) ,
            onTap: (){
              Navigator.push(
              context, 
              MaterialPageRoute(
                builder:(context)=>new ProductDetail(product:products[index])
              )
              );
            },
            );
        },
      ),
    );
  }
}

class ProductDetail extends StatelessWidget {
  final Product product;
  ProductDetail({Key key,@required this.product}):super(key:key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("${product.title}"),
      ),
      body: Center(child: Text("${product.description}"),),
    );
  }
}
```

![](https://github.com/fishhello/learn/blob/master/flutter/images/show1.jpg)
![](https://github.com/fishhello/learn/blob/master/flutter/images/show2.jpg)