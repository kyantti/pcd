package main.java.es.unex.cum.pcd.practica1;

import java.util.Random;

/**
 * Tablero
 */

public class Tablero {
    private Casilla casilla[][];

    public Tablero(int fil, int col) {
        casilla = new Casilla[fil][col];
    }

    public void setCasilla(Casilla[][] casilla) {
        this.casilla = casilla;
    }

    public Casilla[][] getCasilla() {
        return casilla;
    }

    public void inicializarTablero(){
        for (int i = 0; i < casilla.length; i++) {
            for (int j = 0; j < casilla.length; j++) {
                int tipo = new Random().nextInt(106);
                casilla[i][j].setTipo(tipo);
            }
        }
    }

}