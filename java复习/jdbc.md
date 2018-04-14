```java
public static void main(String[] args) {
      String driverName = "com.mysql.jdbc.Driver";//mysql驱动
      String url = "jdbc:mysql://localhost:3306/mysql_demo";//连接数据库
      String username = "root";//用户帐号
      String password = "root";//密码
      Connection conn=null;
      PreparedStatement stmt = null;//预编译的
       try {
           String sql = "SELECT * FROM student";
//         String sql = "insert into student(sid,sname,ssex) values(?,?,?)";  
//         String sql = "UPDATE student set sname ='xx' WHERE sid=9";
           Class.forName(driverName);
           conn = (Connection) DriverManager.getConnection(url,username,password);
           stmt = conn.prepareStatement(sql);
//            stmt.setInt(1,9);
//            stmt.setString(2,"老王");
//            stmt.setString(3,"男");
           ResultSet rs = stmt.executeQuery();
//增删改使用更新executeUpdate();--更新会返回更新的行数/0表示没有修改
//         int t = stmt.executeUpdate();
           while (rs.next()){
              String name = rs.getString("Sname");
              int id = rs.getInt("Sid");
               System.out.println(id+"--"+name);
           }
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
          stmt.close();
          conn.close();
       }
```

### jdbc事务
&emsp;执行多条sql语句，发生错误时扑捉异常--回滚
```java
SavePoint sp;
//默认为true(事务关闭)--表示每执行一条语句提交一次
try{
    conn.setAutoCommit(false);//开启事务
    xxx
    sql1
    sp = conn.setSavepoint("1");//存档--表示之前的操作都是有效的
    sql2
} catch (SQLException e) {
    conn.rollback();//回滚
    conn.rollback(sp);//回滚到存档点
    e.printStackTrace();
}
```

### 连接池
![图](https://github.com/fishhello/learn/blob/master/java%E5%A4%8D%E4%B9%A0/pictures/jdbc_chi.png)
&emsp;避免频繁创建销毁资源--从池子里拿出用，用完放回池子  (c3p0.jar)
```java
public class DBUtils {
    public  static Connection initConnection(){
        try {
            ComboPooledDataSource dataSource =  new ComboPooledDataSource();
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mysql_demo");
            dataSource.setUser("root");
            dataSource.setPassword("root");
            dataSource.setDriverClass("com.mysql.jdbc.Driver");

            Connection conn = dataSource.getConnection();

            return conn;
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

public static void main(String[] args) {
      Connection conn=null;
      PreparedStatement stmt = null;//预编译的
       try {
           String sql = "SELECT * FROM student";
           conn.DBUtils.initConnection();
           stmt = conn.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery();

           while (rs.next()){
              String name = rs.getString("Sname");
              int id = rs.getInt("Sid");
               System.out.println(id+"--"+name);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {//待补充-需要返回给连接池
          stmt.close();
          conn.close();
       }
```
