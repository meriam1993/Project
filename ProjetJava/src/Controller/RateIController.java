/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entite.rate;
import entite.user;
import service.RateService;
import service.UserService;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author user
 */
public class RateIController implements Initializable {
 @FXML
    private Rating rateS;

    @FXML
    private Label LabelI;

    @FXML
    private JFXButton btnSubmit;
    RateService rs=new RateService();
    UserService us=new UserService();
     public void Init(){
//           UserService us=new UserService();
         String n=LoginController.getInstance().email();

       System.out.println(us.getbyEmail(n));
    try{
         LabelI.setText(us.getbyEmail(n).getInitial1());
         
    }catch(Exception e){
              System.out.println("error "+e.getMessage());    }}
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Init();
    
    }    
    
     @FXML
    void SubmitRate(ActionEvent event) {
        try{
             UserService us=new UserService();
           user u=us.getIdByMail(LoginController.getInstance().email()); 
            rate r=new rate(u, (int) rateS.getRating());
            RateService rs=new RateService();
            rs.insert(r);
         System.out.println("Number stars by user"+rateS.getRating());
         
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setContentText("Thanks,your rate has been registered successfully");
                alert.show();
        }catch(Exception e){
            System.out.println(e); } }
}
