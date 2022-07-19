/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;

import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ResetPassController implements Initializable {

    @FXML
    private JFXButton reset;
    @FXML
    private JFXButton backLog;
    @FXML
    private JFXButton btnVer;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField txtVer;
    int randomCode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
     private static ResetPassController instance;

    public ResetPassController() {
        instance = this;
    }
 public static ResetPassController getInstance() {
        return (instance);
    }

    public  String email() {
        return email.getText();
        
    }
    public void backLoginAction(ActionEvent e1) throws IOException {
        backLog.getScene().getWindow().hide();
        Stage backLog = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));
        Scene scene = new Scene(root);
        backLog.setScene(scene);
        backLog.show();
        backLog.setResizable(false);
    }

    public void verif_code() {
        try {
            Random rand = new Random();
            randomCode = rand.nextInt(999999);
            String host = "smtp.gmail.com";
            String user = "chiraz.wesleti@esprit.tn";
            String pass = "CH211SFT0197";
            String to = email.getText();
            String subject = "reseting pass";
            String message = "your reset code is " + randomCode;
            boolean sessionDebug = false;
            Properties pros = System.getProperties();
            pros.put("mail.smtp.starttls.enable", "true");
            pros.put("mail.smtp.auth", "true");
            // pros.put("mail.smtp.host", "host");
            pros.put("mail.smtp.host", "smtp.gmail.com");
            pros.put("mail.smtp.port", "587");
            pros.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            pros.put("mail.smtp.debug", "true");
            pros.put("mail.smtp.ssl.protocols", "TLSv1.2");

            pros.put("mail.smtp.starttls.required", "true");
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(pros, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(user));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);

            msg.setSubject(subject);
            msg.setText(message);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("code has been send to the email");
            alert.show();
            System.out.println("si bon");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex);
        }
    }

    public void verifier_c() throws IOException {
        if (Integer.valueOf(txtVer.getText()) == randomCode) {

            System.out.println("omda "+email.getText());
            System.out.println("eooo" + randomCode);

            try {
                btnVer.getScene().getWindow().hide();
                Stage newP = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("../views/Reset.fxml"));
                Scene scene = new Scene(root);
                newP.setScene(scene);
                newP.show();
                newP.setResizable(false);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Code do not match");
            alert.show();
        }
    }

}
