package main.java.es.unex.cum.pcd.semaforos.lectoresescritores.prioridadescritores;

public class App {
    public static void main(String[] args) throws Exception {
        Buffer buffer = new Buffer();
        for (int i = 0; i < 10; i++) {
            new Thread(new Reader(i, buffer)).start();
            new Thread(new Writer(i, buffer)).start();
        }
    }
}
