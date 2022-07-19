/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entite.hotel;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
import service.HotelService;
import service.hotel_reservation_Service;

/**
 * FXML Controller class
 *
 * @author meria
 */
public class hotelsController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField txt_hotel;
    @FXML
    private TextField txt_hotel_name;
    @FXML
    private TextField txt_location;
    @FXML
    private TextField txt_room_number;
    @FXML
    private TextField txt_rate;
    @FXML
    private TextField img;
    @FXML
    private TextField price;
    @FXML
    private TableView<hotel> table;
     @FXML
    private TableColumn<hotel, Integer> hotel_id;
    @FXML
    private TableColumn<hotel,String> hotel_name;
    @FXML
    private TableColumn<hotel,String> location;
    @FXML
    private TableColumn<hotel, String> room_nb;
    @FXML
    private TableColumn<hotel, String> hotel_rate;
   
      @FXML
    private TableColumn<hotel, String> price_id;
      private int hotel_selected;
    @FXML
    private Button btn_ADD;
    @FXML
    private Button Reservations_Page;
    @FXML
    private Button btn_UPDATE;
    @FXML
    private Button btn_DELETE;
    @FXML
    private Button btn_REFRESH;
    @FXML
    private Button btn_RESET;
    @FXML
    private TextField id_to_delete;
    @FXML
    private TableColumn<?, ?> img_;
    @FXML
    private TextField searchbyid;
    @FXML
    private Button search_btn1;
 
  
  

    

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        HotelService ps = new HotelService();
        ArrayList<hotel> hotel_list = ps.getAll();
       ObservableList<hotel> hotelList=FXCollections.observableArrayList(hotel_list);      
        
       hotel_id.setCellValueFactory(new PropertyValueFactory<>("hotel_id"));
       hotel_name.setCellValueFactory(new PropertyValueFactory<>("nom"));
        location.setCellValueFactory(new PropertyValueFactory<>("location"));
        room_nb.setCellValueFactory(new PropertyValueFactory<>("nb_room"));
        hotel_rate.setCellValueFactory(new PropertyValueFactory<>("hotel_rate"));
       img_.setCellValueFactory(new PropertyValueFactory<>("ImgSrc"));
       price_id.setCellValueFactory(new PropertyValueFactory<>("price"));
       table.setItems(hotelList);
    
    }    
    
    
    @FXML
    public void UpdateTable(){
       HotelService ps = new HotelService();
       ArrayList<hotel> HOTEL_list = ps.getAll();
       ObservableList<hotel> obs=FXCollections.observableArrayList(HOTEL_list);

          hotel_id.setCellValueFactory(new PropertyValueFactory<>("hotel_id"));
       hotel_name.setCellValueFactory(new PropertyValueFactory<>("nom"));
        location.setCellValueFactory(new PropertyValueFactory<>("location"));
        room_nb.setCellValueFactory(new PropertyValueFactory<>("nb_room"));
        hotel_rate.setCellValueFactory(new PropertyValueFactory<>("hotel_rate"));
       img_.setCellValueFactory(new PropertyValueFactory<>("ImgSrc"));
       price_id.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.setItems(obs);
        
      }
    @FXML
      public void Reset(){
            txt_hotel.clear();
            txt_hotel_name.clear();
            txt_location.clear();
            txt_room_number.clear();
            txt_rate.clear();
            img.clear();
            price.clear();
        }

        @FXML
        private void Addhotel(ActionEvent event) throws IOException {       
         hotel h =new hotel(20,txt_hotel_name.getText(),txt_location.getText(), Integer.parseInt(txt_room_number.getText()), Integer.parseInt(txt_rate.getText()),img.getText(),Double.parseDouble(price.getText()));
         HotelService hsr =new HotelService();
         hsr.insert(h);
         UpdateTable();
              }
        
        
        @FXML
        private void UpdateVol(ActionEvent event) throws IOException {
        /*hotel volselected = table.getSelectionModel().getSelectedItem();
        hotel_selected=volselected.getHotel_id();
        HotelService ps= new HotelService();
        
        hotel v = new hotel(hotel_selected,txt_hotel_name.getText(),location.getText(),Integer.parseInt(room_nb.getText()),Integer.parseInt(hotel_rate.getText()),img_id.getText(),Double.parseDouble(price_id.getText()));
        
        ps.update(v, hotel_selected);
        
        UpdateTable();
        Reset();*/
        Integer id = Integer.parseInt(txt_hotel.getText());
        String hotel_name = txt_hotel_name.getText();
        String loc =  txt_location.getText();
        Integer room_nb= Integer.parseInt(txt_room_number.getText());
        Integer rate = Integer.parseInt(txt_rate.getText());
        String img_ = img.getText();
        Double pricee = Double.parseDouble(price.getText());
        
        hotel h =new hotel(id,hotel_name, loc, room_nb, rate,img_,pricee);
          HotelService hsr =new HotelService();
         hsr.update(h);
        UpdateTable();
        Reset();
        }
    
        @FXML
        private void Delete(ActionEvent event) {
       /* hotel hotelselected = table.getSelectionModel().getSelectedItem();
          hotel_selected=hotelselected.getHotel_id();
          HotelService ps= new HotelService();
          ps.getById(hotel_selected);*/
          
        Integer id =  Integer.parseInt(id_to_delete.getText());
         HotelService hs=new HotelService();
          hs.delete(id);
          UpdateTable();
        
     
        
       
        }
        
    @FXML
    public void handleButtonRes(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/hotel_Reservation.fxml"));
        rootPane.getChildren().setAll(pane);
        
    }

    @FXML
    private void searchHotel(ActionEvent event) {
        
         HotelService ps = new HotelService();
        ArrayList<hotel> hotel_list = ps.getByname(searchbyid.getText());
       ObservableList<hotel> hotelList=FXCollections.observableArrayList(hotel_list);      
        
       hotel_id.setCellValueFactory(new PropertyValueFactory<>("hotel_id"));
       hotel_name.setCellValueFactory(new PropertyValueFactory<>("nom"));
        location.setCellValueFactory(new PropertyValueFactory<>("location"));
        room_nb.setCellValueFactory(new PropertyValueFactory<>("nb_room"));
        hotel_rate.setCellValueFactory(new PropertyValueFactory<>("hotel_rate"));
       img_.setCellValueFactory(new PropertyValueFactory<>("ImgSrc"));
       price_id.setCellValueFactory(new PropertyValueFactory<>("price"));
       table.setItems(hotelList);
        
    }

    
    
    
    
    
}
    
      
