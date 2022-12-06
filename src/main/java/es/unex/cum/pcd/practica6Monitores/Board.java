package main.java.es.unex.cum.pcd.practica6monitores;

import java.util.Random;

/**
 * Tablero
 */

public class Board {
    private Box[][] boxes;

    public Board(int rows, int columns) {
        boxes = new Box[rows][columns];
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[0].length; j++) {
                boxes[i][j].setType(new Random().nextInt(3));
            }
        }
    }

    public Box[][] getBoxes(){
        return boxes;
    }

    public int rows(){
        return boxes.length;
    }

    public int columns(){
        return boxes[0].length;
    }
    
}