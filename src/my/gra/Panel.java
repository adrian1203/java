package my.gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements ActionListener {
    private JButton p1;
    private JButton p2;
    public Panel(){
        setPreferredSize(new Dimension(400, 400));
         p1=new JButton("1555555555");
         p2= new JButton("255555555555");
        p1.addActionListener(this);
        p2.addActionListener(this);
        add(p1);
        add(p2);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object source=e.getSource();
        if(source==p1){
            p1.setBackground(Color.GREEN);
        }
        if(source==p2){
            p2.setBackground(Color.BLUE);
        }
    }
}
