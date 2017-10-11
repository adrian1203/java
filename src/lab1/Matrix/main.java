package lab1.Matrix;
import myPackage.*;
public class main {
    public static void main(String [] args){

        Matrix matrix1=new Matrix();
        Matrix matrix2=new Matrix();
        System.out.print("pierwsza macierz\n");
        matrix1.printMatrix();
        System.out.print("Druga macierz\n");
        matrix2.printMatrix();
        System.out.print("Dodawanie:\n");
        matrix1.add(matrix2).printMatrix();
        System.out.print("Odejmowanie:\n");
        matrix2.sub(matrix1).printMatrix();
        System.out.print("Mnożenie:\n");
        matrix1.mul(matrix2).printMatrix();
    }
}
