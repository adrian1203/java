package lab9.wielowatkowy;

import java.io.*;
import java.net.*;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {


    public Socket echoSocket = null;
    public PrintWriter out = null;
    public BufferedReader in = null;

    public void connect() {
        try {
            echoSocket = new Socket("localhost", 6669);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }
    }

    public void echo() throws IOException {
        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;

        System.out.println("Type a message: ");
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("echo: " + in.readLine());
        }
        stdIn.close();
    }
    public void zaloguj(String user) throws IOException {
        File filee = new File("C:/Users/Adrian/Desktop/pliki/serwer/haslo.txt");
        Scanner in = new Scanner(filee);
        String haslo=in.nextLine();
        while(!haslo.isEmpty()){
            System.out.println(haslo);
            if(login(user, haslo).length()==10){System.out.println("ID="+login(user, haslo));break;};
            haslo=in.nextLine();
        }
    }
    public void close() throws IOException {
        out.close();
        in.close();

        echoSocket.close();
    }
    String login(String login, String password) throws IOException {
        out.println("LOGIN "+login+";"+password);
        String ID=in.readLine();
        return ID;
    }
    String logout(String id) throws IOException {
        connect();
        out.println("LOGOUT "+id);
        String answer=in.readLine();
        return answer;
    }
    String ls(String id) throws IOException {
        connect();
        out.println("LS "+id);
        String answer=in.readLine();
        return answer;
    }
    String get(String id, String file) throws IOException {
        connect();
        out.println("LS "+id+" "+file);
        String answer=in.readLine();
        return answer;
    }

}

