package lab6.kształty;

import lab3.ex2.*;
import lab3.ex2.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener {
    circle kolo;
    rectangle prostokat;
    square kwadrat;
    Shape movingPoint;
    ArrayList<Point> points = new ArrayList<Point>();
    public List list;

    public MyPanel(List list) {
        this.list = list;
        setPreferredSize(new Dimension(600, 600));
       /* kolo = new circle(10, 10);
        prostokat = new rectangle(100, 100);
        kwadrat = new square(200, 200);*/

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        for (Shape x : list.lista) {
            x.draw(graphics2D);
        }
      /*  kolo.draw(graphics2D);
        prostokat.draw(graphics2D);
        kwadrat.draw(graphics2D);*/
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }



    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("klikeeeeeeeeeeeee");
        int x1 = e.getX();
        int y1 = e.getY();
        //int x2, y2;
        int index = 0;
        int size = list.lista.size();
        System.out.println(size);
        Point p;
        index=0;
        for(Shape shape: this.list.lista){
            int y2 = shape.y;
            int x2 = shape.x;

            if (x1 >= x2 && y1 >= y2 && x1 <= x2 + 100 && y1 <= y2 + 100) {
                movingPoint = shape;
                this.list.lista.remove(shape);

            }
       }
        repaint();

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("klik");
        if (movingPoint != null) {
            System.out.println("klik");
            movingPoint.x = e.getX();
            movingPoint.y = e.getY();
            list.lista.add(movingPoint);
            repaint();
        }
    }
}
