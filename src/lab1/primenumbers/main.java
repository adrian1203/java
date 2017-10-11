package lab1.primenumbers;

import myPackage.JIn;

public class main {
    public static void main(String [] args){
        System.out.println("Podaj górny zakres liczb:");
        int tmp= JIn.getInt();
        LiczbyPierwsze liczba=new LiczbyPierwsze(tmp);
        liczba.PrintPrimeNumbers();
    }
}
