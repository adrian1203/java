package kolos.comarator;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class main {
    public static void main(String[] args) {
        lista li=new lista();
        A a=new A(25);
        A b= new A(369);
        li.add(a);
        LinkedList<A> lista = new LinkedList<>();
        lista.add(a);

        Collections.sort(li.lista, new Comparator<A>() {
            @Override
            public int compare(A o1, A o2) {
                return 0;
            }
        });
    }



}
