package main.java.es.unex.cum.pcd.semaforos.lectoresescritores.prioridadescritores;

import java.util.Random;

public class Writer extends Person implements Runnable{

    public Writer(int id, Buffer buffer) {
        super(id, buffer);
    }

    @Override
    public void run() {
        for (int j= 0; j<10; j++) {
            try {
                buffer.write(new Random().nextInt(11), super.getId());
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
        }
    }

}
