package lab4.ex4;

import myPackage.JIn;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException{
        Cryptographer tmp= new Cryptographer();
        ROT11 rot= new ROT11();
        Polibiusz pol=new Polibiusz();
        System.out.println("Szyfrowanie polbiusz 1 \n Szyfrowanie ROT11 2 \n Deszyfrwanie polbiusz 3 \n Deszyfrowanie Rot11 4");
        int c=JIn.getInt();
        switch (c){
            case 1:
                tmp.crypyfile(args[0], args[1], pol);
                break;
            case 2:
                tmp.crypyfile(args[0], args[1], rot);
                break;
            case 3:
                tmp.decrypyfile(args[0], args[1], pol);
                break;
            case 4:
                tmp.decrypyfile(args[0], args[1], rot);
        }

    }
}
