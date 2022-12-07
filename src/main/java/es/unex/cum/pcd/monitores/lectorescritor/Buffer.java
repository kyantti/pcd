package main.java.es.unex.cum.pcd.monitores.lectorescritor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    private int memory;
    private int numberOfReaders;
    private boolean writing;
    private Lock lock;
    private Condition reader;
    private Condition writer;
    private int readersWaiting;

    public Buffer() {
        memory = 0;
        numberOfReaders = 0;
        writing = false;
        lock = new ReentrantLock();
        reader = lock.newCondition();
        writer = lock.newCondition();
        readersWaiting = 0;
    }

    public void write(int value, int id){
        System.out.print("Escritor " + id + " escribiendo valor " + value +" ...");
        memory = value;
        System.out.print("OK\n");
    }

    public void read(int id){
        System.out.println("Lector " + id + " leyendo valor " + memory);
    }

    public void openReading(int id) throws InterruptedException{
        lock.lock();
        try {
            while (writing) {
                System.out.println("Lector " + id + " esperando");
                readersWaiting = readersWaiting + 1;
                reader.await();
                readersWaiting = readersWaiting - 1;
            }
            numberOfReaders = numberOfReaders + 1;
            reader.signal();
        }
        finally{
            lock.unlock();
        }
        
    }

    public void closeReading() {
        lock.lock();
        try {
            numberOfReaders = numberOfReaders - 1;
            if (numberOfReaders == 0) {
                writer.signal();
            }
        }
        finally {
            lock.unlock();
        }
    }

    public void openWriting() throws InterruptedException{
        lock.lock();
        try{
            while (numberOfReaders != 0 || writing) {
                writer.await();
            }
            writing = true;
        }
        finally{
            lock.unlock();
        }
    }

    public void closeWriting() {
        lock.lock();
        try {
            System.out.println("Lectores esperando: " + readersWaiting);
            writing = false;
            if (readersWaiting == 0) {
                writer.signal();
            } else {
                reader.signal();
            }
        }
        finally {
            lock.unlock();
        }
    }
}
