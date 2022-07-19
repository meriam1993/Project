/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import entite.Vol;
import entite.Vol_reservation;
import entite.user;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import service.ReservationVolService;
import service.UserService;
import service.VolService;

/**
 * FXML Controller class
 *
 * @author meria
 */
public class ReservationsController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<Vol_reservation> table;
    @FXML
    private TableColumn<Vol_reservation,String> departure_country;
    @FXML
    private TableColumn<Vol_reservation,String > arrival_country;
    @FXML
    private TableColumn<Vol_reservation, String> departure_date;
    @FXML
    private TableColumn<Vol_reservation, Float> price;
    @FXML
    private Button btn_DELETE;
    private int Vol_idselected;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ReservationVolService ps = new ReservationVolService();
     String n=LoginController.getInstance().email();
     UserService us = new UserService();
     user u=us.getbyEmail(n);
     int id=u.getUser_id();
        ArrayList<Vol_reservation> vol_list =ps.getAllById(id);
        ObservableList<Vol_reservation> obs = FXCollections.observableArrayList(vol_list);
        departure_country.setCellValueFactory(new PropertyValueFactory<>("departure_country"));
        arrival_country.setCellValueFactory(new PropertyValueFactory<>("arrival_country"));
        departure_date.setCellValueFactory(new PropertyValueFactory<>("departure_date"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.setItems(obs);
    }    

    @FXML
    private void DeleteVol(ActionEvent event) {
        
        Vol_reservation volselected = table.getSelectionModel().getSelectedItem();
        Vol_idselected = volselected.getReservation_vol_id();
        ReservationVolService ps = new ReservationVolService();
        ps.deleteByID(Vol_idselected);

      UpdateTable();
    }
    
    private void UpdateTable (){
    
    ReservationVolService ps = new ReservationVolService();
     String n=LoginController.getInstance().email();
     UserService us = new UserService();
     user u=us.getbyEmail(n);
     int id=u.getUser_id();
     ArrayList<Vol_reservation> vol_list =ps.getAllById(id);
        ObservableList<Vol_reservation> obs = FXCollections.observableArrayList(vol_list);
        departure_country.setCellValueFactory(new PropertyValueFactory<>("departure_country"));
        arrival_country.setCellValueFactory(new PropertyValueFactory<>("arrival_country"));
        departure_date.setCellValueFactory(new PropertyValueFactory<>("departure_date"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.setItems(obs);}
    
   

    
}
