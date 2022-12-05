package es.unex.cum.pcd.practica4Sincronizado;

import java.util.Random;

/**
 * Tablero
 */

public class Board {
    private Box box[][];

    public Board(int fil, int col) {
        box = new Box[fil][col];
    }

    public void setBox(Box[][] box) {
        this.box = box;
    }

    public Box[][] getBox() {
        return box;
    }

    public void randomInitialize(){
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box.length; j++) {
                int type = new Random().nextInt(106);
                box[i][j].setType(type);
            }
        }
    }

}