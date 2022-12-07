package main.java.es.unex.cum.pcd.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        int nRows;
        int nColumns;
        int evenSum;
        int[][] data;

        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduzca el numero de filas: ");
        nRows = Integer.parseInt(lectura.readLine());
        System.out.println("Introduzca el numero de columnas: ");
        nColumns = Integer.parseInt(lectura.readLine());
        System.out.println("Introduzca paridad (0 par, 1 impar): ");
        evenSum = Integer.parseInt(lectura.readLine());

        data = new int[nRows][nColumns];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = new Random().nextInt(10);
            }
        }

        Matrix matrix = new Matrix(data, evenSum);
        matrix.sum();
        System.out.println("El resultado total es de las filas es : " + matrix.getRowResult());
        System.out.println("El resultado total es de las columnas es : " + matrix.getColumnResult());

    }

}
