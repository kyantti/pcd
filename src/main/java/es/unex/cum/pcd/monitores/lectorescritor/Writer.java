package main.java.es.unex.cum.pcd.monitores.lectorescritor;

import java.util.Random;

public class Writer extends Person implements Runnable{

    public Writer(int id, Buffer buffer) {
        super(id, buffer);
    }

    @Override
    public void run() {
        for(int i = 0; i<10; i++) {
            try {
                buffer.openWriting();
                buffer.write(new Random().nextInt(10), super.getId());
                buffer.closeWriting();
            } catch (InterruptedException e) {
                
            }
        }
    }
}
