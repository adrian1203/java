package lab6.ex2;

import myPackage.JIn;

import javax.print.attribute.standard.MediaSize;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("Podaj liczbe wspolcynnikow:");
        int ile= JIn.getInt();
        System.out.println("Podaj kolejne wspołczynnniki ");
        ArrayList<Double> lista= new ArrayList<Double>();
       for(int i=0;i<ile;i++){
           lista.add(JIn.getDouble());
       }
        System.out.println("Podaj probkowanie:");
        int coile= JIn.getInt();
        System.out.println("Podaj dolny zakres:");
        int down= JIn.getInt();
        System.out.println("Podaj gorny zakres:");
        int top= JIn.getInt();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame(lista,down,top,coile);
            }
        });
    }
}
