rmi(remote method invocation)：远程方法调用，多个机器之间进行客户端与服务端的数据传输(方法调用)，但仅提供对java语言支持

rpc(remote procedure call):远程过程调用，可以跨语言传输数据(java后端，python等作为前端)

[java-protobuf-doc](https://developers.google.com/protocol-buffers/docs/javatutorial)
Google protocol buffers :简称protobuf,与语言无关，平台无关的可扩展机制，用于序列化结构化数据。采用protobuf只需要编写一个.proto数据描述文件，protobuf编译器会根据描述文件创建class，实现自动编解码
解决的问题:
- 采用java本身的序列化/反序列化 -- 不能与其他的应用(c++/python等)进行数据的交互。
- 一些简单的数据可以采用一些简单编解码。
- 采用xml/json等编码格式，虽然存在优点，但是会造成性能的浪费，解析DOM的花费比遍历类中字段更复杂。