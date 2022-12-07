package main.java.es.unex.cum.pcd.semaforos.lectoresescritores.prioridadlectores;


public class App {
    public static void main(String[] args) throws Exception {
       //se crea el buffer
       Buffer buffer = new Buffer();
       //se crean los hilos lectores y escritores
       for (int i = 0; i < 3 ; i++) {
        new Thread(new Reader(i, buffer)).start();
        new Thread(new Writer(i, buffer)).start();
       }
    }
}
