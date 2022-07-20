/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import entite.Car_reservation;
import entite.Vol;
import entite.Vol_reservation;
import entite.reservation_hotel;
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
import service.ReservationCarService;
import service.ReservationVolService;
import service.UserService;
import service.VolService;
import service.hotel_reservation_Service;

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
    private int Hotel_idselected;

    private int Car_idselected;
    @FXML
    private TableView<Car_reservation> table1;
    @FXML
    private TableColumn<Car_reservation, Date> start_date;
    @FXML
    private TableColumn<Car_reservation, Date> end_date;
    @FXML
    private TableColumn<Car_reservation, Double> priceC;
    @FXML
    private Button btn_DELETE1;
    @FXML
    private TableView<reservation_hotel> table11;
    @FXML
    private TableColumn<reservation_hotel, Date> start_date1;
    @FXML
    private TableColumn<reservation_hotel, Date> end_date1;
    @FXML
    private TableColumn<reservation_hotel, Double> priceC1;
    @FXML
    private Button btn_DELETE11;

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
        
        
        ReservationCarService ps2 = new ReservationCarService();
        ArrayList<Car_reservation> carR = ps2.getAllById(id);
        ObservableList<Car_reservation> obs1=FXCollections.observableArrayList(carR);
        start_date.setCellValueFactory(new PropertyValueFactory<>("Start_date"));
        end_date.setCellValueFactory(new PropertyValueFactory<>("End_date"));
        priceC.setCellValueFactory(new PropertyValueFactory<>("price")); 
        table1.setItems(obs1);
        
        
        hotel_reservation_Service ps3 = new hotel_reservation_Service();
        ArrayList<reservation_hotel> HotelR = ps3.getAllById(id);
        ObservableList<reservation_hotel> obs3=FXCollections.observableArrayList(HotelR);
        start_date1.setCellValueFactory(new PropertyValueFactory<>("checkin"));
        end_date1.setCellValueFactory(new PropertyValueFactory<>("checkout"));
        priceC1.setCellValueFactory(new PropertyValueFactory<>("prix")); 
        table11.setItems(obs3);
               
        
        
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

    @FXML
    private void DeleteCar(ActionEvent event) {
          Car_reservation volselected = table1.getSelectionModel().getSelectedItem();
         Car_idselected = volselected.getReservation_Car_id();
        ReservationCarService ps = new ReservationCarService();
        ps.deleteByID(Car_idselected);

      UpdateTable1();
    }
    private void UpdateTable1 (){
    
    ReservationVolService ps = new ReservationVolService();
     String n=LoginController.getInstance().email();
     UserService us = new UserService();
     user u=us.getbyEmail(n);
     int id=u.getUser_id();
     ReservationCarService ps2 = new ReservationCarService();
        ArrayList<Car_reservation> carR = ps2.getAllById(id);
        ObservableList<Car_reservation> obs1=FXCollections.observableArrayList(carR);
        start_date.setCellValueFactory(new PropertyValueFactory<>("Start_date"));
        end_date.setCellValueFactory(new PropertyValueFactory<>("End_date"));
        priceC.setCellValueFactory(new PropertyValueFactory<>("price")); 
        table1.setItems(obs1);
  }

    @FXML
    private void DeleteHotel(ActionEvent event) {
        reservation_hotel Hotelselected = table11.getSelectionModel().getSelectedItem();
        Hotel_idselected = Hotelselected.getId_reshotel();
        hotel_reservation_Service ps3 = new hotel_reservation_Service();
        ps3.delete(Hotel_idselected);
        UpdateTable2();
    }
        private void UpdateTable2 (){
    
    ReservationVolService ps = new ReservationVolService();
     String n=LoginController.getInstance().email();
     UserService us = new UserService();
     user u=us.getbyEmail(n);
     int id=u.getUser_id();
           hotel_reservation_Service ps3 = new hotel_reservation_Service();
        ArrayList<reservation_hotel> HotelR = ps3.getAllById(id);
        ObservableList<reservation_hotel> obs3=FXCollections.observableArrayList(HotelR);
        start_date1.setCellValueFactory(new PropertyValueFactory<>("checkin"));
        end_date1.setCellValueFactory(new PropertyValueFactory<>("checkout"));
        priceC1.setCellValueFactory(new PropertyValueFactory<>("prix")); 
        table11.setItems(obs3);
  }
    
   

    
}
