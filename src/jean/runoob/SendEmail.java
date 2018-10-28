package jean.runoob;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {
    public static void sendEmail(){

        String to = "chenshuaijunpp@126.com";
        String from = "957766762@qq.com";
        String host = "localhost";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        try{
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("This is the Subject Line!");

            message.setContent("<h1>This is actual message</h1>!", "text/html");

            Transport.send(message);
            System.out.println("Send message successfully...");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public static void sendHtmlEmail(){
        String to = "chenshuaijunpp@126.com";
        String from = "957766762@qq.com";
        String host = "localhost";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("This is the Subject Line!");
            message.setContent("<h1>This is actual message</h1>", "text/html");

            Transport.send(message);
            System.out.println("Sent message successfully...");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public static void sendFileEmail(){
        String to = "chenshuaijunpp@126.com";
        String from = "957766762@qq.com";
        String host = "localhsot";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("This is the Subject Line!");
            BodyPart bodyPart = new MimeBodyPart();
            ((MimeBodyPart) bodyPart).setText("This is message body");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(bodyPart);

            bodyPart = new MimeBodyPart();
            String filename = "README.md";
            DataSource source = new FileDataSource(filename);
            bodyPart.setDataHandler(new DataHandler(source));
            bodyPart.setFileName(filename);
            multipart.addBodyPart(bodyPart);
            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Sent message successfully...");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public static void sendMailQQ(){
        String to = "chenshuaijunpp@126.com";
        String from = "957766762@qq.com";
        String host = "smtp.qq.com";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("957766762@qq.com", "belbuxndgkezbbgf");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("This is the Subject Line!");
            message.setText("This is actual message");

            Transport.send(message);
            System.out.println("Send message successfully.....from runoob.com");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        sendEmail();
//        sendHtmlEmail();
//        sendFileEmail();
        sendMailQQ();
    }
}
