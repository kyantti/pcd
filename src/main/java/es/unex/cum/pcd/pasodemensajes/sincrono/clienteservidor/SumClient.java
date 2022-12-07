package main.java.es.unex.cum.pcd.pasodemensajes.sincrono.clienteservidor;

import java.nio.channels.SocketChannel;
import java.util.Random;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class SumClient extends Thread {
    private SocketChannel channel;
    private ByteBuffer buffer;
    private IntBuffer intBuffer;
    private int id;


    public SumClient(int id){
        buffer = ByteBuffer.allocate(8);
        intBuffer = buffer.asIntBuffer();
        this.id = id;
    }

    public void getSum(int i, int j) throws InterruptedException {
        try {
            channel = connect();
            sendSumRequest(i, j);
            receiveResponse();
        } catch (IOException e) {
            // add exception handling code here e.printStackTrace()
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    // add exception handling code here e.printStackTrace();
                }
            }
        }
    }

    private SocketChannel connect() throws IOException {
        InetSocketAddress socketAddress = new InetSocketAddress("localhost", 9099);
        return SocketChannel.open(socketAddress);
    }

    private void sendSumRequest(int i, int j) throws IOException {
        buffer.clear();
        intBuffer.put(0, i);
        intBuffer.put(1, j);
        channel.write(buffer);
        System.out.println("Client " + id + " sent request for sum of " + i + " and " + j + "...");
    }

    private void receiveResponse() throws IOException {
        buffer.clear();
        channel.read(buffer);
        System.out.println("Client " + id + " received response that sum is " + intBuffer.get(0) + ".");
    }

    @Override
    public void run(){
        Random rand = new Random();
        try {
            getSum(rand.nextInt(10), rand.nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new SumClient(i).start();
        }
    }
    
}