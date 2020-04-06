package atguigu.com.netty;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    /**
     * 使用一个ByteBuffer,来进行文件的读取并写入
     */
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("1.txt");
        FileChannel fileInputStreamChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(6);

        while(true) {
            byteBuffer.clear();
            int read = fileInputStreamChannel.read(byteBuffer);
            System.out.println(read);
            byteBuffer.flip();
            if (read != -1) { //没有清空且没有读完就一直重复写入，类似一个坛子装水
                fileOutputStreamChannel.write(byteBuffer);
            }else {
                fileInputStreamChannel.close();
                fileOutputStreamChannel.close();
                break;
            }
        }

    }
}
