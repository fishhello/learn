**Ajax(Asynchronous JavaScript and XML) JavaScriptXML**

-   (1)XHTMLCSS
-   (2)DOM
-   (3)XMLXSLT
-   (4)XMLHttpRequest
-   (5)Javascript

 介绍ajax原理和初步使用(一个小栗子)

### fish01

#### 为什么ajax

需要局部刷新内容--性能、交互等方面的要求

#### ajax的代理人(异步对象)

XMLHttpRequest对象

#### 原理

 浏览器是先把请求发送到XMLHttpRequest异步对象之中，异步对象对请求进行封装，然后再与发送给服务器。服务器并不是以转发的方式响应，而是以流的方式把数据返回给浏览器

 XMLHttpRequest异步对象会不停监听服务器状态的变化，得到服务器返回的数据，就写到浏览器上【因为不是转发的方式，所以是无刷新就能够获取服务器端的数据】
 
#### 方法(常用)

-   open()(String method,String url,boolean asynch,String username,String password)
     创建http请求

-   send(content)
     发送请求给服务器,get方法不需填写参数

-   setRequestHeader(String header,String value)
     设置消息头(post方法特用)

#### 属性

-   onreadystatechange(指定回调函数)
     请求状态改变触发特定事件,4代表从服务器接收数据完成

-   responseText
     服务器返回的内容

-   status
     服务器状态，200、404之类

### fish01_1

 二级联动xml版

#### 总结

 监听下拉框的变化,如果变化了就使用异步操作访问服务器获取对应数据返回给异步对象
 使用DOM编程把数据动态添加到页面上

-   在Servlet上记得要指定返回的是XML的数据！

-   在前台解析XML文档的时候，不能直接使用innerHtml来得到节点的值，只能通过firstChild.nodeValue的方式获取。

-   由于每次append到下拉框都会连续append，因此在响应事件的时候，把下拉框清零

-   把下拉框options的长度赋值为1，那么就是清零的操作了。
