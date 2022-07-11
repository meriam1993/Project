/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Vol;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import service.VolService;

/**
 * FXML Controller class
 *
 * @author meria
 */
public class FlightsController implements Initializable {

    @FXML
    private TableView<Vol> table;
    @FXML
    private TableColumn<Vol, Integer> vol_id;
    @FXML
    private TableColumn<Vol, String> departure_country;
    @FXML
    private TableColumn<Vol, Integer> seat_nb;
    @FXML
    private TableColumn<Vol, String> classe;
    @FXML
    private TableColumn<Vol, String> airline_company;
    @FXML
    private TableColumn<Vol, Date> vol_date;
    @FXML
    private TableColumn<Vol, Float> price;

    @FXML
    private TextField txt_vol_id;
    @FXML
    private TextField txt_departure_country;
    @FXML
    private TextField txt_nb_place;
    @FXML
    private TextField txt_airline_company;
    @FXML
    private ChoiceBox<String> txt_classe;
    private final String choix[]={"First Class","Business Class","Economy Class"};
    @FXML
    private DatePicker txt_vol_date;
    @FXML
    private TextField txt_price;
    @FXML
    private AnchorPane rootPane;

    private int Vol_idselected;

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
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        VolService ps = new VolService();
        ArrayList<Vol> vol_list = ps.getAll();
        ObservableList<Vol> obs = FXCollections.observableArrayList(vol_list);

        vol_id.setCellValueFactory(new PropertyValueFactory<>("vol_id"));
        seat_nb.setCellValueFactory(new PropertyValueFactory<>("place_nb"));
        departure_country.setCellValueFactory(new PropertyValueFactory<>("departure_country"));

        classe.setCellValueFactory(new PropertyValueFactory<>("classe"));
        airline_company.setCellValueFactory(new PropertyValueFactory<>("airline_company"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        vol_date.setCellValueFactory(new PropertyValueFactory<>("vol_date"));
        table.setItems(obs);
        txt_classe.getItems().addAll(choix);
       
    }

    @FXML
    public void UpdateTable() {

        VolService ps = new VolService();
        ArrayList<Vol> vol_list = ps.getAll();
        ObservableList<Vol> obs = FXCollections.observableArrayList(vol_list);

        vol_id.setCellValueFactory(new PropertyValueFactory<>("vol_id"));
        departure_country.setCellValueFactory(new PropertyValueFactory<>("departure_country"));
        seat_nb.setCellValueFactory(new PropertyValueFactory<>("place_nb"));
        classe.setCellValueFactory(new PropertyValueFactory<>("classe"));
        airline_company.setCellValueFactory(new PropertyValueFactory<>("airline_company"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        vol_date.setCellValueFactory(new PropertyValueFactory<>("vol_date"));

        table.setItems(obs);

    }

    @FXML
    public void Reset() {

        txt_vol_id.clear();
        txt_departure_country.clear();
        txt_nb_place.clear();
        txt_classe.setValue(null);
        txt_airline_company.clear();
        txt_vol_date.setValue(null);
        txt_price.clear();
    }

    @FXML
    private void AddVol(ActionEvent event) throws IOException {

        Vol v = new Vol(txt_departure_country.getText(), Integer.parseInt(txt_nb_place.getText()), txt_classe.getValue(), txt_airline_company.getText(), Date.valueOf(txt_vol_date.getValue()), Float.parseFloat(txt_price.getText()));
        VolService ps = new VolService();
        ps.insert(v);

        UpdateTable();
        Reset();
    }

    @FXML
    private void UpdateVol(ActionEvent event) throws IOException {

        Vol volselected = table.getSelectionModel().getSelectedItem();
        Vol_idselected = volselected.getVol_id();
        VolService ps = new VolService();
   
            Vol v = new Vol();
            v.setDeparture_country(txt_departure_country.getText());
            v.setPlace_nb(Integer.parseInt(txt_nb_place.getText()));
            v.setClasse(txt_classe.getValue());
            v.setAirline_company(txt_airline_company.getText());
            v.setVol_date(Date.valueOf(txt_vol_date.getValue()));
            v.setPrice(Float.parseFloat(txt_price.getText()));
            System.out.println(v);
        
        ps.update(v, Vol_idselected);
        UpdateTable();
        Reset();
    }

    @FXML
    private void DeleteVol(ActionEvent event) throws IOException {

        Vol volselected = table.getSelectionModel().getSelectedItem();
        Vol_idselected = volselected.getVol_id();
        VolService ps = new VolService();
        ps.deleteByID(Vol_idselected);

        UpdateTable();
        Reset();

    }

    @FXML
    public void handleButtonRes(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("Flight_Reservations.fxml"));
        rootPane.getChildren().setAll(pane);

    }
    
    @FXML
    public void handleButtonSelected(ActionEvent event) throws IOException {
      
        txt_departure_country.setText(table.getSelectionModel().getSelectedItem().getDeparture_country());
        
        Integer nb=table.getSelectionModel().getSelectedItem().getPlace_nb();
        String s=String.valueOf(nb);
        txt_nb_place.setText(s);
        
        txt_classe.setValue(table.getSelectionModel().getSelectedItem().getClasse());
        
        txt_airline_company.setText(table.getSelectionModel().getSelectedItem().getAirline_company());
        
        float p=table.getSelectionModel().getSelectedItem().getPrice();
        String s1=String.valueOf(p);
        txt_price.setText(s1);
        
        txt_vol_date.setValue(table.getSelectionModel().getSelectedItem().getVol_date().toLocalDate());
        
        
      
    }

    

}
