&emsp;JDBC全称为:Java Data Base Connectivity,它是可以执行SQL语句的Java API.
&emsp;sun公司只是提供了JDBC API【接口】，数据库厂商负责实现。

### 基本的步骤

- 导入MySQL或者Oracle驱动包 [mysql官网](https://dev.mysql.com/downloads/connector/j/)
- 装载数据库驱动程序
- 获取到与数据库连接
- 获取可以执行SQL语句的对象
- 执行SQL语句
- 关闭连接

### Connection对象
&emsp;客户端和数据库的所有交互都是通过Connection来完成的
 ```java
 //创建向数据库发送sql的statement对象
 createStatement();
 
 //创建向数据库发送sql的PrepareStatement对象
 prepareStatement(sql);
 
 //设置事务提交
 setAutoCommit(boolean autoCommit);
 
 //提交事务
 commit();
 
 //回滚事务
 rollback();
 ...
 ```
 
 ### Statement对象
 &emsp;向数据库发送sql语句CRUD(create/read/update/delete)

 