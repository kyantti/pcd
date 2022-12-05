package es.unex.cum.pcd.matrix;

public class Matrix {

    private Row [] rowThread;
    private int evenSum;
    private int rowResult;
    private int columnResult;
    
    public Matrix(int [][] data, int evenSum){
        rowThread = new Row [data.length + data[0].length];
        //Normal
        for (int i = 0; i < data.length; i++) {
            rowThread[i] = new Row(new int [data[0].length]);
            for (int j = 0; j < data[0].length; j++) {
                rowThread[i].setData(data[i]);
                System.out.print(rowThread[i].getData()[j] + " ");
            }
            System.out.println();
        }
        int [][] transposeData = transposeData(data);
        System.out.println();
        //Transposed
        for (int i = data.length ; i < rowThread.length; i++) {
            rowThread[i] = new Row(new int [transposeData[0].length]);
            for (int j = 0; j < transposeData[0].length; j++) {
                rowThread[i].setData(transposeData[Math.abs(data.length - i)]);
            }
        }

        this.evenSum = evenSum;
        this.rowResult = 0;
        this.columnResult = 0;
    }

    public int getRowResult() {
        return rowResult;
    }

    public int getColumnResult() {
        return columnResult;
    }

    public int [][] transposeData(int [][] data ){
        int [][] newData = new int [data[0].length][data.length];
        for (int i = 0; i < data[0].length; i++) {
            for (int j = 0; j < data.length; j++) {
                newData[i][j] = data[j][i];
            }
        }
        return newData;
    }

    public Row[] getRowThread() {
        return rowThread;
    }

    public void setRowThread(Row[] rowThread) {
        this.rowThread = rowThread;
    }

    public void sum() {
        int i = 0;
        for (i = 0; i < rowThread.length; i++) {
            rowThread[i].setEvenSum(evenSum);
            if (i >= rowThread[i].getData().length) {
                rowThread[i].setType(1);
                rowThread[i].setId(i - rowThread[i].getData().length);
                
            }
            else{
                rowThread[i].setType(0);
                rowThread[i].setId(i);
            }
            rowThread[i].start();
            
        }
        
        // El hilo principal debe esperar a que el resto acabe
        try {
            for (i = 0; i < rowThread.length; i++) {
                rowThread[i].join();
            }
        }
        catch (InterruptedException e) {

        }
        i = 0;
        while (i< rowThread.length - rowThread[i].getData().length -1) {
            rowResult = rowResult + rowThread[i].getResult();
            i++;
        }
        while (i<rowThread.length) {
            columnResult = columnResult + rowThread[i].getResult();
            i++;
        }
    }

    public void show(){
        //Normal
        for (int i = 0; i < rowThread.length; i++) {
            for (int j = 0; j < rowThread[0].getData().length; j++) {
                System.out.print(rowThread[i].getData()[j] + " ");
            }
            System.out.println();
        }
    }

    public void showTransposed(){
        //Transpose
        for (int i = 0; i < rowThread[0].getData().length; i++) {
            for (int j = 0; j <rowThread.length ; j++) {
                System.out.print(rowThread[j].getData()[i] + " ");
            }
            System.out.println();
        }
    }

}
