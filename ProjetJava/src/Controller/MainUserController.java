/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import entite.user;
import service.UserService;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


/**
 * FXML Controller class
 *
 * @author meria
 */
public class MainUserController implements Initializable {
   
    @FXML
    private BorderPane mainPane;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button Flight_Page;
     @FXML
    private Button ClientsPage;
    @FXML
    private Label labelInit;
     
    @FXML
     public void handleButton1Action(ActionEvent event) throws IOException{
   
     FxmlLoader object=new FxmlLoader();
     Pane view = object.getPage("../views/FlightUser.fxml");
     mainPane.setCenter(view);
    }
   
    
    public void handleButtonRes(ActionEvent event){
     FxmlLoader object=new FxmlLoader();
     Pane view = object.getPage("../views/Flight_Reservations.fxml");
     mainPane.setCenter(view);
    }
    
    public void Init(){
       UserService us=new UserService();
       String n=LoginController.getInstance().email();
       System.out.println(us.getbyEmail(n));
        try{
        labelInit.setText(us.getbyEmail(n).getInitial1());
         
        }catch(Exception e){
              System.out.println("error"+e.getMessage());    }}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Init();
     
    }
    
    @FXML
    private void handleButton2Action(ActionEvent event)  throws IOException{
     FxmlLoader object=new FxmlLoader();
     Pane view = object.getPage("../views/HotelUser.fxml");
     mainPane.setCenter(view);
    }

    @FXML
    private void handleButton3Action(ActionEvent event)  throws IOException{
     FxmlLoader object=new FxmlLoader();
     Pane view = object.getPage("../views/Market.fxml");
     mainPane.setCenter(view);
        
    }
    @FXML
    private void handleButton4Action(ActionEvent event)  throws IOException{
     FxmlLoader object=new FxmlLoader();
     Pane view = object.getPage("../views/RateInterface.fxml");
     mainPane.setCenter(view);
        
    }
    
    @FXML
    private void handleButton5Action(ActionEvent event)  throws IOException{
     FxmlLoader object=new FxmlLoader();
     Pane view = object.getPage("../views/Reservations.fxml");
     mainPane.setCenter(view);
        
    }
  

    
    
    
    
    
    
    
}
    
      