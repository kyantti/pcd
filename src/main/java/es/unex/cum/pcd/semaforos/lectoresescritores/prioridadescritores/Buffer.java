package main.java.es.unex.cum.pcd.semaforos.lectoresescritores.prioridadescritores;

import java.util.concurrent.Semaphore;

public class Buffer {
    private int memory;
    private int readers;
    private int writers;
    private boolean anyoneWriting;
    
    public Semaphore mutex;
    public Semaphore writerSemaphore;

    public Buffer() {
        memory = 0;
        readers = 0;
        mutex = new Semaphore(1);
        writerSemaphore = new Semaphore(1);
    }

    public void write(int value, int id) throws InterruptedException {
        //protocolo de aceso a la seccion critica
        mutex.acquire();
        writers = writers + 1;
        //si alguien esta leyendo o escribiendo me espero
        while (anyoneWriting || readers > 0) {
            mutex.release();
            mutex.acquire();
        }
        anyoneWriting = true;
        writers = writers - 1;
        mutex.release();
        //seccion critica
        System.out.println("Escritor " + id+ " escribiendo valor " + value);
        memory = value;
        //protocolo de salida de la seccion critica
        mutex.acquire();
        anyoneWriting = false;
        mutex.release();
    }

    public void read(int id) throws InterruptedException {
        // protocolo de acceso a la s.c
        mutex.acquire();
        // Si alguien escribiendo o esperando para escribir, me espero
        while (anyoneWriting || (writers > 0)) {
            mutex.release();
            mutex.acquire();
        }
        readers = readers + 1;
        mutex.release();
        /* s.c. */
        System.out.println("Lector " + id + " leyendo elemento " + memory);
        /* Protocolo de salida de la s.c. */
        mutex.acquire();
        readers = readers - 1;
        mutex.release();
    }
}