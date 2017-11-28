package lab3.ex2;

import java.awt.*;
import java.util.Comparator;

public abstract class  Shape implements Comparator<Shape>{
    public int x,y;
    Shape(int   x, int y){
        this.x=x;
        this.y=y;
    }
    public  abstract void draw(Graphics2D graphics2D);
    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.x>o2.x){return 1;}
        if(o1.x<o2.x){return -1;}
        else return 0;
    }
}
