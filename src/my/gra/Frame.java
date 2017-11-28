package my.gra;

import javax.swing.*;
import java.awt.*;
import java.awt.Panel;

public class Frame extends JFrame {
    public Frame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(3,3));
        setLocation(50,50);
        setSize(400,400);
        add(new my.gra.Panel());
    }
}
