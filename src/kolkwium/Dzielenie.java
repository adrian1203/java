package kolkwium;

import java.util.Stack;

public class Dzielenie extends Operator2Arg {
    public double oblicz(Stack<Operator> o){
        double wart=o.pop().oblicz(o);
        double wart1=o.pop().oblicz(o);
        return wart/wart1;
    }
}
