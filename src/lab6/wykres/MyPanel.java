package lab6.wykres;
import static java.lang.Math.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel{
    ArrayList<Double> lista;
    int top;
    int down;
    int coile;
    MyPanel( ArrayList<Double> lista, int down, int top, int ile){
        this.top=top;
        this.down=down;
        this.coile=ile;
        this.lista=lista;

        setPreferredSize(new Dimension(600,600));

    }
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D=(Graphics2D)graphics;
        graphics2D.drawLine(10, 10, 10, 590);
        graphics2D.drawLine(10, 300, 590, 300);
        int wynik1=0;
        int wynik2=0;
        int li=0;
        for(int j=lista.size()-1; j>0;j--){
            wynik1+=pow(down,j)*lista.get(li);
            li++;
        }
        for(int i=down;i<top;i+=coile){

            wynik2=0;
            li=0;
            for(int j=lista.size()-1; j>0;j--){
                wynik2+=pow(i,j)*lista.get(li);
                li++;
            }
            System.out.println(wynik1+"to jest jeden");
            System.out.println(wynik2+"to jest dwa");
            graphics2D.drawLine(i+300,-wynik1/100+300, i+301, -wynik2/100+300);
            wynik1=wynik2;

        }


    }
}
