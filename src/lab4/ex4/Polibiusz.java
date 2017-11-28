package lab4.ex4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polibiusz implements Algorithm {
    static final char[][] polibiuszMatrix = {{'A', 'B', 'C', 'D', 'E'},
            {'F', 'G', 'H', 'I', 'K'},
            {'L', 'M', 'N', 'O', 'P'},
            {'Q', 'R', 'S', 'T', 'U'},
            {'V', 'W', 'X', 'Y', 'Z'}};

    public int checkNumber(char a) {
        int numer = 0;
        if (a == 'J') a = 'I';
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (a == polibiuszMatrix[i][j]) {
                    numer = 10 * (i + 1) + (j + 1);
                }
        return numer;
    }

    @Override
    public String crypt(String word) {
        String tmpWord = "";
        word = word.toUpperCase();
        char[] wordChar = word.toCharArray();
        for (int i = 0; i < wordChar.length; i++) {
            if (checkNumber(wordChar[i]) != 0) {
                tmpWord += checkNumber(wordChar[i]) + " " ;
            }

        }
        return tmpWord;


    }

    @Override
    public String decrypt(String word) {
        //System.out.print(word+"..");
        Pattern pattern=Pattern.compile("((\\d{2}))");
        Matcher matcher=pattern.matcher(word);
        boolean tmp1=matcher.find();
        if (tmp1=true) {
            int tmp = Integer.parseInt(matcher.group(1));
            String w = "";
            int y = (tmp % 10)-1;
            //System.out.println(y);
            int x = (tmp / 10)-1;
            //System.out.println(x);
            w += polibiuszMatrix[x][y];
            //System.out.println(w);*/
            return w;
        } else return "  ";

    }
}

