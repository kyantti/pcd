package main.java.es.unex.cum.pcd.monitores.lectorescritor;

public class Reader extends Person implements Runnable {

    public Reader(int id, Buffer buffer) {
        super(id, buffer);
    }

    @Override
    public void run() {
        for(int i = 0; i<10; i++) {
            try {
                buffer.openReading(super.getId());
                buffer.read(super.getId());
                buffer.closeReading();
            } catch (InterruptedException e) {

            }
        }
    }
}
