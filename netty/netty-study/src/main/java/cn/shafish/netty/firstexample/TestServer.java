package cn.shafish.netty.firstexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TestServer {
    public static void main(String[] args) throws  Exception{
        //定义了两个NIO事件循环组
        EventLoopGroup boosGroup = new NioEventLoopGroup();//负责获取连接并发送给workerGroup
        EventLoopGroup workerGroup = new NioEventLoopGroup();//完成连接的处理
        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();//简化服务端启动
            serverBootstrap.group(boosGroup,workerGroup).channel(NioServerSocketChannel.class).//定义组、通道
                    childHandler(new TestServerinit());//定义一个自定义的子处理器
            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
