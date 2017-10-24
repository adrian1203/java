package lab4.ex1and2;

import lab3.ex2.Shape;

import java.util.Comparator;

public class MyComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.size>o2.size){return 1;}
        if(o1.size<o2.size){return -1;}
        else return 0;
    }
}
