package main.java.es.unex.cum.pcd.monitores.lectorescritor;

public class Main {
    public static void main(String[] args) throws Exception {
        Buffer buffer = new Buffer();
        
        for (int i = 0; i < 5; i++) {
            new Thread(new Writer(i, buffer)).start();
            new Thread(new Reader(i, buffer)).start();
        }
    }
}
