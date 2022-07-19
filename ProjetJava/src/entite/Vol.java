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
public class Vol {
    
    private int vol_id;
    private String departure_country;
    private int place_nb;
    private String classe;
    private String airline_company;
    private Date vol_date;
    private float price;

    public Vol(int vol_id,String departure_country, int place_nb, String classe, String airline_company,Date vol_date ,float price) {
        this.vol_id = vol_id;
        this.departure_country=departure_country;
        this.place_nb = place_nb;
        this.classe = classe;
        this.airline_company = airline_company;
        this.vol_date = vol_date;
        this.price = price;
    }

    public Vol(String departure_country,int place_nb, String classe, String airline_company,Date vol_date, float price) {
        this.departure_country=departure_country;
        this.place_nb = place_nb;
        this.classe = classe;
        this.airline_company = airline_company;
        this.vol_date = vol_date;
        this.price = price;
    }

    public Vol() {
    }

   

    public int getVol_id() {
        return vol_id;
    }

    public void setVol_id(int vol_id) {
        this.vol_id = vol_id;
    }

    public int getPlace_nb() {
        return place_nb;
    }

    public void setPlace_nb(int place_nb) {
        this.place_nb = place_nb;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getAirline_company() {
        return airline_company;
    }

    public void setAirline_company(String airline_company) {
        this.airline_company = airline_company;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getVol_date() {
        return vol_date;
    }

    public void setVol_date(Date vol_date) {
        this.vol_date = vol_date;
    }

    public String getDeparture_country() {
        return departure_country;
    }

    public void setDeparture_country(String departure_country) {
        this.departure_country = departure_country;
    }

    @Override
    public String toString() {
        return "Vol{" + "vol_id=" + vol_id + ", departure_country=" + departure_country + ", place_nb=" + place_nb + ", classe=" + classe + ", airline_company=" + airline_company + ", vol_date=" + vol_date + ", price=" + price + '}';
    }  
    
    

}


