package atguigu.com.netty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileChannelTransform {

    public static void main(String[] args) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream("E:\\a.doc");
            FileOutputStream fileOutputStream = new FileOutputStream("E:\\b.doc");
            FileChannel sourceChannel = fileInputStream.getChannel();

            FileChannel desChannel = fileOutputStream.getChannel();

            desChannel.transferFrom(sourceChannel,0,sourceChannel.size());

            sourceChannel.close();
            desChannel.close();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
