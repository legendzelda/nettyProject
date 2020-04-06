package atguigu.com.netty;

import java.nio.ByteBuffer;

public class ByteBufferReadOnlyPut {

    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        for (int i = 0; i < 64 ; i++) {
            byteBuffer.put((byte) i);
        }

        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        readOnlyBuffer.flip();
        while (readOnlyBuffer.hasRemaining()) {
            System.out.println(readOnlyBuffer.get());
        }
        readOnlyBuffer.put((byte) 2);
    }
}