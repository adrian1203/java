package kolos.wzrozecbuilder;

import kolos.wzrozecbuilder.A;

public class main {

    public static void main(String[] args) {
        A a=A.builder().adda(25).addb(25).build();
        System.out.println("działa");
    }
}
