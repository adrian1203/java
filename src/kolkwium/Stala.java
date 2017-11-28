package kolkwium;

import java.util.Stack;

public class Stala extends Operator0Arg {
    public double oblicz(Stack<Operator> o){
        double wart=o.pop().oblicz(o);
        return wart;
    }
}
