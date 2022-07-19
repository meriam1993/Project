/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entite;
import java.sql.Date;

/**
 *
 * @author meria
 */
public class Vol_reservation {
    private Integer Reservation_vol_id;
    private user user;
    private Vol vol;
    private String departure_country;
    private String arrival_country;
    private Date departure_date;
    private float price;
    private int user_id;
    private int vol_id;
    

    public Vol_reservation(Integer Reservation_vol_id, user user, Vol vol, String departure_country, String arrival_country, Date departure_date, float price) {
        this.Reservation_vol_id = Reservation_vol_id;
        this.user = user;
        this.vol = vol;
        this.departure_country = departure_country;
        this.arrival_country = arrival_country;
        this.departure_date = departure_date;
        this.price = price;
    }

    public Vol_reservation(user user, Vol vol, String departure_country, String arrival_country, Date departure_date, float price) {
        this.user = user;
        this.vol = vol;
        this.departure_country = departure_country;
        this.arrival_country = arrival_country;
        this.departure_date = departure_date;
        this.price = price;
    }

    public Vol_reservation(Integer Reservation_vol_id,String departure_country, String arrival_country, Date departure_date, float price) {
        this.Reservation_vol_id = Reservation_vol_id;
        this.departure_country = departure_country;
        this.arrival_country = arrival_country;
        this.departure_date = departure_date;
        this.price = price;
    }

    



    public Integer getReservation_vol_id() {
        return Reservation_vol_id;
    }

    public void setReservation_vol_id(Integer Reservation_vol_id) {
        this.Reservation_vol_id = Reservation_vol_id;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public String getDeparture_country() {
        return departure_country;
    }

    public void setDeparture_country(String departure_country) {
        this.departure_country = departure_country;
    }

    public String getArrival_country() {
        return arrival_country;
    }

    public void setArrival_country(String arrival_country) {
        this.arrival_country = arrival_country;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getUser_id() {
        return user.getUser_id();
    }

    public void setUser_id(int user_id) {
        this.user_id = user.getUser_id();
    }

    public int getVol_id() {
        return vol.getVol_id();
    }

    public void setVol_id(int vol_id) {
        this.vol_id = vol.getVol_id();
    }


    @Override
    public String toString() {
        return "vol_reservation{" + "Reservation_vol_id=" + Reservation_vol_id + ", user=" + user.getUser_id() + ", vol=" + vol.getVol_id() + ", departure_country=" + departure_country + ", arrival_country=" + arrival_country + ", departure_date=" + departure_date + ", price=" + price + '}';
    }

   
    
    
    
    

    
    
    
    
}
