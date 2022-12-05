package main.java.es.unex.cum.pcd.practica6Monitores;

/**
 * Tablero
 */

public class Board {
    public Box[][] boxes;

    public Board(int rows, int columns) {
        boxes = new Box[rows][columns];
    }

}