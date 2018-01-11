package lab9.wielowatkowy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


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

        System.out.println("PODAJ KOMENDE: ");
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("ODPOWIEDŹ: " + in.readLine());
        }
        stdIn.close();
    }



    public void close() throws IOException {
        out.close();
        in.close();

        echoSocket.close();
    }





}

