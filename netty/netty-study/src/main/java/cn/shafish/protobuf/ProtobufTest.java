package cn.shafish.protobuf;

public class ProtobufTest {
    public static void main(String[] args) throws Exception{
        DataInfo.Student student = DataInfo.Student.newBuilder().
                setName("张三").setAge(20).setAddress("珠海").build();
        byte[] studentByte = student.toByteArray();
        DataInfo.Student student2 = DataInfo.Student.parseFrom(studentByte);

        System.out.println(student2.getAddress());
        System.out.println(student2.getAge());
        System.out.println(student2.getName());
    }
}
