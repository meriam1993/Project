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
import main.Main;
import main.MyListener;
import entite.Car;
import entite.user;
import entite.Car_reservation;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import service.CarService;
import service.UserService;
import service.ReservationCarService;





public class MarketController implements Initializable {
    
    @FXML
    private VBox chosenCarCard;

    private Label carNameLable;

    @FXML
    private Label carPriceLabel;

    @FXML
    private ImageView carImg;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    
    private Image image;
    private MyListener myListener;

   

       CarService ps = new CarService();
       ArrayList<Car>  cars = ps.getAll();
       UserService us=new UserService();
       user user = us.getById(3);
        
        
    @FXML
    private Label labkm;
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
    private Label carBrandLable;
    @FXML
    private Label carModelLable;
    @FXML
    private Label carNameLable11;
    @FXML
    private AnchorPane rootPane;
 
  

    private void setChosenCar(Car car) {
       
        carModelLable.setText(car.getCar_model());
        carBrandLable.setText(car.getCar_brand());
        carPriceLabel.setText(String.valueOf(car.getPrice())) ;
        image = new Image(getClass().getResourceAsStream(car.getImgSrc()));
        carImg.setImage(image);
        labkm.setText(String.valueOf(car.getKilometrage()));
        car_id.setText(String.valueOf(car.getCar_id()));
//chosenCarCard.setStyle("-fx-background-color: #" + car.getColor() + ";\n" +
//        "    -fx-background-radius: 30;");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        if (cars.size() > 0) {
            setChosenCar(cars.get(0));
            myListener = new MyListener<Car>(){
                @Override
                public void onClickListener(Car car) {
                    setChosenCar(car);
                      ReservationCarService p=new ReservationCarService();
                      p.DC();
        
       
        try {
          
            
            if (p.checkcar().toString().contains(car_id.getText())){
                etat_car.setText("Reserved") ;
                System.out.println("yes");
                
            }
            else
                etat_car.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("no");
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < cars.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/Item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
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
        
        
      
        
    }

    @FXML
    private void add_reservation(ActionEvent event) throws IOException {
    
       
        long date1 = S_date.getValue().getDayOfYear();
        long date2 = E_date.getValue().getDayOfYear();
        long date_sys = LocalDateTime.now().getDayOfYear();
       
   
     
      if ((date1>date2)||(date1<date_sys))
      {
          Alert alert = new Alert(AlertType.WARNING);
          alert.setTitle("Date Error");
          alert.setHeaderText(null);
          alert.setContentText("Please check date");
          alert.showAndWait();
           System.out.println(date1);
            System.out.println(date_sys);
             System.out.println(date1-date2);
      }
      
              
      else {
          if (etat_car.getText().equals("Reserved")){
              Alert alert = new Alert(AlertType.WARNING);
          alert.setTitle("Error");
          alert.setHeaderText(null);
          alert.setContentText("car alrady reserved choose other one ");
          alert.showAndWait();
           System.out.println(date1);
            System.out.println(date_sys);
             System.out.println(date1-date2);
          }
      
          else {
      
              
       long date11 = S_date.getValue().toEpochDay();
long date22 = E_date.getValue().toEpochDay();
          
        double F_price;
        double price_u;
      
         price_u=Double.valueOf(carPriceLabel.getText() );
       int duree  = (int) Math.abs(date1 - date2);
        F_price=(price_u*duree)*1.19; 
        double tva=(price_u*duree)*0.19;
       Car_reservation c_r= new Car_reservation (3,Integer.parseInt(car_id.getText()),Date.valueOf(S_date.getValue()) ,Date.valueOf(E_date.getValue()) ,F_price );
        ReservationCarService ps1= new  ReservationCarService();
        ps1.insert(c_r);
        
        
        
  FXMLLoader loader=new FXMLLoader(getClass().getResource("../views/Recu_resrvation.fxml")); 
      Parent root=loader.load();
//         AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/Recu_resrvation.fxml"));
//        rootPane.getChildren().setAll(pane);
        Recu_resrvationController controller = loader.getController();
        carPriceLabel.getScene().setRoot(root);
        controller.setC_m(carModelLable.getText());
         controller.setKm_c(labkm.getText());
         controller.setImgr(carImg);
         controller.setId_reservation(String.valueOf(c_r.getReservation_Car_id())); 
         controller.setSdate(Date.valueOf(S_date.getValue()).toString());
         controller.setUprice(carPriceLabel.getText());
          controller.setSdate1(Date.valueOf(E_date.getValue()).toString());
          controller.setTotal(String.valueOf(F_price));
           controller.setTva(String.valueOf(tva));
          controller.setAmount(String.valueOf(price_u*duree));
         controller.setC_b(carBrandLable.getText());
         controller.setF_n_u(user.getFirst_name());
         controller.setL_n_u(user.getLast_name());
         
       
   
     
                    
////                
 
        
           
       }  
       } 
        
    }
    }
     

