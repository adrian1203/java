package lab6.kształty;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(List list){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600,600);
        add(new MyPanel(list));
    }
}
