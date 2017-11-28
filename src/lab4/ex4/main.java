package lab4.ex4;

import myPackage.JIn;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException{
        Cryptographer tmp= new Cryptographer();
        ROT11 rot= new ROT11();
        Polibiusz pol=new Polibiusz();

        //tmp.crypyfile("C:/Users/Adrian/Desktop/pliki/pusty.txt","C:/Users/Adrian/Desktop/pliki/szyfr.txt", rot );
        //tmp.decrypyfile("C:/Users/Adrian/Desktop/pliki/szyfr.txt", "C:/Users/Adrian/Desktop/pliki/deszyfr.txt", rot);

       tmp.crypyfile("C:/Users/Adrian/Desktop/pliki/pusty.txt","C:/Users/Adrian/Desktop/pliki/szyfr1.txt", pol );
       tmp.decrypyfile("C:/Users/Adrian/Desktop/pliki/szyfr1.txt", "C:/Users/Adrian/Desktop/pliki/deszyfr1.txt", pol);

    }
}
