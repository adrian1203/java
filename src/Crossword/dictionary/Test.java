package Crossword.dictionary;

import java.io.IOException;

public class Test {
    public static void main(String [] args) throws IOException{
        InteliCwDB tmp=new InteliCwDB("C:/Users/Adrian/Desktop/cwdb.txt");
        tmp.Print();
    }
}
