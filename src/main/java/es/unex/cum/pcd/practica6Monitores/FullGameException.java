package main.java.es.unex.cum.pcd.practica6Monitores;

public class FullGameException extends Exception{
    private static final long serialVersionUID = 1L;

    public FullGameException(){
        System.out.println("Dentro constructor");
    }
    public FullGameException(String msg){
        super(msg);
    }
    public String getMessage(){
        return "Numero maximo de jugadores: "+super.getMessage();
    }
}