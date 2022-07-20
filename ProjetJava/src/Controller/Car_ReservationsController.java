/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import entite.Car;
import entite.Car_reservation;
import entite.user;
import java.io.IOException;
import service.CarService;
import service.ReservationCarService;
import service.UserService;

/**
 * FXML Controller class
 *
 * @author chihe
 */
public class Car_ReservationsController implements Initializable {

    @FXML
    private TextField txt_res_id;
    @FXML
    private TextField txt_user_id;
    @FXML
    private TextField txt_car_id;
    @FXML
    private DatePicker txt_s_date;
    @FXML
    private DatePicker txt_e_date;
    @FXML
    private TextField txt_res_price;
    @FXML
    private TableView<Car_reservation> table1;
     private int Res_idselected;
    @FXML
   private TableColumn<Car_reservation, Integer> id_res;
    @FXML
    private TableColumn<Car_reservation, Integer> id_user_res;
    @FXML
    private TableColumn<Car_reservation, Integer> id_car_res;
    @FXML
    private TableColumn<Car_reservation, Date> S_date;
    @FXML
    private TableColumn<Car_reservation, Date> E_date;
    @FXML
    private TableColumn<Car_reservation, Double> price_res;
    @FXML
    private Button btn_ADD1;
    @FXML
    private Button btn_UPDATE1;
    @FXML
    private Button btn_DELETE1;
    @FXML
    private Button btn_REFRESH1;
    @FXML
    private Button btn_RESET1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ReservationCarService ps2 = new ReservationCarService();
        ArrayList<Car_reservation> carR = ps2.getAll();
       ObservableList<Car_reservation> obs=FXCollections.observableArrayList(carR);

        id_res.setCellValueFactory(new PropertyValueFactory<>("Reservation_Car_id"));
        id_car_res.setCellValueFactory(new PropertyValueFactory<>("Car_id"));
       id_user_res.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        S_date.setCellValueFactory(new PropertyValueFactory<>("Start_date"));
        E_date.setCellValueFactory(new PropertyValueFactory<>("End_date"));
        price_res.setCellValueFactory(new PropertyValueFactory<>("price")); 
        table1.setItems(obs);
    }    

    @FXML
    private void AddResVol(ActionEvent event) {
         UserService us=new UserService();
//        user u=us.getById(Integer.parseInt(txt_user_id.getText()));
        CarService cs=new CarService();
//        Car c =cs.getById(Integer.parseInt(txt_car_id.getText()));
        Car_reservation cr = new Car_reservation(Integer.parseInt(txt_user_id.getText()),Integer.parseInt(txt_car_id.getText()),Date.valueOf(txt_s_date.getValue()),Date.valueOf(txt_e_date.getValue()),Double.parseDouble(txt_res_price.getText()));
        ReservationCarService ps= new ReservationCarService();
        ps.insert(cr);
        
        UpdateTable1();
        Reset1();
    }

    @FXML
    private void UpdateResVol(ActionEvent event) {
          Car_reservation carResselected = table1.getSelectionModel().getSelectedItem();
        Res_idselected=carResselected.getReservation_Car_id();
        ReservationCarService ps = new ReservationCarService();
//        UserService us=new UserService();
//        user u=us.getById(Integer.parseInt(txt_user_id.getText()));
//        CarService vs=new CarService();
//        Car c=vs.getById(Integer.parseInt(txt_car_id.getText()));
        Car_reservation rc = new Car_reservation(Integer.parseInt(txt_user_id.getText()),Integer.parseInt(txt_car_id.getText()),Date.valueOf(txt_s_date.getValue()),Date.valueOf(txt_e_date.getValue()),Double.parseDouble(txt_res_price.getText()));
        ps.update(rc,Res_idselected);
        
        UpdateTable1();
        Reset1();

    }

    @FXML
    private void DeleteResVol(ActionEvent event) {
         Car_reservation CarResselected = table1.getSelectionModel().getSelectedItem();
        Res_idselected=CarResselected.getReservation_Car_id();
        ReservationCarService ps = new ReservationCarService();
        ps.deleteByID(Res_idselected);
        
        UpdateTable1();
    }

    @FXML
    private void UpdateTable1() {
         ReservationCarService ps2 = new ReservationCarService();
        ArrayList<Car_reservation> carR = ps2.getAll();
       ObservableList<Car_reservation> obsc=FXCollections.observableArrayList(carR);

        id_res.setCellValueFactory(new PropertyValueFactory<>("Reservation_Car_id"));
        id_car_res.setCellValueFactory(new PropertyValueFactory<>("Car_id"));
        id_user_res.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        S_date.setCellValueFactory(new PropertyValueFactory<>("Start_date"));
        E_date.setCellValueFactory(new PropertyValueFactory<>("End_date"));
        price_res.setCellValueFactory(new PropertyValueFactory<>("price")); 
        table1.setItems(obsc);
    }    

    @FXML
    private void Reset1() {
        txt_res_id.clear();
        txt_user_id.clear();
        txt_car_id.clear();
       txt_e_date.setValue(null);
        txt_s_date.setValue(null);
        txt_res_price.clear();
    }
    
    
    @FXML
    public void handleButtonSelected(ActionEvent event) throws IOException {

                Integer user_id=table1.getSelectionModel().getSelectedItem().getUser_id();
                String u_id=String.valueOf(user_id);
                txt_user_id.setText(u_id);
                
                Integer vol_id=table1.getSelectionModel().getSelectedItem().getCar_id();
                String c_id=String.valueOf(vol_id);
                txt_car_id.setText(c_id);
                
                txt_s_date.setValue(table1.getSelectionModel().getSelectedItem().getStart_date().toLocalDate());
                txt_e_date.setValue(table1.getSelectionModel().getSelectedItem().getStart_date().toLocalDate());
               
                double p=table1.getSelectionModel().getSelectedItem().getPrice();
                String s1=String.valueOf(p);
                txt_res_price.setText(s1);
      
    }
    }

   
    
