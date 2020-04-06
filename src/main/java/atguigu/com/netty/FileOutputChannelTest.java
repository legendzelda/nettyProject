package atguigu.com.netty;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileOutputChannelTest {

    public static void main(String[] args) {
        String str = "hello,尚硅谷";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("E:/1.txt");
            FileChannel channel = fileOutputStream.getChannel();
            ByteBuffer bytebuffer = ByteBuffer.allocate(1024);
            bytebuffer.put(str.getBytes());
            bytebuffer.flip();
            channel.write(bytebuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream == null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


