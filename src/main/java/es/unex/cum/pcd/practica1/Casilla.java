package es.unex.cum.pcd.practica1;

/**
 * Casilla
 */

public class Casilla {
    private Boolean ocupada;
    private int tipo;
    private int idJugador;

    public Casilla(){
        
    }

    public Casilla(Boolean ocupada, int tipo, int idJugador) {
        this.ocupada = ocupada;
        this.tipo = tipo;
        this.idJugador = idJugador;
    }

    public Boolean getOcupada() {
        return ocupada;
    }
    public void setOcupada(Boolean ocupada) {
        this.ocupada = ocupada;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public int getIdJugador() {
        return idJugador;
    }
    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

}