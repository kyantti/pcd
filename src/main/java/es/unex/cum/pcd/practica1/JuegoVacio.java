package es.unex.cum.pcd.practica1;

public class JuegoVacio extends Exception{
    private static final long serialVersionUID = 1L;
    public JuegoVacio(){
        System.out.println("dentro constructor");
    }
    public JuegoVacio(String msg){
        super(msg);
    }
    public String getMessage(){
        return "No quedan jugadores: "+super.getMessage();
    }
}