package atguigu.com.netty;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @Classname MultiByteBuffer
 * @Description TODO
 * @Date 2020/4/21
 * @Created by bu.han
 */
public class MultiByteBuffer {

    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
        serverSocketChannel.socket().bind(inetSocketAddress);

        SocketChannel socketChannel = serverSocketChannel.accept();

        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(3);
        byteBuffers[1] = ByteBuffer.allocate(5);
        int totalNum = 0;
        while(true) {
            while (totalNum < 8) {
                long currReadNum = socketChannel.read(byteBuffers);
                totalNum += currReadNum;
                System.out.println("byteRead=" + totalNum);
                Arrays.asList(byteBuffers).stream().map(buffer -> "position=" + buffer.position() +
                        ",limit=" +buffer.limit()).forEach(System.out::println);
            }

            Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());

            long byteWirte = 0;
            while(byteWirte < 8) {
                long write = socketChannel.write(byteBuffers);
                byteWirte += write;

            }
            Arrays.asList(byteBuffers).forEach(bytebuffer ->{
                bytebuffer.clear();
            });

            System.out.println("byteRead=" + totalNum + ",byteWrite=" + byteWirte);

        }

    }

}
