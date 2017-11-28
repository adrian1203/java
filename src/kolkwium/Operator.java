package kolkwium;

import java.util.Stack;

public class Operator implements Obliczanie {

    public String wartosc;
    String getWartosc(){
        return "";
    }

    @Override
    public double oblicz(Stack<Operator> o) {
        return o.pop().oblicz(o);
    }
}
