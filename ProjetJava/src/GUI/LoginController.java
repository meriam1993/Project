/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.user;
import service.UserService;
import utils.DataSource;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXButton signup;
    @FXML
    private  JFXTextField username;
    @FXML
    private JFXButton resetPass;
    @FXML
    private JFXButton login;
    @FXML
    private JFXButton register;
    @FXML
    private JFXPasswordField Motdepasse;
     @FXML
    private Label labelInit;

    static Connection conn = DataSource.getInstance().getCon();
    static PreparedStatement pst;

    private static LoginController instance;

    public LoginController() {
        instance = this;
    }
    user U=new user();
//          public void Init(){
//     String val= U.getInitial();
//       System.out.println(val);
//    try{
//         labelInit.setText(val);}
//          catch(Exception e){
//              System.out.println("error chiraz"+e.getMessage());    }}
    public static LoginController getInstance() {
        return (instance);
    }

    public  String email() {
        return username.getText();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    public void LoginAction(ActionEvent e) throws IOException, SQLException {
        UserService us=new UserService();
        if (us.CheckEmailExist(username.getText())==true) {
            login.getScene().getWindow().hide();
            Stage home = new Stage();
            try {
                 

                Parent root = FXMLLoader.load(getClass().getResource("Main_1.fxml"));
                Scene scene = new Scene(root);
                home.setScene(scene);
//              Init();
                home.show();
             
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("ya khra");
                alert.show();
              

        }
    }

    public void resetPassAction(ActionEvent e1) throws IOException {
        login.getScene().getWindow().hide();
        Stage resetPass = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/ResetPassword.fxml"));
        Scene scene = new Scene(root);
        resetPass.setScene(scene);
        resetPass.show();
        resetPass.setResizable(false);
    }

    public void RegisterAction(ActionEvent e1) throws IOException {
        login.getScene().getWindow().hide();
        Stage register = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/SignIn.fxml"));
        Scene scene = new Scene(root);
        register.setScene(scene);
        register.show();
        register.setResizable(false);
    }

}
