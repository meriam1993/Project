/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entite.user;
import entite.hotel;
import entite.reservation_hotel;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDateTime;
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
import javafx.scene.image.ImageView;
import service.hotel_reservation_Service;
import service.UserService;
import service.HotelService;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * FXML Controller class
 *
 * @author meria
 */
public class hotels_ReservationsController implements Initializable {
   
    private int Res_idselected;
    @FXML
    private TextField txt_res_id;
    @FXML
    private TextField txt_user_id;
    @FXML
    private TextField txt_hotel_id;
    @FXML
    private TextField txt_pension;
    @FXML
    private TextField txt_room_type;
    @FXML
    private DatePicker txt_arriv_date;
    @FXML
    private DatePicker txt_dep_date;
    @FXML
    private TextField txt_nb_dates;
    @FXML
    private TextField txt_price;
    @FXML
    private TableView<reservation_hotel> table1;
    @FXML
    private TableColumn<reservation_hotel, Integer> id_res;
    @FXML
    private TableColumn<reservation_hotel, user> id_user_res;
     @FXML
    private TableColumn<reservation_hotel, hotel> id_hotel_res;
    
    @FXML
    private TableColumn<reservation_hotel, String> dep_pension;
    @FXML
    private TableColumn<reservation_hotel,String> type_room;
    @FXML
    private TableColumn<reservation_hotel,Date> arrival_date;
    @FXML
    private TableColumn<reservation_hotel,Date> departure_date;
    @FXML
    private TableColumn<reservation_hotel,Integer> nb_dates;
    @FXML
    private TableColumn<reservation_hotel,Double> price;
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
    @FXML
    private TextField id_to_delete;
 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hotel_reservation_Service ps1 = new hotel_reservation_Service();
        ArrayList<reservation_hotel> res_hotel_list = ps1.getAll();  
        ObservableList<reservation_hotel> ob=FXCollections.observableArrayList(res_hotel_list);
        

        id_res.setCellValueFactory(new PropertyValueFactory<>("id_reshotel"));
        id_user_res.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        id_hotel_res.setCellValueFactory(new PropertyValueFactory<>("hotel_id"));
        dep_pension.setCellValueFactory(new PropertyValueFactory<>("type_pension"));
        type_room.setCellValueFactory(new PropertyValueFactory<>("type_chambre"));
        arrival_date.setCellValueFactory(new PropertyValueFactory<>("checkin"));
        departure_date.setCellValueFactory(new PropertyValueFactory<>("checkout"));
        nb_dates.setCellValueFactory(new PropertyValueFactory<>("nb_dates"));
        price.setCellValueFactory(new PropertyValueFactory<>("prix"));
        table1.setItems(ob);
    }    
    @FXML
      public void UpdateTable1(){
      hotel_reservation_Service ps1 = new hotel_reservation_Service();
      ArrayList<reservation_hotel> res_hotel_list = ps1.getAll();
       
      ObservableList<reservation_hotel> obs1=FXCollections.observableArrayList(res_hotel_list);
        id_res.setCellValueFactory(new PropertyValueFactory<>("id_reshotel"));
        id_user_res.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        id_hotel_res.setCellValueFactory(new PropertyValueFactory<>("hotel_id"));
        dep_pension.setCellValueFactory(new PropertyValueFactory<>("type_pension"));
        type_room.setCellValueFactory(new PropertyValueFactory<>("type_chambre"));
        arrival_date.setCellValueFactory(new PropertyValueFactory<>("checkin"));
        departure_date.setCellValueFactory(new PropertyValueFactory<>("checkout"));
        nb_dates.setCellValueFactory(new PropertyValueFactory<>("nb_dates"));
        price.setCellValueFactory(new PropertyValueFactory<>("prix"));
        table1.setItems(obs1);
        
        
      }
    
    
    
    @FXML
    public void Reset1(){

        txt_res_id.clear();
        txt_user_id.clear();
        txt_hotel_id.clear();
        txt_pension.clear();
        txt_room_type.clear();
        txt_arriv_date.setValue(null);
        txt_dep_date.setValue(null);
        txt_nb_dates.clear();
        txt_price.clear();
        
        }
     
    
     public  void envoyer(String nom_hotel,String f_name , String s_name,String type_ch,String type_p , Date checkin ,Date checkout , int nb_date) {
        String host="jaweher.hamrouni28@gmail.com";  //← my email address
        final String user="jaweher.hamrouni28@gmail.com";//← my email address
        final String password="lclxvzygojjjbjxt";//change accordingly   //← my email password
        String to="hamrounij5@gmail.com";//→ the EMAIL i want to send TO → 587
        Properties props = new Properties();
       props.put("mail.smtp.host", "smtp.gmail.com");
       props.put("mail.smtp.socketFactory.port", "465");
       props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.port", "465");
       Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);}
                });
        try {hotel_reservation_Service hs =new hotel_reservation_Service();            
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Demande de reservation ");
            message.setText("Dear "+nom_hotel +" team , \n We send you a reservation request in the name of : " +f_name + " " +s_name+ "for "+type_ch+" room , pension " +type_p+ " the checkin will be " +checkin+ " checkout will be " +checkout+ " for " + nb_date+ "dates \n We wait for your confirmation of disponibility. \n best regards \n TuniGreen Team . ");
            Transport.send(message);
            System.out.println("message sent successfully via mail ... !!! ");
             Alert alert = new Alert(AlertType.WARNING); 
            alert.setTitle("Email send ");
          alert.setHeaderText(null);
          alert.setContentText("Email was send to " + nom_hotel + " hotel.");
          alert.showAndWait();
        } catch (MessagingException e) {e.printStackTrace();}

    }

    

    @FXML
        private void AddRes(ActionEvent event) throws IOException {
        UserService us=new UserService();
        user u=us.getById(Integer.parseInt(txt_user_id.getText()));
        HotelService vs=new HotelService();
        hotel h=vs.getById(Integer.parseInt(txt_hotel_id.getText()));
        double F_price;
        double price_u;
      
        long date1 = txt_arriv_date.getValue().toEpochDay();
        long date2 = txt_dep_date.getValue().toEpochDay();
        long date_sys = LocalDateTime.now().getDayOfYear();
        
       price_u= h.getPrice();
       int duree  = (int) Math.abs(date1 - date2);
        F_price=(price_u*duree); 
        
        if (date1>date2 )
      {
          Alert alert = new Alert(AlertType.WARNING);
          alert.setTitle("Date Error");
          alert.setHeaderText(null);
          alert.setContentText("Please verify the date ");
          alert.showAndWait();}
        
      else if ((date1 < date_sys)) {
          
         Alert alert = new Alert(AlertType.WARNING);
          alert.setTitle("Date Error");
          alert.setHeaderText(null);
          alert.setContentText("Please verify the date with date system");
          alert.showAndWait();
      }
        
        else {

        reservation_hotel rv = new reservation_hotel(u, h, txt_pension.getText(), txt_room_type.getText(), Date.valueOf(txt_arriv_date.getValue()), Date.valueOf(txt_dep_date.getValue()), duree,F_price);
        hotel_reservation_Service ps= new hotel_reservation_Service();
        
        envoyer (h.getNom(),u.getFirst_name(),u.getLast_name() ,txt_room_type.getText(),txt_pension.getText() , Date.valueOf(txt_arriv_date.getValue()) ,Date.valueOf(txt_dep_date.getValue()) , Integer.parseInt(txt_nb_dates.getText()));
        
       
         
        ps.insert(rv);
        UpdateTable1();
        Reset1();
        
        }
        
        }
        
       
    
        @FXML
        private void UpdateRes(ActionEvent event) throws IOException {
        
         Integer id= Integer.parseInt(txt_res_id.getText());
         
         UserService us=new UserService();
         user u=us.getById(Integer.parseInt(txt_user_id.getText()));
         
         HotelService hrs=new HotelService();
         hotel h = hrs.getById(Integer.parseInt(txt_hotel_id.getText()));
         
          reservation_hotel rh =new reservation_hotel(u, h, txt_pension.getText(), txt_room_type.getText(), Date.valueOf(txt_arriv_date.getValue()), Date.valueOf(txt_dep_date.getValue()), Integer.parseInt(txt_nb_dates.getText()),Double.parseDouble(txt_price.getText()));
       
         hotel_reservation_Service hsr =new hotel_reservation_Service();
         
          hsr.update(rh,id);
          Reset1();
          UpdateTable1();
          
            System.out.println(id);
        
    }
        
        @FXML
        private void DeleteRes(ActionEvent event) throws IOException {
        Integer id =  Integer.parseInt(id_to_delete.getText());
         hotel_reservation_Service hs=new  hotel_reservation_Service();
          hs.delete(id);
          UpdateTable1();
        Reset1();
        

        
    }
        
       /** -- File title : Velo/src/com/Velo/EmailService/JavaMailSender.java -- **/




    public  void envoyer(ActionEvent event) throws IOException {
        String host="jaweher.hamrouni28@gmail.com";  //← my email address
        final String user="jaweher.hamrouni28@gmail.com";//← my email address
        final String password="lclxvzygojjjbjxt";//change accordingly   //← my email password

        String to="hamrounij5@gmail.com";//→ the EMAIL i want to send TO → 587

        // session object
        Properties props = new Properties();
       props.put("mail.smtp.host", "smtp.gmail.com");
   props.put("mail.smtp.socketFactory.port", "465");
   props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });

        //My message :
        try {
            hotel_reservation_Service hs =new hotel_reservation_Service();
            
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Demande de reservation ");
            message.setText("bonjour, Nous vous envoyons une demande de reservation à votre hotel ");
            //Text in emial :
            //message.setText("  → Text message for Your Appointement ← ");
            //Html code in email :
           

            //send the message
            Transport.send(message);

            System.out.println("message sent successfully via mail ... !!! ");

        } catch (MessagingException e) {e.printStackTrace();}

    }

}







