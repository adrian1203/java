package lab6.ex1;

import lab3.ex2.circle;
import lab3.ex2.rectangle;
import lab3.ex2.square;

import java.awt.*;

public class Test {
    public static void main(String[] args) {
        List list = new List();
        circle a = new circle(10,10);
        rectangle b = new rectangle(100,100);
        square c = new square(200,200);
        list.add(a);
        list.add(b);
        list.add(c);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame(list);
            }
        });
    }
}
