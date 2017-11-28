package my.intefejs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class MyPanel extends JPanel implements ActionListener {
    private JButton greenButton;
    private JButton blueButton;
    private JButton redButton;
   public MyPanel(){
       greenButton=new JButton("zielony");
       blueButton= new JButton("niebieski");
       greenButton.addActionListener(this);
       blueButton.addActionListener(this);
        setPreferredSize(new Dimension(400, 400));
        add(greenButton);
        add(blueButton);

    }
    @Override
    public void actionPerformed(ActionEvent e){
       Object souurce=e.getSource();
       if(souurce==greenButton){
           setBackground(Color.GREEN);
       }
    }


}
