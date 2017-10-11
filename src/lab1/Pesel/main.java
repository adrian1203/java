package lab1.Pesel;
import myPackage.*;
public class main {
    public static void main(String [] args){
        System.out.println("Podaj pesel");
        String tmp=JIn.getString();
        PESEL pesel=new PESEL(tmp);
        if(pesel.check()==true){
            System.out.println("Ok");
        }else{
            System.out.println("Bład w PESEL");
        }
    }
}
