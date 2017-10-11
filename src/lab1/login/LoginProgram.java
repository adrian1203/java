package lab1.login;


import java.io.*;
public class LoginProgram {
    public static void main(String[] argv){
        Login log = new Login ("ala", "makota");
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);
            System.out.println("Podaj login:");
            String login = bfr.readLine();
            System.out.println("Podaj haslo:");
            String haslo = bfr.readLine();
        if(log.check(login, haslo)==true){
            System.out.print("Ok");
        }
        else{
            System.out.print("Zły login lub haslo");
        }
        }catch(IOException e){e.printStackTrace();}

    }
}

