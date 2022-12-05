package es.unex.cum.pcd.practica3;

public class FullGame extends Exception{
    private static final long serialVersionUID = 1L;

    public FullGame(){
        System.out.println("Dentro constructor");
    }
    public FullGame(String msg){
        super(msg);
    }
    public String getMessage(){
        return "Numero maximo de jugadores: "+super.getMessage();
    }
}