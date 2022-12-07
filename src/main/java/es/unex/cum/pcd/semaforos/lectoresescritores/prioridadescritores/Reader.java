package main.java.es.unex.cum.pcd.semaforos.lectoresescritores.prioridadescritores;

public class Reader extends Person implements Runnable {

    public Reader(int id, Buffer buffer) {
        super(id, buffer);
    }

    @Override
    public void run() {
        for (int j= 0; j<10; j++) {
            try {
                buffer.read(super.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}
