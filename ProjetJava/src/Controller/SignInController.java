/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entite.user;
import service.UserService;
import utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import com.jfoenix.validation.RequiredFieldValidator;
import java.sql.SQLException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class SignInController implements Initializable {

    @FXML
    private AnchorPane parentPane;
    @FXML
    private JFXTextField EntrerPrenom;
    @FXML
    private JFXTextField EntrerNom;
    @FXML
    private JFXTextField entrerUsername;
    @FXML
    private JFXPasswordField EntrerMotdepasse;

    @FXML
    private JFXButton signup;

    static Connection conn = DataSource.getInstance().getCon();

    static PreparedStatement pst;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        RequiredFieldValidator val = new RequiredFieldValidator();


        EntrerPrenom.getValidators().add(validator);
        validator.setMessage("Aucune valeur entrée !");
        EntrerPrenom.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

                if (!newValue) {
                    EntrerPrenom.validate();
                }

            }
        });

        EntrerMotdepasse.getValidators().add(val);
        val.setMessage(" caractéres spéciaux interdits !");
        EntrerMotdepasse.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

                if (!newValue ) {

                    EntrerMotdepasse.validate();

                }

            }
        });

        entrerUsername.getValidators().add(validator);
        validator.setMessage("Aucune valeur entrée !");
        entrerUsername.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override

            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

                if (!(newValue) ) {
                    entrerUsername.validate();

                }

            }
        });

    }

    @FXML
    public void SignUP(ActionEvent event) throws IOException, SQLException {
        try {
            user p = new user(EntrerPrenom.getText(), EntrerNom.getText(), entrerUsername.getText(), EntrerMotdepasse.getText());
            UserService Us = new UserService();
            if ((Us.CheckEmailExist(entrerUsername.getText()) == false) && (!EntrerPrenom.getText().isEmpty())) {

                Us.insert(p);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setContentText("Registration successfully");
                alert.show();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Login.fxml"));
                Parent root = loader.load();
                signup.getScene().setRoot(root);
            } else if (Us.CheckEmailExist(entrerUsername.getText()) == true) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Email already exist");
                alert.show();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/SignIn.fxml"));
                Parent root = loader.load();
                signup.getScene().setRoot(root);
            }

        } catch (Exception E) {
            E.printStackTrace();
        }

    }
}
