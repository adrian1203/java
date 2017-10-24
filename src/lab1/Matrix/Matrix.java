package lab1.Matrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import lab5.ex12.MatrixDimensionException;
import myPackage.JIn;

public class Matrix {
    public int x;
    public int y;
    public int[][] tab;

    public Matrix() {
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

    public Matrix(int x, int y) {
        this.x = x;
        this.y = y;
        tab = new int[x][y];
    }
    public Matrix(String filename)throws  IOException{

            FileReader brr = new FileReader(filename);
            BufferedReader br = new BufferedReader(brr);
        try {
            if (br == null) {
              //  throw new IOException("zły plik");
            }
            String line = br.readLine();
            LinkedList<String> value = new LinkedList<String>();
            int x = 0;
            int y = 0;
            while (line != null) {
                y = 0;
                String tmp[] = line.split(",");
                for (String i : tmp) {
                    value.add(i);
                    y += 1;
                }
                x += 1;
                line = br.readLine();
            }
            this.x = x;
            this.y = y;
            tab = new int[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    tab[i][j] = Integer.parseInt(value.removeFirst());
                }
            }
        }
        finally {
            br.close();
        }


    }

    public Matrix add(Matrix m) throws MatrixDimensionException {
        if (x != m.x || y != m.y) { throw new MatrixDimensionException();
            /*System.out.println("Rózne wymiary");
            return new Matrix(2, 2);*/
        }
        Matrix matrix = new Matrix(x, y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix.tab[i][j] = m.tab[i][j] + this.tab[i][j];
            }
        }
        return matrix;
    }

    public Matrix sub(Matrix m) throws MatrixDimensionException{
        if (x != m.x || y != m.y) { throw new MatrixDimensionException();

        }
        Matrix matrix = new Matrix(x, y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix.tab[i][j] = m.tab[i][j] - this.tab[i][j];
            }
        }
        return matrix;
    }

    public Matrix mul(Matrix m) throws MatrixDimensionException {
        if (y != m.x) {  throw new MatrixDimensionException();
            /*System.out.println("rózne wymiary");
            return new Matrix(2, 2);*/
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
