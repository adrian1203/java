package lab5.subtitle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test  {
    public static void main(String[] args) throws IOException {
        try {
            MicroDvd dvd=new MicroDvd();
            dvd.deley("C:/Users/Adrian/Desktop/pliki/orginal.txt","C:/Users/Adrian/Desktop/pliki/in.txt",300,25);
        }
        catch (DiffrentFormat e){
            e.print();
        }
        catch (SubtitleEndBeforeStart e){
            e.print();
        }




    }
}
