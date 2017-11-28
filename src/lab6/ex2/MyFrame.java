package lab6.ex2;

import javax.swing.*;
import java.util.ArrayList;

public class MyFrame extends JFrame{
    ArrayList<Double> lista;
    int top;
    int down;
    int coile;
    MyFrame(ArrayList<Double> lista, int down, int top, int ile){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600,600);
        add(new MyPanel(lista, down, top, ile));
    }

}
