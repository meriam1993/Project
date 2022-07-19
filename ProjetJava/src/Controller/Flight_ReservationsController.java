/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entite.user;
import entite.Vol;
import entite.Vol_reservation;
import java.io.IOException;
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
import service.ReservationVolService;
import service.UserService;
import service.VolService;

/**
 * FXML Controller class
 *
 * @author meria
 */
public class Flight_ReservationsController implements Initializable {

@FXML
    private TableView<Vol_reservation> table1;
    @FXML
    private TableColumn<Vol_reservation, Integer> id_res;
    @FXML
    private TableColumn<Vol_reservation, user> id_user_res;
    @FXML
    private TableColumn<Vol_reservation, Vol> id_vol_res;
    @FXML
    private TableColumn<Vol_reservation, String> dep_country;
    @FXML
    private TableColumn<Vol_reservation, String> arr_country;
    @FXML
    private TableColumn<Vol_reservation,Date > dep_date;
    @FXML
    private TableColumn<Vol_reservation, Float> price_res;
    
    private int Res_idselected;
    
    @FXML
    private TextField txt_res_id;
    @FXML
    private TextField txt_user_id;
    @FXML
    private TextField txt_volr_id;
    @FXML
    private TextField txt_dep_count;
    @FXML
    private TextField txt_arr_count;
    @FXML
    private DatePicker txt_dep_date;
    @FXML
    private TextField txt_res_price;
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
        ReservationVolService ps1 = new ReservationVolService();
        ArrayList<Vol_reservation> res_vol_list = ps1.getAll();
        ObservableList<Vol_reservation> obs1=FXCollections.observableArrayList(res_vol_list);
        

        id_res.setCellValueFactory(new PropertyValueFactory<>("reservation_vol_id"));
        id_user_res.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        id_vol_res.setCellValueFactory(new PropertyValueFactory<>("vol_id"));
        dep_country.setCellValueFactory(new PropertyValueFactory<>("departure_country"));
        arr_country.setCellValueFactory(new PropertyValueFactory<>("arrival_country"));
        dep_date.setCellValueFactory(new PropertyValueFactory<>("departure_date"));
        price_res.setCellValueFactory(new PropertyValueFactory<>("price"));
        table1.setItems(obs1);
    }    
      
      @FXML
      public void UpdateTable1(){
      ReservationVolService ps1 = new ReservationVolService();
      ArrayList<Vol_reservation> res_vol_list = ps1.getAll();
      ObservableList<Vol_reservation> obs1=FXCollections.observableArrayList(res_vol_list);
        

        id_res.setCellValueFactory(new PropertyValueFactory<>("reservation_vol_id"));
        id_user_res.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        id_vol_res.setCellValueFactory(new PropertyValueFactory<>("vol_id"));
        dep_country.setCellValueFactory(new PropertyValueFactory<>("departure_country"));
        arr_country.setCellValueFactory(new PropertyValueFactory<>("arrival_country"));
        dep_date.setCellValueFactory(new PropertyValueFactory<>("departure_date"));
        price_res.setCellValueFactory(new PropertyValueFactory<>("price"));
        table1.setItems(obs1);
        
        
      }
    
    
    
    @FXML
    public void Reset1(){

        txt_res_id.clear();
        txt_user_id.clear();
        txt_volr_id.clear();
        txt_dep_count.clear();
        txt_arr_count.clear();
        txt_dep_date.setValue(null);
        txt_res_price.clear();
        
        }
     
    
    
    

    @FXML
        private void AddResVol(ActionEvent event) throws IOException {
        UserService us=new UserService();
        user u=us.getById(Integer.parseInt(txt_user_id.getText()));
        VolService vs=new VolService();
        Vol v=vs.getById(Integer.parseInt(txt_volr_id.getText()));
        Vol_reservation rv = new Vol_reservation(u,v,txt_dep_count.getText(),txt_arr_count.getText(),Date.valueOf(txt_dep_date.getValue()),Float.parseFloat(txt_res_price.getText()));
        ReservationVolService ps= new ReservationVolService();
        ps.insert(rv);
        
        UpdateTable1();
        Reset1();
        }
    
        @FXML
        private void UpdateResVol(ActionEvent event) throws IOException {
        
        Vol_reservation volResselected = table1.getSelectionModel().getSelectedItem();
        Res_idselected=volResselected.getReservation_vol_id();
        ReservationVolService ps = new ReservationVolService();
        UserService us=new UserService();
        user u=us.getById(Integer.parseInt(txt_user_id.getText()));
        VolService vs=new VolService();
        Vol v=vs.getById(Integer.parseInt(txt_volr_id.getText()));
        Vol_reservation rv = new Vol_reservation(u,v,txt_dep_count.getText(),txt_arr_count.getText(),Date.valueOf(txt_dep_date.getValue()),Float.parseFloat(txt_res_price.getText()));
        ps.update(rv,Res_idselected);
        
        UpdateTable1();
        Reset1();

        
    }
        
        @FXML
        private void DeleteResVol(ActionEvent event) throws IOException {
        Vol_reservation volResselected = table1.getSelectionModel().getSelectedItem();
        Res_idselected=volResselected.getReservation_vol_id();
        ReservationVolService ps = new ReservationVolService();
        ps.deleteByID(Res_idselected);
        
        UpdateTable1();
        
    }
        
    @FXML
    public void handleButtonSelected(ActionEvent event) throws IOException {

       
                Integer user_id=table1.getSelectionModel().getSelectedItem().getUser_id();
                String u_id=String.valueOf(user_id);
                txt_user_id.setText(u_id);
                
                Integer vol_id=table1.getSelectionModel().getSelectedItem().getVol_id();
                String v_id=String.valueOf(vol_id);
                txt_volr_id.setText(v_id);
                
                txt_dep_count.setText(table1.getSelectionModel().getSelectedItem().getDeparture_country());
                
                txt_arr_count.setText("Tunis");
                
                txt_dep_date.setValue(table1.getSelectionModel().getSelectedItem().getDeparture_date().toLocalDate());
                
                float p=table1.getSelectionModel().getSelectedItem().getPrice();
                String s1=String.valueOf(p);
                txt_res_price.setText(s1);


      
    }

}
