package es.unex.cum.pcd.matrix;

public class Row extends Thread {

    private int [] data;
    private int type; // 0 fila, 1 columna
    private int evenSum;
    private int result;
    private long id;

    public Row(){

    }

    public Row (int[] data){
        this.data = data;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void show(){
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getEvenSum() {
        return evenSum;
    }

    public void setEvenSum(int evenSum) {
        this.evenSum = evenSum;
    }

    @Override
    public void run() {
        if (evenSum == 0) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] % 2 == 0) {
                    result = result + data[i];
                }
            }
            if (type == 0) {
                System.out.println("Resultado parcial PAR FILA " + id + ": " + result);
            }
            else{
                System.out.println("Resultado parcial PAR COLUMNA " + id + ": " + result);
            }
        }
        else if (evenSum==1){
            for (int i = 0; i < data.length; i++) {
                if (data[i] % 2 != 0) {
                    result = result + data[i];
                }
            }
            if (type == 0) {
                System.out.println("Resultado parcial IMPAR FILA " + id + ": " + result);
            }
            else{
                System.out.println("Resultado parcial IMPAR COLUMNA " + id + ": " + result);
            }
        }

    }

    

    

}
