/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;
import Entity.Car;
import Entity.user;
import java.sql.Date;

/**
 *
 * @author meria
 */
public class Car_reservation {
    private Integer Reservation_Car_id;

  
    private int user_id;
    private int Car_id;
   private Date Start_date;
    private Date End_date;
    private double price;

    public Integer getReservation_Car_id() {
        return Reservation_Car_id;
    }

    public void setReservation_Car_id(Integer Reservation_Car_id) {
        this.Reservation_Car_id = Reservation_Car_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCar_id() {
        return Car_id;
    }

    public void setCar_id(int Car_id) {
        this.Car_id = Car_id;
    }

   

    public Date getStart_date() {
        return Start_date;
    }

    public void setStart_date(Date Start_date) {
        this.Start_date = Start_date;
    }

    public Date getEnd_date() {
        return End_date;
    }

    public void setEnd_date(Date End_date) {
        this.End_date = End_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Car_reservation(Integer Reservation_Car_id, int user_id, int Car_id,Date Start_date,Date End_date, double price) {
        this.Reservation_Car_id = Reservation_Car_id;
        this.user_id = user_id;
        this.Car_id = Car_id;
        this.Start_date =  Start_date;
        this.End_date =  End_date;
        this.price = price;
        
    }

    public Car_reservation(int user_id, int Car_id, Date Start_date, Date End_date, double price) {
        this.user_id = user_id;
        this.Car_id = Car_id;
        this.Start_date = Start_date;
        this.End_date = End_date;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car_reservation{" + "Reservation_Car_id=" + Reservation_Car_id + ", user_id=" + user_id + ", Car_id=" + Car_id + ", Start_date=" + Start_date + ", End_date=" + End_date + ", price=" + price + '}';
    }
    
    }

    
