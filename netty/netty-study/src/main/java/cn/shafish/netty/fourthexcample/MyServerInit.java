package cn.shafish.netty.fourthexcample;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class MyServerInit extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();

        //空闲状态处理器
        // 读空闲:5s -- 过了5s客户端没有向服务端发送数据
        // 写空闲:7s -- 7s内没有向客户端写入数据
        // 读写空闲:10s -- 10s内没有读或写都会触发 读写空闲
        channelPipeline.addLast(new IdleStateHandler(5,7,10, TimeUnit.SECONDS));

        //检测空闲状态处理事件
        channelPipeline.addLast(new MyServerHandler());
    }
}
