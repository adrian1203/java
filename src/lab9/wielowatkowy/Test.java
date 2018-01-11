package lab9.wielowatkowy;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        EchoClient echoClient = new EchoClient();
        echoClient.connect();
        echoClient.echo();
        echoClient.close();
    }
}