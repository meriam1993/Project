package Controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.collections.transformation.FilteredList;
import main.testFXMain;
import main.MyListener;
import entite.hotel;
import entite.user;
import entite.reservation_hotel;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.value.ObservableIntegerValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.controlsfx.control.Rating;
import service.HotelService;
import service.UserService;
import service.hotel_reservation_Service;

public class HotelUserController implements Initializable {
    @FXML
    private VBox chosenCarCard;

    @FXML
    private Label carNameLable;

    @FXML
    private Label HotelPriceLabel;

    @FXML
    private ImageView carImg;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    
    private Image image;
    private MyListener myListener;

   
        HotelService ps = new HotelService();
       ArrayList<hotel>  cars = ps.getAll();
       final ObservableList <hotel> data = FXCollections.observableArrayList();     // modified now 
       
    @FXML
    private Label user_name;
    @FXML
    private Label etat_car;
    @FXML
    private DatePicker S_date;
    @FXML
    private DatePicker E_date;
    @FXML
    private Button add_res;
    @FXML
    private Label car_id;
    @FXML
    private TextField typechambre;
    @FXML
    private TextField typepension;
    @FXML
    private TextField searchbyid;
    @FXML
    private Rating rate;
    @FXML
    private Button search_byname;
   
    
     private void searchHotel (){
         FilteredList <hotel> FilteredData =new FilteredList <> (data, e-> true);
         searchbyid.setOnKeyReleased(e -> {
           searchbyid.textProperty().addListener((observable, oldValue, newValue) -> {
               FilteredData.setPredicate((Predicate<? super hotel>) h -> {
                   if (newValue ==null || newValue.isEmpty()){
                   return true; }
                   String lowerCaseFilter =newValue.toLowerCase();
                   if (  h.getNom().contains(lowerCaseFilter)){
                    return true; 
                   }
                 return false;
               });
               
           });
           
                      
         });
     
     
    
     }
     
     @FXML
        private void add_res(ActionEvent event) throws IOException {
       
        
         String n=LoginController.getInstance().email();
                UserService us = new UserService();
                user u=us.getbyEmail(n);
        
        HotelService vs=new HotelService();
        hotel h=vs.getById(Integer.parseInt(car_id.getText()));
        reservation_hotel rv = new reservation_hotel(u, h, typepension.getText(), typechambre.getText(), Date.valueOf(S_date.getValue()), Date.valueOf(E_date.getValue()), 2,Double.parseDouble(HotelPriceLabel.getText() ));
        hotel_reservation_Service ps= new hotel_reservation_Service();
        ps.insert(rv);
              
        }

    private void setChosenCar(hotel car) {
        carNameLable.setText(car.getNom());
        HotelPriceLabel.setText(String.valueOf(car.getPrice())) ;
            rate.setRating(car.getHotel_rate());

        
       
        image = new Image(getClass().getResourceAsStream(car.getImgSrc()));
        carImg.setImage(image);
        
        car_id.setText(String.valueOf(car.getHotel_id()));
       // chosenCarCard.setStyle("-fx-background-color: white"  "-fx-background-radius: 30;");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (cars.size() > 0) {
            setChosenCar(cars.get(0));
            myListener = new MyListener<hotel>() {
                @Override
                public void onClickListener(hotel car) {
                    setChosenCar(car);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < cars.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/ItemHotel.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemHotelController itemController = fxmlLoader.getController();
                itemController.setData(cars.get(i),myListener);

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
      ///  user_name.setText(user.getUsername());
  }
           


  }
//    }
     

