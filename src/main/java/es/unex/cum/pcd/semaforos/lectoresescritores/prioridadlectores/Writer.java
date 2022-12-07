package main.java.es.unex.cum.pcd.semaforos.lectoresescritores.prioridadlectores;

import java.util.Random;

public class Writer extends Person implements Runnable{

    public Writer(int id, Buffer buffer) {
        super(id, buffer);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                buffer.write(new Random().nextInt(11), super.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
