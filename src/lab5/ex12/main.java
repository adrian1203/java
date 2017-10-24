package lab5.ex12;

        import java.io.IOException;

public class main {
    public static void main(String[] args){
        try {
            DummyMatrix m = new DummyMatrix();
            DummyMatrix m1 = new DummyMatrix("C:/Users/Adrian/Desktop/matrix.txt");
            //m1.printMatrix();
            m.mul(m1);

        } /*catch (MatrixDimensionException e) {
            e.print();
        }*/
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        catch (MatrixException ex){
            ex.mul().printMatrix();
        }



    }
}

