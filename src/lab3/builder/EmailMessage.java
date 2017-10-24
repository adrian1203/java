package lab3.builder;

import myPackage.JIn;

import java.util.LinkedList;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.util.Properties;


public class EmailMessage {
    private String from;
    private LinkedList<String> to;
    private String subject;
    private String content;
    private String mimeType;
    private LinkedList<String> cc;
    private LinkedList<String> bcc;

    protected EmailMessage(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.subject = builder.subject;
        this.content = builder.content;
        this.mimeType = builder.mimeType;
        this.cc = builder.cc;
        this.bcc = builder.bcc;
    }

    public static class Builder {
        private String from;
        private LinkedList<String> to;
        private String subject = null;
        private String content = null;
        private String mimeType = null;
        private LinkedList<String> cc = null;
        private LinkedList<String> bcc = null;

        Builder() {
        }


        public Builder addfrom(String from) {
            this.from = from;
            return this;
        }

        public Builder addto(LinkedList<String> to) {
            this.to = new LinkedList<String>(to);
            return this;
        }

        public Builder addto(String to) {
            this.to = new LinkedList<String>();
            this.to.add(to);
            return this;
        }

        public Builder addsubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder addcontent(String content) {
            this.content = content;
            return this;
        }

        public Builder addmimeType(String mimeType) {
            this.mimeType = mimeType;
            return this;
        }

        public Builder addcc(LinkedList<String> cc) {
            this.cc = new LinkedList<String>();
            this.cc = cc;
            return this;
        }

        public Builder addbcc(LinkedList<String> bcc) {
            this.bcc = new LinkedList<String>();
            this.bcc = bcc;
            return this;
        }

        public EmailMessage build() {
            return new EmailMessage(this);
        }


    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    public void send() throws MessagingException {
        final String username = "testspamtest135@gmail.com";
        final String password = "TestSpamTest135!";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            for (String x : to) {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(x));
                message.setSubject(subject);
                message.setText(content);

                Transport.send(message);

                System.out.println("Done");
            }

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }


}


