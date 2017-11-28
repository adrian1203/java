package lab3.ex2;

import java.awt.*;

public class circle extends Shape  {
    public circle(int x, int y){
        super(x,y);
    }
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawOval(x,y,50,50);
    }
    }

