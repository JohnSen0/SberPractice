package org.example;

public class Matrix {
    public Matrix(int i, int j, int value){
        this.array = new double[i][j];
        this.columns = i;
        this.rows = j;
        for (int k = 0; k < i; k++) {
            for (int s = 0; s < j; s++){
                this.array[k][s] = value;
            }
        }
    }

    public void add(Matrix matrix){
        if (this.rows==matrix.rows && this.columns==matrix.columns){
            for (int i = 0; i < columns; i++){
                for (int j = 0; j < rows; j++){
                    this.array[i][j]+=matrix.array[i][j];
                }
            }
        }
    }

    public void multiplyOnN(double n){
        for (int i = 0; i < columns; i++){
            for (int j = 0; j < rows; j++){
                this.array[i][j]*=n;
            }
        }
    }

    public void multiply(Matrix matrix){
        if (this.columns == matrix.rows){
            double[][] new_array = new double[this.rows][matrix.columns];
            for (int i = 0; i < this.rows; i++){
                for (int j = 0; j < matrix.columns; j++){
                    for (int k = 0; k < this.columns; k++){
                        new_array[i][j] += this.array[i][k] * matrix.array[k][j];
                    }
                }
            }
            this.array = new_array;
            this.columns = matrix.columns;
        }
        else {
            System.out.println("Умножение невозможно");
        }
    }

    public void print(){
        for (int i = 0; i < columns; i++){
            for (int j = 0; j < rows; j++){
                System.out.print("[" + this.array[i][j] + "] ");
            }
            System.out.println();
        }
    }

    private double[][] array;
    private int rows;
    private int columns;
}

class Main {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3, 3, 5);
        Matrix matrix2 = new Matrix(3, 3, 4);

        matrix1.add(matrix2);
        matrix1.print();

        System.out.println();

        matrix2.multiplyOnN(2);
        matrix2.print();

        System.out.println();

        matrix1.multiply(matrix2);
        matrix1.print();
    }
}