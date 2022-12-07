package main.java.es.unex.cum.pcd.monitores.lectorescritor;

public class Person {
    
    private int id;
    public Buffer buffer;

    public Person(int id, Buffer buffer){
        this.id = id;
        this.buffer = buffer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Buffer getBuffer() {
        return buffer;
    }

    public void setBuffer(Buffer buffer) {
        this.buffer = buffer;
    }

    
}
