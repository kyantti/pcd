package main.java.es.unex.cum.pcd.semaforos.lectoresescritores.prioridadlectores;

import java.util.concurrent.Semaphore;

public class Buffer {
    private int memory;
    private int readers;

    public Semaphore mutex;
    public Semaphore writerSemaphore;

    public Buffer() {
        memory = 0;
        readers = 0;
        mutex = new Semaphore(1);
        writerSemaphore = new Semaphore(1);
    }

    public void write(int value, int id) throws InterruptedException {
        writerSemaphore.acquire();
        //entra seccion critica
        System.out.println("Escritor " + id + " escribiendo valor " + value);
        memory = value;
        //sale seccion critica
        writerSemaphore.release();
    }

    public void read(int id) throws InterruptedException{
        mutex.acquire();
        readers = readers + 1;
        System.out.println("Lector " + id + " quiere leer");
        if (readers == 1) {
            writerSemaphore.acquire();
        }
        mutex.release();
        //
        System.out.println("Lector " + id + " leyendo el valor " + memory);
        //
        mutex.acquire();
        readers = readers - 1;
        if (readers == 0) {
            writerSemaphore.release();
        }
        mutex.release();

    }
}