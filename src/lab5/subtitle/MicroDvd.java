package lab5.subtitle;

import java.io.*;
import java.util.regex.*;

public class MicroDvd {
    public MicroDvd(){}
    public void deley(String in, String out, int deley, int fps)throws IOException,SubtitleEndBeforeStart, DiffrentFormat{
        BufferedReader br=new BufferedReader(new FileReader(in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(out));
        String tmp=br.readLine();
        int value=deley*fps/1000;
        int line=0;
        while (tmp!=null){
            line+=1;
            Pattern pattern=Pattern.compile("\\{(\\d+)\\}\\{(\\d+)\\}(.*)");
            Matcher matcher=pattern.matcher(tmp);
            if (matcher.find()) {
                String tmp1=matcher.group(1);
                String tmp2=matcher.group(2);
                String tmp3=matcher.group(3);
                int value1=Integer.parseInt(tmp1)+value;
                int value2=Integer.parseInt(tmp2)+value;
                if(value1>value2){
                    throw new SubtitleEndBeforeStart(line, tmp);
                }
                /*if(value1>100){
                    throw new MyException(line, tmp);
                }*/
                writer.append("{"+value1+"}{"+value2+"}"+tmp3);

            }
            else {
                throw new DiffrentFormat(line, tmp);
            }
            tmp=br.readLine();
        }
    }
}
