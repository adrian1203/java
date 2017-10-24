package lab5.ex12;

public class MatrixException extends Exception {
    private DummyMatrix m1;
    private DummyMatrix m2;

    public MatrixException(DummyMatrix m1, DummyMatrix m2) {
        this.m1 = m1;
        this.m2 = m2;

    }

    DummyMatrix mul() {
        if (m1.y > m2.x) {
            DummyMatrix new_m2 = new DummyMatrix(m1.y, m2.y);
            for (int i = 0; i < m1.y; i++) {
                for (int j = 0; j < m2.y; j++) {
                    if (i > m2.x-1 ) {
                        new_m2.tab[i][j] = 1;
                        System.out.println(i+" "+j);
                    } else {
                        new_m2.tab[i][j] = m2.tab[i][j];
                        System.out.println(i+"a tutuaj "+j);
                    }

                }
            }
                DummyMatrix matrix = new DummyMatrix(m1.x, new_m2.y);
                int p, j, k;
                for (p = 0; p < m1.x; p++)
                    for (j = 0; j < matrix.y; j++) {

                        for (k = 0; k < m1.y; k++)
                            matrix.tab[p][j] += m1.tab[p][k] * new_m2.tab[k][j];
                    }

                return matrix;


        } else {
            DummyMatrix new_m1 = new DummyMatrix(m1.x, m2.x);
            for (int i = 0; i < m1.x; i++) {
                for (int j = 0; j < m2.y; j++) {
                    if (j > m1.y) {
                        new_m1.tab[i][j] = 1;
                    } else {
                        new_m1.tab[i][j] = m2.tab[i][j];
                    }
                }
            }
            DummyMatrix matrix = new DummyMatrix(new_m1.x, m2.y);
            int p, j, k;
            for (p = 0; p < m1.x; p++)
                for (j = 0; j < matrix.y; j++) {

                    for (k = 0; k < m1.y; k++)
                        matrix.tab[p][j] += new_m1.tab[p][k] * m2.tab[k][j];
                }
            return matrix;
        }
    }
}


