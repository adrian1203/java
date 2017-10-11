package lab1.Matrix;

import java.lang.Math.*;

import myPackage.JIn;

public class Matrix {
    private int x;
    private int y;
    int[][] tab;

    Matrix() {
        System.out.println("Podaj wymiary macierzy");
        this.x = JIn.getInt();
        this.y = JIn.getInt();
        tab = new int[x][y];
        System.out.println("Podaj wartości macierzy");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tab[i][j] = JIn.getInt();
            }
        }
    }

    Matrix(int x, int y) {
        this.x = x;
        this.y = y;
        tab = new int[x][y];
    }

    public Matrix add(Matrix m) {
        if (x != m.x || y != m.y) {
            System.out.println("Rózne wymiary");
            return new Matrix(2, 2);
        }
        Matrix matrix = new Matrix(x, y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix.tab[i][j] = m.tab[i][j] + this.tab[i][j];
            }
        }
        return matrix;
    }

    public Matrix sub(Matrix m) {
        if (x != m.x || y != m.y) {
            System.out.println("rózne wymiary");
            return new Matrix(2, 2);
        }
        Matrix matrix = new Matrix(x, y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix.tab[i][j] = m.tab[i][j] - this.tab[i][j];
            }
        }
        return matrix;
    }

    public Matrix mul(Matrix m) {
        if (y != m.x) {
            System.out.println("rózne wymiary");
            return new Matrix(2, 2);
        }
        Matrix matrix = new Matrix(this.x,m.y);
        int i, j, k;
        for (i = 0; i < x; i++)
            for (j = 0; j < matrix.y; j++) {

                for (k = 0; k < y; k++)
                    matrix.tab[i][j] += this.tab[i][k] * m.tab[k][j];
            }
        return matrix;
    }

    public void printMatrix() {
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                System.out.print(this.tab[i][j] + ",");
            }
            System.out.print("\n");
        }
    }


}
