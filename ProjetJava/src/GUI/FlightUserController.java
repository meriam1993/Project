package GUI;
import Entity.Vol;
import Entity.Vol_reservation;
import Entity.user;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import service.MyListener;


import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import service.ReservationVolService;
import service.VolService;
import service.UserService;

public class FlightUserController implements Initializable {
  
    
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    
    private Image image;
    private MyListener myListener;

   
       
       
    @FXML
    private Label user_name;
    @FXML
    private ChoiceBox<String> from_choice;
    @FXML
    private ChoiceBox<String> to_choice;
    private final String choix1[]={"Turkey","Italy","France","USA","India","UK"};
    private final String choix2[]={"Tunis"};
  
    
    @FXML
    private Button search_btn;
    @FXML
    private DatePicker depar_date;
    @FXML
    private Button browse;
    @FXML
    private VBox chosenCarCard;
    @FXML
    private BorderPane BorderPane;
        
        Integer Id;
        String dep_count;
        String Air_com;
        String clas;
        Integer nb;
        Date d;
        Float f;
    java.util.Date date = new java.util.Date(); 
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
     private void setChosenVol(Vol vol) {
        Id =vol.getVol_id();
         dep_count=vol.getDeparture_country();
         Air_com=vol.getAirline_company();
         clas=vol.getClasse();
         nb=vol.getPlace_nb();
         d=vol.getVol_date();
         f=vol.getPrice();

    }
 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         VolService ps = new VolService();
         ArrayList<Vol>  vols = ps.getAll();
         
         if (vols.size() > 0) {
            setChosenVol(vols.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Vol vol) {
                    setChosenVol(vol); 
                }
               
            };
        }
        
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < vols.size(); i++) {
                 if (vols.get(i).getVol_date().compareTo(sqlDate)>=0){
                    System.out.println(vols.get(i).getVol_date());
                    System.out.println(sqlDate);
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(vols.get(i),myListener);

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane,column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(10));
                
            }}
        } catch (IOException e) {
            e.printStackTrace();
            
        }
       
       
        UserService us=new UserService();
        user user = us.getById(3);
     
        user_name.setText(user.getInitial());
        from_choice.getItems().addAll(choix1);
        to_choice.getItems().addAll(choix2);
        
        
        
    }
        @FXML
        private void ButtonActionInit(ActionEvent event) throws IOException {
            
        VolService ps = new VolService();
        ArrayList<Vol>  vols = ps.getAll();
        
        int column = 0;
        int row = 1;
        try {
            
            for (int i = 0; i < vols.size(); i++) {
            if (vols.get(i).getVol_date().compareTo(sqlDate)>=0){
                
                System.out.println(vols.get(i).getVol_date());
                System.out.println(sqlDate);
                    
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(vols.get(i),myListener);

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane,column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(10));
                
            }}
        } catch (IOException e) {
            e.printStackTrace();
            
        }
        
        
        
        }
        
            @FXML
        private void ButtonActionSearch(ActionEvent event) throws IOException {
            // java.util.Date date = new java.util.Date(); 
           // java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
            Date.valueOf(depar_date.getValue()).compareTo(sqlDate);
            if (Date.valueOf(depar_date.getValue()).compareTo(sqlDate)<0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Date Error");
            alert.setHeaderText(null);
            alert.setContentText("PLEASE CHOOSE THE CORRECT DATE");
            alert.showAndWait();}
            //BorderPane.setCenter(null);
            grid.getChildren().clear();
            
            String source=from_choice.getValue();
            Date depar=Date.valueOf(depar_date.getValue());
            
            VolService vs= new VolService();
            ArrayList<Vol>  vols=vs.getFlight(source,depar);
            
            int column = 0;
            int row = 1;
            try {
            for (int i = 0; i < vols.size(); i++) {
                
                
                
           
     
                if (vols.get(i).getVol_date().compareTo(sqlDate)>=0){
                System.out.println(vols.get(i).getVol_date());
                System.out.println(sqlDate);
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(vols.get(i),myListener);

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane,column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(10));}
                
            }
        } catch (IOException e) {
            e.printStackTrace();
            
        
        }}
        
    @FXML
    private void add_reservation(ActionEvent event) throws IOException, Exception {
    
        
        if (nb==0){
         
              Dialog alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle("");
              alert.setHeaderText(null);
              alert.setContentText("The flight is fully booked");
              alert.showAndWait();
              
        }else{
                    
                UserService us = new UserService();
                user u=us.getById(3);
                VolService vs= new VolService();
                Vol v=vs.getById(Id);
                System.out.println(Id);
                System.out.println(dep_count);
                System.out.println(Air_com);
                System.out.println(nb);
                Integer nbr=nb-1;
                System.out.println(nbr);
                vs.updateNbrPlace(v,Id,nbr);
                                             
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Do you want to reserve a flight from "+dep_count+" to Tunis on "+d);
                
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    
                    Vol_reservation vr = new Vol_reservation (u,v,dep_count,"Tunis",d,f);
                    ReservationVolService ps1= new ReservationVolService();
                    ps1.insert(vr);
//                    Dialog<String> dialog = new Dialog<String>();
//                    dialog.setContentText("Your Flight has been booked, Please check your email!");
//                    dialog.showAndWait();
                    //String n=LoginController.getInstance().email();
                    JavaMailUtil.sendMail("meriamhjiri@gmail.com");
                    
                    
                } else {
                    
                    Alert cancel = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("");
                    alert.setHeaderText(null);
                    alert.setContentText("The flight is canceled");
                    alert.showAndWait();          
                           
                }
                
            }
            
         
     
         
     }
}
    
    
    




     

