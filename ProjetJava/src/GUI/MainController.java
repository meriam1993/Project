package GUI;

import Entity.Vol;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import service.VolService;

/**
 * FXML Controller class
 *
 * @author meria
 */
public class MainController implements Initializable {
    
    
   
    
    @FXML
    private BorderPane mainPane;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button Flight_Page;
    
    
    @FXML
    public void handleButton1Action(ActionEvent event) throws IOException{
   
     FxmlLoader object=new FxmlLoader();
     Pane view = object.getPage("Flights.fxml");
     mainPane.setCenter(view);
    }
    
    public void handleButtonRes(ActionEvent event){
     FxmlLoader object=new FxmlLoader();
     Pane view = object.getPage("Flight_Reservations.fxml");
     mainPane.setCenter(view);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    
    }    
    
    
    
    
    
    
    
    
    
}
    
      