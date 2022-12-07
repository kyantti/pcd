package main.java.es.unex.cum.pcd.practica6Monitores;

public class EmptyGameException extends Exception{
    private static final long serialVersionUID = 1L;
    
    public EmptyGameException(){
        System.out.println("Dentro constructor");
    }
    public EmptyGameException(String msg){
        super(msg);
    }
    public String getMessage(){
        return "No quedan jugadores: "+super.getMessage();
    }
}