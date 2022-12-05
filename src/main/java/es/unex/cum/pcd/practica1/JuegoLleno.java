package es.unex.cum.pcd.practica1;

public class JuegoLleno extends Exception{
    private static final long serialVersionUID = 1L;
    public JuegoLleno(){
        System.out.println("dentro constructor");
    }
    public JuegoLleno(String msg){
        super(msg);
    }
    public String getMessage(){
        return "Numero maximo de jugadores: "+super.getMessage();
    }
}