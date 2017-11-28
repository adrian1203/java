package kolkwium;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class WeWY  {
    public Stack<Operator> stos;
    public Stack<Operator> pobierzDzialanie() throws IOException{
        BufferedReader br= new BufferedReader(new FileReader("plik.txt"));
        String linia=br.readLine();
        for (int i = 0, n = linia.length(); i < n; i++) {
            char c = linia.charAt(i);
            Operator tmp=new Operator();
            tmp.wartosc=String.valueOf(new char[]{c});
            stos.push(tmp);
        }
        return stos;
    }
    }

