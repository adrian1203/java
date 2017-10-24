package lab2.Point;

import myPackage.JIn;

import java.util.LinkedList;
public class Test {


    public static void main(String[] args) {
        LinkedList<Punkt3D> punkty=new LinkedList<Punkt3D>();
        int button = 0;
        while (button != 4) {
            System.out.println("Wybierz odpowiedni numer \n 1.Wczytaj punkt 3D \n 2.Wyświetl wszytstkie punkty \n 3.Oblcz odległośc \n 4.Zakończ");
            button= JIn.getInt();
            if(button==1){
                System.out.println("Podaj współrzędne punktu:");
                Punkt3D punkt=new Punkt3D(JIn.getDouble(),JIn.getDouble(),JIn.getDouble());
                punkty.add(punkt);

            }
            if(button==2){
                for(Punkt3D x: punkty){
                    System.out.println("Współrzędne punktu: "+x.getX()+ ","+x.getY()+","+x.getZ());
                }
            }
            if(button==3 && punkty.size()>1){
                System.out.println("Dystans to:"+(punkty.getFirst().distance(punkty.get(1))));
            }
        }
    }
}