### Flutter环境搭建

#### Java环境的搭建
> [JDK8下载地址](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

- 配置环境变量
```
1. JAVA_HONE:C:\Program Files\Java\jdk1.8.0_192
2. classpaht:.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;
3. path中新增：%JAVA_HOME%\bin
```
- 终端运行java javac
`如果javac显示错误，在path中新增C:\Program Files\Java\jre1.8.0_192\bin`

#### Flutter环境的搭建
> [FlutterSDK下载地址](https://flutter.io/docs/development/tools/sdk/archive?tab=windows#windows)

`当前使用版本：v1.0.0`

- 新建目录下载安装 如：D:\Flutter\flutter1.0.0
- 打开powershell 运行：
```shell
#  配置flutter国内环境变量
export PUB_HOSTED_URL=https://pub.flutter-io.cn
export FLUTTER_STORAGE_BASE_URL=https://storage.flutter-io.cn
```
- 在powershell中打开flutter目录运行：
```shell
.\flutter_console.bat
```
- 继续输入：
```shell
# doctor检查flutter更新，配置等
flutter doctor
```
- 完善flutter配置
```shell
# flutter证书--一路选 Y
flutter doctor --android-licenses
# 如果提示Android sdk错误之类的报错，执行提示的命令更新Android SDK
# 如果提示更新错误，先确认Java的环境是否配好
```
`如果报其他错，随手百度解决`

#### IDE开启Flutter项目
- 打开Androidstudio 安装Flutter插件
```
File-settings-Plugins 搜索Flutter，下载最多下载量那个插件
# 安装flutter会自动安装dark插件
```
`提示：需要gradle支持`
- 新建flutter项目
> 安装完flutter插件后可以新建Flutter项目，如果没有就重启一下as
```
File-New-New Flutter object
```
- 启动flutter项目
```
# 不会的可以百度或发邮件给我帮忙解决
点击AVD Manger 新建一个虚拟机,balabala
```
![](https://github.com/fishhello/learn/blob/master/flutter/demo1/20190222233118.png)

#### Flutter默认项目

![](https://github.com/fishhello/learn/blob/master/flutter/demo1/Screenshot_1550849528.png)