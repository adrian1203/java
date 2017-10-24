package lab2.exercise1.pkg1;

import lab2.exercise1.pkg2.C;

public class main {
    public static void main(String [] args){
        A a=new A("gg", 76);
        B b=new B ();
        C c=new C();
        a.CallchangeName();
        b.CallchangeName();
        c.CallchangeName();
        a.callincrement();
        b.callincrement();
        c.callincrement();
        System.out.println(b.name);

    }
}
