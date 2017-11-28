package lab5.ex12;

import lab1.Matrix.Matrix;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws MatrixException {
        try {
            DummyMatrix dm2 = new DummyMatrix("C:/Users/Adrian/Desktop/pliki/matrix2.txt");
            DummyMatrix dm3 = new DummyMatrix("C:/Users/Adrian/Desktop/pliki/matrix3.txt");
            DummyMatrix dm4 = new DummyMatrix("C:/Users/Adrian/Desktop/pliki/matrix4.txt");
            dm2.sub(dm2);
            dm4.mul(dm3);


        } catch (MatrixDimensionException e) {
            e.print();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (MatrixException ex) {
            ex.mul().printMatrix();
        }


    }
}

