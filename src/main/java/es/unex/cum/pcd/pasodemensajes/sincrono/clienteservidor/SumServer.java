package main.java.es.unex.cum.pcd.pasodemensajes.sincrono.clienteservidor;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.io.IOException;
import java.net.InetSocketAddress;

public class SumServer {
    ByteBuffer buffer = ByteBuffer.allocate(8);
    IntBuffer intBuffer = buffer.asIntBuffer();
    ServerSocketChannel channel = null;
    SocketChannel sc = null;
    SocketChannel sc2 = null;

    public void start() {
        try {
            openChannel();
            waitForConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openChannel(int id) throws IOException {
        channel = ServerSocketChannel.open();
        channel.socket().bind(new InetSocketAddress(9099));
        while (!channel.isOpen()) {
        }
        System.out.println("Channel is open...");
    }

    private void waitForConnection() throws IOException {
        while (true) {
            sc = channel.accept();
            if (sc != null) {
                System.out.println("A connection is added...");
                processRequest();
                sc.close();
            }
        }
    }

    private void processRequest() throws IOException {
        buffer.clear();
        sc.read(buffer);
        int i = intBuffer.get(0);
        int j = intBuffer.get(1);
        buffer.flip();
        System.out.println("Server received request to add " + i + " and " + j);
        buffer.clear();
        intBuffer.put(0, i + j);
        sc.write(buffer);
        System.out.println("Server returned sum of " + intBuffer.get(0) + ".");
    }

    public static void main(String[] args) {
        new SumServer().start();
    }
}