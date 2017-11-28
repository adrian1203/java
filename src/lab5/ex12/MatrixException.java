package lab5.ex12;

public class MatrixException extends Exception {
    private DummyMatrix m1;
    private DummyMatrix m2;

    public MatrixException(DummyMatrix m1, DummyMatrix m2) {
        this.m1 = m1;
        this.m2 = m2;

    }

    DummyMatrix mul() throws MatrixException {
        if (m1.y > m2.x) {
            DummyMatrix new_m2 = new DummyMatrix(m1.y, m2.x);
            for (int i = 0; i < m1.y; i++) {
                for (int j = 0; j < m2.x; j++) {
                    if (i >= m2.y) {
                        new_m2.tab[i][j] = 1;
                    } else {
                        new_m2.tab[i][j] = m2.tab[i][j];
                    }
                }
            }
            return m1.mul(new_m2);


        } else {
            DummyMatrix new_m1 = new DummyMatrix(m1.x, m2.x);
            for (int i = 0; i < m1.x; i++) {
                for (int j = 0; j < m2.x; j++) {
                    if (i >= m1.y) {
                        new_m1.tab[i][j] = 1;
                    } else {
                        new_m1.tab[i][j] = m2.tab[i][j];
                    }
                }
            }
            return new_m1.mul(m2);
        }
    }
}


