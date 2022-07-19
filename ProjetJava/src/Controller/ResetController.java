/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entite.user;
import service.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ResetController implements Initializable {
@FXML
    private JFXButton reset2;
    
     @FXML
        private JFXTextField newpass;
     @FXML
        private JFXTextField vpass;
     Connection con=null;
     ResultSet rs=null;
     PreparedStatement pst=null; 
     public String user1;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  
@FXML
    public void resetPass() throws SQLException{
          
        
        if(newpass.getText().equals(vpass.getText())){
        try{
            String rs=ResetPassController.getInstance().email();
        System.out.println("rs"+rs);
            UserService us =new UserService();
            us.newPassword(newpass.getText(),rs);
 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setContentText("Reset successfully");
                alert.show();
     }
        catch(Exception e){
            System.out.println(e); }}
        else{
           Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Password doesn't match");
                alert.show();  }
        
    }



   
}
