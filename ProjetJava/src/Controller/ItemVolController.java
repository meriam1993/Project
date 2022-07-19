/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import main.MyListener;
import entite.Vol;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javafx.scene.layout.AnchorPane;
import main.Main;



public class ItemVolController {
    @FXML
    private Label nameLabel;
    @FXML
    private Label priceLable;
    @FXML
    private ImageView img;
    @FXML
    private Label priceLable1;
    @FXML
    private Label priceLable21;
    @FXML
    private Label priceLable2;
    @FXML
    private AnchorPane ItemVol;
    
    
    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(vol);
        ItemVol.setStyle(" -fx-border-color:#3BA925; -fx-border-width:5; -fx-border-radius:30; ");
    }
    
    private void clickTest(MouseEvent mouseEvent) {
        myListener.onClickListener(vol);
        ItemVol.setStyle(" -fx-border-color:black; -fx-border-width:5; -fx-border-radius:30; ");
    }
    
    private Vol vol;
    private MyListener myListener;

    public void setData(Vol vol, MyListener myListener) {
        this.vol = vol;
        this.myListener = myListener;
        nameLabel.setText(vol.getDeparture_country());
        priceLable.setText(vol.getAirline_company());
        priceLable2.setText(vol.getClasse());
        //DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/mm/dd");
        priceLable21.setText(vol.getVol_date().toString());
        priceLable1.setText(Main.CURRENCY + vol.getPrice());
    }
}
