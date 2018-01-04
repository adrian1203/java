package lab9.wielowatkowy;

import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class NewThread implements Runnable {
    String haslo="ab";
    Socket clientSocket = null;
    Thread       runningThread= null;
    public String id;
    public int levenshtein(String s, String t)
    {
        int i, j, m, n, cost;
        int d[][];

        m = s.length();
        n = t.length();

        d = new int[m+1][n+1];

        for (i=0; i<=m; i++)
            d[i][0] = i;
        for (j=1; j<=n; j++)
            d[0][j] = j;

        for (i=1; i<=m; i++)
        {
            for (j=1; j<=n; j++)
            {
                if (s.charAt(i-1) == t.charAt(j-1))
                    cost = 0;
                else
                    cost = 1;

                d[i][j] = Math.min(d[i-1][j] + 1,         /* remove */
                        Math.min(d[i][j-1] + 1,      /* insert */
                                d[i-1][j-1] + cost));   /* change */
            }
        }

        return d[m][n];
    }
    public String login(String log){
        String[] splitedArray = null;
        splitedArray=log.split(";");
        if(splitedArray.length==2){
        if(splitedArray[0].equals("serwer") && splitedArray[1].equals(haslo)){
            Random generator = new Random();
            id="";
            for(int i=0;i <10;i++){
                int tmp=generator.nextInt(9);
                id=id+Integer.toString(tmp);

            }
            return id;
        }
        else{return Integer.toString(levenshtein(haslo, splitedArray[1]));}}
        else{return "Nieznane polecenie";}
    }
    public String logout(String id){
        if(id.equals(this.id)){
            this.id="";
            return "true";}
        else{
            return "false";}
    }
    public String ls(String id){
        if(id.equals(this.id)) {
            File file = new File("C:/Users/Adrian/Desktop/pliki/serwer");
            String[] lista = file.list();
            String files = "";
            for (String x : lista) {
                files = files + x+";";
            }

            return files;}
        else{
                return "false";
            }
        }
    public String get(String id, String plik) throws FileNotFoundException {
        if(id.equals(this.id)){
            File file = new File("C:/Users/Adrian/Desktop/pliki/serwer");
            String[] lista = file.list();
            for (String x : lista) {
                if(x.equals(plik)){
                    File filee = new File("C:/Users/Adrian/Desktop/pliki/serwer/"+plik);
                    Scanner in = new Scanner(filee);
                    return in.nextLine();
                }
            }
            return "false";
            }
        else{
            return "false";}
    }

    public NewThread(Socket socket){
        this.clientSocket=socket;

    }
    @Override
    public  void run() {
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                String[] splitedArray = null;
                splitedArray=inputLine.split(" ");
                String tmp=splitedArray[0];

                if(tmp.equals("LOGIN") && splitedArray.length==2  ){
                    out.println(login(splitedArray[1]));
                }
                else if(tmp.equals("LOGOUT")&& splitedArray.length==2){
                    out.println(logout(splitedArray[1]));
                }
                else if(tmp.equals("LS") && splitedArray.length==2){
                    out.println(ls(splitedArray[1]));
                }
                else if(tmp.equals("GET")&& splitedArray.length==3){
                    out.println(get(splitedArray[1], splitedArray[2]));
                }
                else {
                    out.println("Nieznane polecenie");
                }
            }
            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}