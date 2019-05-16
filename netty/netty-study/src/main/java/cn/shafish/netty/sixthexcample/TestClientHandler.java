package cn.shafish.netty.sixthexcample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<DataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.MyMessage msg) throws Exception {

    }

    //如果连接处于活动状态，客户端会向服务端发起请求
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
       int randomNum = new Random().nextInt(3);
       DataInfo.MyMessage myMessage = null;

       if(randomNum == 0) {
            myMessage = DataInfo.MyMessage.newBuilder().
                    setDataType(DataInfo.MyMessage.DataType.PersonType).
                    setPerson(DataInfo.Person.newBuilder().setAddress("珠海").setAge(22).setName("shafish").build()).
                    build();
       }else if(randomNum == 1){
           myMessage = DataInfo.MyMessage.newBuilder().
                   setDataType(DataInfo.MyMessage.DataType.DogType).
                   setDog(DataInfo.Dog.newBuilder().setAge(22).setName("shafish hh").build()).
                   build();
       }else if(randomNum == 2) {
           myMessage = DataInfo.MyMessage.newBuilder().
                   setDataType(DataInfo.MyMessage.DataType.CatType).
                   setCat(DataInfo.Cat.newBuilder().setCity("深圳").setName("shafish hhh").build()).
                   build();
       }
        ctx.writeAndFlush(myMessage);
    }
}
