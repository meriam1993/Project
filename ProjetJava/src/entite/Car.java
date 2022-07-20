/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author chihe
 */
public class Car {
    private int Car_id;
    private String Car_brand;
    private String Car_model;
     private String imgSrc;
     private int kilometrage;
    private double price;
    private String color;

    public int getCar_id() {
        return Car_id;
    }

    public void setCar_id(int Car_id) {
        this.Car_id = Car_id;
    }

    public String getCar_brand() {
        return Car_brand;
    }

    public void setCar_brand(String Car_brand) {
        this.Car_brand = Car_brand;
    }

    public String getCar_model() {
        return Car_model;
    }

    public void setCar_model(String Car_model) {
        this.Car_model = Car_model;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }
    

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" + "Car_id=" + Car_id + ", Car_brand=" + Car_brand + ", Car_model=" + Car_model + ", imgSrc=" + imgSrc + ", kilometrage=" + kilometrage + ", price=" + price + ", color=" + color + '}';
    }

    public Car(int Car_id, String Car_brand, String Car_model, String imgSrc, int kilometrage, double price, String color) {
        this.Car_id = Car_id;
        this.Car_brand = Car_brand;
        this.Car_model = Car_model;
        this.imgSrc = imgSrc;
        this.kilometrage = kilometrage;
        this.price = price;
        this.color = color;
       
    }

    public Car(String Car_brand, String Car_model, String imgSrc, int kilometrage, double price, String color) {
        this.Car_brand = Car_brand;
        this.Car_model = Car_model;
        this.imgSrc = imgSrc;
        this.kilometrage = kilometrage;
        this.price = price;
        this.color = color;
    }

    public Car() {
    }

   

    
}
