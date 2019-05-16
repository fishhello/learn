package cn.shafish.netty.sixthexcample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestServerHandler extends SimpleChannelInboundHandler<DataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.MyMessage msg) throws Exception {
        DataInfo.MyMessage.DataType dataType = msg.getDataType();

        if(dataType == DataInfo.MyMessage.DataType.PersonType) {
            DataInfo.Person person = msg.getPerson();
            System.out.println(person.getAddress());
            System.out.println(person.getAge());
            System.out.println(person.getName());

        } else if(dataType == DataInfo.MyMessage.DataType.DogType) {
            DataInfo.Dog dog = msg.getDog();
            System.out.println(dog.getAge());
            System.out.println(dog.getName());

        } else if(dataType == DataInfo.MyMessage.DataType.CatType) {
            DataInfo.Cat cat = msg.getCat();
            System.out.println(cat.getCity());
            System.out.println(cat.getName());
        }
    }
}
