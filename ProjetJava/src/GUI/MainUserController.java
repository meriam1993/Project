/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author meria
 */
public class MainUserController implements Initializable {

    @FXML
    private Button Flight_Page;
    @FXML
    private BorderPane mainPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButton1Action(ActionEvent event) throws IOException {
     FxmlLoader object=new FxmlLoader();
     Pane view = object.getPage("FlightUser.fxml");
     mainPane.setCenter(view);
    }
    
}
