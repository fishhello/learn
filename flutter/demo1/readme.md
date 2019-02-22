# Flutter环境搭建

## 一. Java环境的搭建
> [JDK8下载地址](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

1. 配置环境变量
```
1. JAVA_HONE:C:\Program Files\Java\jdk1.8.0_192
2. classpaht:.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;
3. path中新增：%JAVA_HOME%\bin
```
2. 终端运行java javac
`如果javac显示错误，在path中新增C:\Program Files\Java\jre1.8.0_192\bin`

## 二. Flutter环境的搭建
> [FlutterSDK下载地址](https://flutter.io/docs/development/tools/sdk/archive?tab=windows#windows)

`当前使用版本：v1.0.0`

1. 新建目录下载安装 如：D:\Flutter\flutter1.0.0
2. 打开powershell 运行：
```shell
#  配置flutter国内环境变量
export PUB_HOSTED_URL=https://pub.flutter-io.cn
export FLUTTER_STORAGE_BASE_URL=https://storage.flutter-io.cn
```
3. 在powershell中打开flutter目录运行：
```shell
.\flutter_console.bat
```
4. 继续输入：
```shell
# doctor检查flutter更新，配置等
flutter doctor
```
5. 完善flutter配置
```shell
# flutter证书--一路选 Y
flutter doctor --android-licenses
# 如果提示Android sdk错误之类的报错，执行提示的命令更新Android SDK
# 如果提示更新错误，先确认Java的环境是否配好
```
`如果报其他错，随手百度解决`

## 三. IDE开启Flutter项目
1. 打开Androidstudio 安装Flutter插件
```
File-settings-Plugins 搜索Flutter，下载最多下载量那个插件
# 安装flutter会自动安装dark插件
```
`提示：需要gradle支持`

2. 新建flutter项目
> 安装完flutter插件后可以新建Flutter项目，如果没有就重启一下as
```
File -New -New Flutter object
```
3. 启动flutter项目
```
# 不会的可以百度或发邮件给我帮忙解决
点击AVD Manger 新建一个虚拟机,balabala
```
![](https://github.com/fishhello/learn/blob/master/flutter/demo1/20190222233118.png)

## 四. 启动Flutter默认项目
> 点击三角形运行项目

![](https://github.com/fishhello/learn/blob/master/flutter/demo1/Screenshot_1550849528.png)


##  Look me
### 有时候这种慢是致命的,慢到死,慢到要启用任务管理器来关闭
### 快捷键不方便,界面比较混乱
### 文件系统把简单的搞复杂化了,眼花缭乱
### 动不动gradle出问题，要更新，导入工程慢，占内存大
### 当然了，这一切都是习惯问题

## 这里重磅退出VSCODE
### vscode更加轻便快捷，这一点，就够了。

## 五. vscode运行flutter
1. 安装完flutterSDK，运行flutter doctor没报错后
- 安装打开vscode安装flutter插件
```
文件-首选项-扩展，搜索Flutter,选第一个install
```
![flutter插件安装](https://github.com/fishhello/learn/blob/master/flutter/demo1/20190223001518.png)

`重载vscode后就可以直接创建flutter项目咧`

2. 创建Flutter项目
> 在创建项目前可以ctrl+shift+p 运行flutter:run flutter doctor更新检查一下
```
ctrl+shift+p 输入:flutter
选中 flutter:new project
需要输入项目名称：如my_first_flutter
```
![flutter项目创建](https://github.com/fishhello/learn/blob/master/flutter/demo1/20190223002242.png)

3. 运行flutter项目
4. 首先，要启动avd

- 新建好flutter后，右下角会有No Devices的显示，如下图：

![启动虚拟机1](https://github.com/fishhello/learn/blob/master/flutter/demo1/20190223002750.png)

- 点击No Devices会显示本地安装的所有虚拟机(也可以在图示2步骤的最后一行新建一个/没用过)，选中一个点击启动

![启动虚拟机2](https://github.com/fishhello/learn/blob/master/flutter/demo1/20190223003134.png)

- 稍等片刻，等虚拟机启动完成

![启动虚拟机3](https://github.com/fishhello/learn/blob/master/flutter/demo1/20190223003439.png)

![虚拟机启动完成](https://github.com/fishhello/learn/blob/master/flutter/demo1/20190223003532.png)
- 运行flutter项目
```shell
# 注意：需要用window的命令行比如：power shell，不能用bash等Linux命令行，会报字符错误
ctrl + ` 打开vscode命令行
# 输入:
flutter run
# 等待项目运行
```
![flutter项目启动完成](https://github.com/fishhello/learn/blob/master/flutter/demo1/20190223003935.png)

- 开启愉快的编码吧