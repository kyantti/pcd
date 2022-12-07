package main.java.es.unex.cum.pcd.semaforos.lectoresescritores.prioridadlectores;

public class Reader extends Person implements Runnable {

    public Reader(int id, Buffer buffer) {
        super(id, buffer);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                buffer.read(super.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
