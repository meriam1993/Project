/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entite.user;
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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import service.UserService;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author meria
 */
public class AdminController implements Initializable {

    @FXML
    private TableView<user> table;
    @FXML
    private TableColumn<user, Integer> user_id;
    @FXML
    private TableColumn<user, String> role;
    @FXML
    private TableColumn<user, String> first_name;
    @FXML
    private TableColumn<user, String> last_name;
    @FXML
    private TableColumn<user,String > email;
//     @FXML
//    private TableColumn<user,String > password;
//   
     @FXML
    private TextField txt_user_id;

    @FXML
    private TextField txt_role;
    @FXML
    private TextField txt_first_name;
    @FXML
    private TextField txt_last_name;
    @FXML
    private TextField txt_email;
//     @FXML
//    private TextField txt_password;
    @FXML
    private Button btn_ADD;
    
//    private int Vol_idselected;
    @FXML
    private Button btn_DELETE;
    @FXML
    private Button Reservations_Page;
    @FXML
    private Button btn_UPDATE;
    @FXML
    private BorderPane mainPane;
    @FXML
    private AnchorPane rootPane;
    
    //test//
   Integer t;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       String n= LoginController.getInstance().email();
       UserService ps = new UserService();
       ArrayList<user> user_list = ps.getAll();
       ObservableList<user> obs=FXCollections.observableArrayList(user_list);

        user_id.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        first_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        last_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
//            password.setCellValueFactory(new PropertyValueFactory<>("password"));
        table.setItems(obs);    }
    
     
    
    
//    public void UpdateTable(){
//       VolService ps = new VolService();
//       ArrayList<vol> vol_list = ps.getAll();
//       ObservableList<vol> obs=FXCollections.observableArrayList(vol_list);
//
//        vol_id.setCellValueFactory(new PropertyValueFactory<>("vol_id"));
//        seat_nb.setCellValueFactory(new PropertyValueFactory<>("place_nb"));
//        classe.setCellValueFactory(new PropertyValueFactory<>("classe"));
//        airline_company.setCellValueFactory(new PropertyValueFactory<>("airline_company"));
//        price.setCellValueFactory(new PropertyValueFactory<>("price"));
//        table.setItems(obs);
//        
//      }
      public void Reset(){
            txt_role.clear();
            txt_first_name.clear();
            txt_last_name.clear();
            txt_email.clear();
//            txt_password.clear();
        }
        
//        @FXML
//        private void AddVol(ActionEvent event) throws IOException {
//        
//        vol v = new vol(Integer.parseInt(txt_nb_place.getText()),txt_classe.getText(),txt_airline_company.getText(),Float.parseFloat(txt_price.getText()));
//        VolService ps= new VolService();
//        ps.insert(v);
//        
//        UpdateTable();
//        Reset();
//        
//        }
//        @FXML
//        private void UpdateVol(ActionEvent event) throws IOException {
//        vol volselected = table.getSelectionModel().getSelectedItem();
//        Vol_idselected=volselected.getVol_id();
//        VolService ps= new VolService();
//        
//        vol v = new vol(Vol_idselected,Integer.parseInt(txt_nb_place.getText()),txt_classe.getText(),txt_airline_company.getText(),Float.parseFloat(txt_price.getText()));
//        ps.update(v, Vol_idselected);
//        
//        UpdateTable();
//        Reset();
//        }        
//        @FXML
//        private void DeleteVol(ActionEvent event) throws IOException {
//          vol volselected = table.getSelectionModel().getSelectedItem();
//          Vol_idselected=volselected.getVol_id();
//          VolService ps= new VolService();
//          ps.deleteByID(Vol_idselected);
//          
//          UpdateTable();
//          Reset();
//        
//        }
        
    @FXML
    public void handleButtonRes(ActionEvent event) throws IOException{
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Flight_Reservations.fxml"));
        rootPane.getChildren().setAll(pane);
        
    }

    
    
    
    
    
}
    
      
