#### 读取properties配置文件
&emsp;properties文件格式:  key-value
 ```java
 Properties p = new Properties();
 //Main.class.getResourceAsSteam("properties文件的路径");
 p.load(new FileInputStream("properties文件的路径"));
System.out.println(p.getProperty("key"));
 ```

 #### xml读写
 &emsp;格式：<节点>-值</节点> ，DOM、SAX解析。使用dom4j
 ```xml
 <students color="red">
   <student>
      <name>fish</name>
      <age>22</age>
   </student>
   <student>
      <name>fish</name>
      <age>22</age>
    </student>
 </students>
 ```

 ```java
 SAXReader reader = new RAXReader();
 Document d = reader.read(new File("xml文件路径"));
 Element root = d.getRootElement();//获取根节点      
 String  color = root.attribute("color").getValue();//获取节点的属性
 List<Element> list = root.element("student");
 for(Element em:list) {
   System.out.pritnln(em.element("name").getText());
   System.out.println(em.element("age").getText());
 }
 ```
