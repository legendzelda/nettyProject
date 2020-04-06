package atguigu.com.netty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileInputChannelTest {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("E:\\1.txt");
        FileChannel inputStreamChannel = fileInputStream.getChannel();
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) inputStreamChannel.size());
            inputStreamChannel.read(byteBuffer);
            System.out.println(new String(byteBuffer.array()));
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
