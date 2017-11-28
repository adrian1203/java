package my.test;

public class A {
    public A(int a) throws Err {
        if (a > 9) {
            throw new Err();
        }
    }
}
