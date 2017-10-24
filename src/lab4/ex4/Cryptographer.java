package lab4.ex4;

import java.io.*;

public class Cryptographer {
    public void crypyfile(String infile, String outfile, Algorithm algo )throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader(infile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outfile));
        String tmp=reader.readLine();
        while(tmp!=null){
            String [] parts=tmp.split(" ");
            for(String x:parts){
                System.out.println(x);
                writer.append(algo.crypt(x));
            }
            tmp=reader.readLine();
        }
        writer.close();



    }
    public void decrypyfile(String infile, String outfile, Algorithm algo )throws IOException{
        BufferedReader reader=new BufferedReader(new FileReader(infile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outfile));
        String tmp=reader.readLine();
        while(tmp!=null){
            String [] parts=tmp.split(" ");
            for(String x:parts){
                //System.out.println(x);
                writer.append(algo.decrypt(x));
            }
            tmp=reader.readLine();
        }
        writer.close();

    }
}
