package lab9.obslugaSerwera;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        EchoClient echoClient=new EchoClient();
        echoClient.connect();
        echoClient.echo();
        echoClient.close();
    }
}
