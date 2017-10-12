package lab2.Crossword;

import java.io.IOException;
import java.util.Collections;

public class main {
    public static void main(String [] args)throws IOException{
        //CwDB tmp=new CwDB("C:/Users/Adrian/Desktop/cwdb.txt");
        InteliCwDB tmp1=new InteliCwDB("C:/Users/Adrian/Desktop/cwdb.txt");
        //Entry cos=tmp1.getRandom("^A.*");
        tmp1.Print();

    }
}
