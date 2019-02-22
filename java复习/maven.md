&emsp;项目管理的工具。apache-meven.jar
#### 作用
1. 规范目录结构--src-main(java-java文件、resources-配置文件、webapp-前端)
2. 管理jar包--pom.xml

#### 使用
- ide绑定本地maven

- 修改./config/settings配置
```java
//指定目录存放下载的jar包
<localRepository>D:\xxx\xx</localRepository>
//指定国内的下载镜像(阿里云)
<mirror>
xxxx
</mirror>
```

-添加jar包--pom.xml
```java
//统一配置
<properties>
  <spring.version>4.1.4.RELEASE</spring.version>
</properties>
<dependencies>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>${spring.version}</version>
  </dependency>
</dependencies>
。。。
```

#### 生命周期

- clean
&emsp; 重新编译

- compile检查
&emsp;target目录生成编译好的结果

- package
&emsp;打包(.war包)
