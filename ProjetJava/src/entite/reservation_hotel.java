/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;


import java.util.Date;


/*image  fel base chemin w f java  string*/
public class reservation_hotel {
    
    private int id_reshotel;
    private hotel hotel ;
    private user user1;
    private String type_pension;
     private String type_chambre;
     private Date checkin;
     private Date checkout;
    

     private int nb_dates;
     private double prix;
     private int user_id;
     private int hotel_id;

    public reservation_hotel(int id_reshotel,user user1,hotel hotel1, String type_pension, String type_chambre, Date checkin, Date checkout, int nb_dates, double prix) {
        this.id_reshotel = id_reshotel;
        
        this.user1 = user1;
        this.hotel = hotel1;
        this.type_pension = type_pension;
        this.type_chambre = type_chambre;
        this.checkin = checkin;
        this.checkout = checkout;
        this.nb_dates = nb_dates;
        this.prix = prix;
    }

    public reservation_hotel(user user1,hotel hotel, String type_pension, String type_chambre, Date checkin, Date checkout, int nb_dates, double prix) {
        
        this.user1 = user1;
        this.hotel = hotel;
        this.type_pension = type_pension;
        this.type_chambre = type_chambre;
        this.checkin = checkin;
        this.checkout = checkout;
        this.nb_dates = nb_dates;
        this.prix = prix;
    }

    public reservation_hotel() {
    }

    

   
    

   

    public int getId_reshotel() {
        return id_reshotel;
    }

    public void setId_reshotel(int id_reshotel) {
        this.id_reshotel = id_reshotel;
    }

    public hotel getHotel() {
        return hotel;
    }

    public void setHotel(hotel hotel) {
        this.hotel = hotel;
    }

    public user getUser1() {
        return user1;
    }

    public void setUser1(user user1) {
        this.user1 = user1;
    }

    public String getType_pension() {
        return type_pension;
    }

    public void setType_pension(String type_pension) {
        this.type_pension = type_pension;
    }

    public String getType_chambre() {
        return type_chambre;
    }

    public void setType_chambre(String type_chambre) {
        this.type_chambre = type_chambre;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public int getNb_dates() {
        return nb_dates;
    }

    public void setNb_dates(int nb_dates) {
        this.nb_dates = nb_dates;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    public int getUser_id() {
        return user1.getUser_id();
    }

    public void setUser_id(int user_id) {
       this.user_id = user1.getUser_id();
    }

    public int getHotel_id() {
        return hotel.getHotel_id();
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel.getHotel_id();
    }
   
    

    @Override
    public String toString() {
        return "reservation_hotel{" + "id_reshotel=" + id_reshotel + ", hotel=" + hotel + ", user1=" + user1 + ", type_pension=" + type_pension + ", type_chambre=" + type_chambre + ", checkin=" + checkin + ", checkout=" + checkout + ", nb_dates=" + nb_dates + ", prix=" + prix + ", user_id=" + user_id + ", hotel_id=" + hotel_id + '}';
    }
    
    
    
    
}
