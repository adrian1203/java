package lab3.ex2;

import java.awt.*;

public class rectangle extends Shape {
    public rectangle(int x, int y){
        super(x,y);
    }
    public void draw(Graphics2D graphics2D){
   graphics2D.drawRect(x,y,50,100);

    }

}
