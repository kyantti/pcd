package main.java.es.unex.cum.pcd.practica1;

import java.util.ArrayList;
import java.util.List;

/**
 * Juego
 */

public class Juego {
    private Tablero tablero;
    private List <Jugador> jugadorList;
    private int fichas;
    private int maxJugadores;
    private int numJugadoresActual;

    public Juego(int fichas, int fil, int col, int maxJugadores) {
        tablero = new Tablero(fil, col);
        jugadorList = new ArrayList<>();
        this.numJugadoresActual = maxJugadores;
        numJugadoresActual = 0;
        this.fichas = fichas;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public List<Jugador> getJugadorList() {
        return jugadorList;
    }

    public void setJugadorList(List<Jugador> jugadorList) {
        this.jugadorList = jugadorList;
    }

    public int getFichas() {
        return fichas;
    }

    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    public void jugadorSale(Jugador jugador) throws JuegoVacio{
        if (numJugadoresActual == 0) {
            throw new JuegoVacio();
        }
        else{
            jugadorList.remove(jugador);
            numJugadoresActual--;
            System.out.println("Jugador sale");
        }
    }

    public void jugadorEntra(Jugador jugador) throws JuegoLleno{
        if (numJugadoresActual==maxJugadores) {
            throw new JuegoLleno();
        }
        else{
            jugadorList.remove(jugador);
            numJugadoresActual ++;
            System.out.println("Jugador entra");
        }
    }

    public boolean verSiFin(){
        boolean fin=false;
        if (numJugadoresActual == 0) {
            System.out.println("No quedan jugadores, fin del juego");
            fin=!fin;
        }
        return fin;
    }  

    public void jugadoresActuales(){
        System.out.println("Num jugadores actuales: " + numJugadoresActual);
    }
}