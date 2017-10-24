package lab3.ex2;

import java.util.Comparator;

public abstract class  Shape implements Comparator<Shape>{
    public int size;
    Shape(int   name){
        this.size=name;
    }
    public  abstract void draw();
    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.size>o2.size){return 1;}
        if(o1.size<o2.size){return -1;}
        else return 0;
    }
}
