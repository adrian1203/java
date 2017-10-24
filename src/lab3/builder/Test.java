package lab3.builder;

import javafx.scene.media.MediaException;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) throws MessagingException {
        LinkedList<String> list = new LinkedList<String>();
        list.add("adrian.opiela11@gmail.com");
        list.add("adrian.opiela11@gmail.com");
        EmailMessage wiadomosc = EmailMessage.builder()
                .addfrom("spamowanie1234")
                .addto("adrian.opiela11@gmail.com")
                .addsubject("Mail testowy")
                .addcontent("Brak tresci")
                .build();
        wiadomosc.send();
    }


}
