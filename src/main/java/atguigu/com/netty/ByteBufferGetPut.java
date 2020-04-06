package atguigu.com.netty;

import java.nio.ByteBuffer;

public class ByteBufferGetPut {

    public static void main(String[] args) {
        try {
            ByteBuffer allocate = ByteBuffer.allocate(33);
            allocate.putInt(22);
            allocate.putChar('尚');
            allocate.putShort((short) 5);
            allocate.putLong(12l);

            allocate.flip();
            System.out.println(allocate.getInt());
            System.out.println(allocate.getChar());
            System.out.println(allocate.getLong());
            System.out.println(allocate.getLong());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
