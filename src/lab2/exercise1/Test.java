package lab2.exercise1;

import lab2.exercise1.pkg1.*;
import lab2.exercise1.pkg2.*;

public class Test {
    public static void main(String[] args) {
        A a = new A("aaa", 2);
        B b = new B();
        C c = new C();
        a.callincrement();
        b.callincrement();
        c.callincrement();

    }
}
