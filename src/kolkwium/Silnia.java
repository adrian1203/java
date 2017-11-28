package kolkwium;

import java.util.Stack;

public class Silnia extends Operator1Arg {
    public double oblicz(Stack<Operator> o){
        double wart=o.pop().oblicz(o);

        return fact(wart);
    }
    public double fact(double a){
        if (a < 1)
            return 1;
        else
            return a * fact(a - 1);
    }
}
