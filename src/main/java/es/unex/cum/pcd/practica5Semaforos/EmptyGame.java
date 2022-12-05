package es.unex.cum.pcd.practica5Semaforos;

public class EmptyGame extends Exception{
    private static final long serialVersionUID = 1L;
    
    public EmptyGame(){
        System.out.println("Dentro constructor");
    }
    public EmptyGame(String msg){
        super(msg);
    }
    public String getMessage(){
        return "No quedan jugadores: "+super.getMessage();
    }
}