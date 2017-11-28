package lab3.ex2;
import java.awt.*;
import java.lang.*;
public class square extends Shape {
    public square(int  x, int y){
        super(x,y);
    }
    public  void draw(Graphics2D graphics2D){
        graphics2D.drawRect(x,y,50,50);
    }

}
