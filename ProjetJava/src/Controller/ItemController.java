/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.Main;
import main.MyListener;
import entite.Car;


public class ItemController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;
   

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(car);
    }

    private Car car;
    private MyListener myListener;

    public void setData(Car car, MyListener myListener) {
        this.car = car;
        this.myListener = myListener;
        nameLabel.setText(car.getCar_model());
        priceLable.setText(Main.CURRENCY + car.getPrice());
        Image image = new Image(getClass().getResourceAsStream(car.getImgSrc()));
        img.setImage(image);
        
    }
}
