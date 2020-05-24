package mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendingEmail{

    public  boolean sendMail(String receiver)
    {
        boolean b = false;
        
        String senderid = "lokeshbagana@gmail.com";
        String senderpass = "7974lokesh";
        
        //1st step) Get the session object	
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");//change accordingly
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",  
                    "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");  
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
         new javax.mail.Authenticator() {
          @Override
          protected PasswordAuthentication getPasswordAuthentication() {
           return new PasswordAuthentication(senderid,senderpass);
           }
        });
        
        //2nd step)compose message
        try {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(senderid));
         message.addRecipient(Message.RecipientType.TO,
                 new InternetAddress(receiver));
         message.setSubject("HomeTutorService is email Varivication link");
         message.setText("verification link");
         message.setText("verification Link:"+"http://localhost:8086/HomeTutorService/ActivationAccount.jsp?key1="+receiver);

         //3rd step)send message
         Transport.send(message);
        
         System.out.println("Done");
         b = true;
         return b;
         } catch (MessagingException e) {throw new RuntimeException(e);}
 

    }
    public  boolean sendMail1(String receiver)
    {
        boolean b = false;
        
        String senderid = "lokeshbagana@gmail.com";
        String senderpass = "7974lokesh";
        
        //1st step) Get the session object	
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");//change accordingly
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",  
                    "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");  
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
         new javax.mail.Authenticator() {
          @Override
          protected PasswordAuthentication getPasswordAuthentication() {
           return new PasswordAuthentication(senderid,senderpass);
           }
        });
        
        //2nd step)compose message
        try {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(senderid));
         message.addRecipient(Message.RecipientType.TO,
                 new InternetAddress(receiver));
         message.setSubject("HomeTutorService is email Varivication link");
         message.setText("verification link");
         message.setText("verification Link:"+"http://localhost:8086/HomeTutorService/changePassword.jsp?key1="+receiver);

         //3rd step)send message
         Transport.send(message);
        
         System.out.println("Done");
         b = true;
         return b;
         } catch (MessagingException e) {throw new RuntimeException(e);}
 

    	}   
}
	

