package lab5.ex12;

import lab1.Matrix.Matrix;

import java.io.IOException;

public class DummyMatrix extends Matrix {


    public DummyMatrix(String filenmae) throws IOException {
        super(filenmae);
    }

    public DummyMatrix(int x, int y) {
        super(x, y);
    }

    public DummyMatrix() {
        super();
    }

    public DummyMatrix mul(DummyMatrix m) throws MatrixException {
        if (this.y != m.x) {
            throw new MatrixException(this, m);
        }
        DummyMatrix matrix = new DummyMatrix(x, m.y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < m.y; j++) {
                for (int k = 0; k < y; k++) {
                    matrix.tab[i][j] += tab[i][k] * m.tab[k][j];
                }
            }
        }
        return matrix;
    }
}

