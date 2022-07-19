/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author meria
 */
public class JavaMailUtil {
    
    public static void sendMail(String recepient) throws Exception{
        
        System.out.println("Preparing to send the email");
        Properties properties= new Properties();
         
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        String myAccountEmail="chiheb.nahdi@esprit.tn";
        String password="aze112233A";
        
        Session session=Session.getInstance(properties,new Authenticator(){
             
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication (myAccountEmail,password); 
                }       
            });
    
    Message message = prepareMessage(session,myAccountEmail,recepient);
    Transport.send(message);
    System.out.println("Message Sent");
    }
    
    public static Message prepareMessage(Session session,String myAccountEmail,String recepient){
        
        try {
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Flight Reservation");
            message.setText("");
            return message;
            
        } catch (Exception ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }                                                                                                          
}
