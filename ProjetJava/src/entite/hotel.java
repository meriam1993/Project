/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author user
 */
public class hotel {
    private int hotel_id;
    private String nom;
    private String location;
    private int nb_room;
    private int hotel_rate;
    private String ImgSrc;
    private double price;

    public hotel(int hotel_id, String nom, String location, int nb_room, int hotel_rate, String imgSrc, double price) {
        this.hotel_id = hotel_id;
        this.nom = nom;
        this.location = location;
        this.nb_room = nb_room;
        this.hotel_rate = hotel_rate;
        this.ImgSrc = imgSrc;
        this.price = price;
    }

    public hotel(String nom, String location, int nb_room, int hotel_rate, String imgSrc, double price) {
        this.nom = nom;
        this.location = location;
        this.nb_room = nb_room;
        this.hotel_rate = hotel_rate;
        this.ImgSrc = imgSrc;
        this.price = price;
    }

    public hotel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNb_room() {
        return nb_room;
    }

    public void setNb_room(int nb_room) {
        this.nb_room = nb_room;
    }

    public int getHotel_rate() {
        return hotel_rate;
    }

    public void setHotel_rate(int hotel_rate) {
        this.hotel_rate = hotel_rate;
    }

    public String getImgSrc() {
        return ImgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.ImgSrc = imgSrc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "hotel{" + "hotel_id=" + hotel_id + ", nom=" + nom + ", location=" + location + ", nb_room=" + nb_room + ", hotel_rate=" + hotel_rate + ", ImgSrc=" + ImgSrc + ", price=" + price + '}';
    }

    
    
   
    
    
    
}
