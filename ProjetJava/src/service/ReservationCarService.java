/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Car_reservation;
import entite.user;
import entite.Car;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import java.util.List;
import service.IService;
import service.IService;
import service.CarService;
import service.UserService;

import utils.DataSource;


/**
 *
 * @author meria
 */
 
public class ReservationCarService implements IService<Car_reservation> {
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public ReservationCarService() {
            cnx=DataSource.getInstance().getCon();
    }

    
    @Override
    public void insert(Car_reservation t) {

    String req="INSERT INTO Car_reservation(user_id,Car_id,Start_date,End_date,price) VALUES  ("+t.getUser_id()+","+ t.getCar_id()+",'"+t.getStart_date()+"','"+t.getEnd_date()+"',"+t.getPrice()+")";
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ReservationCarService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Car_reservation t,int id) {
        

        String req="delete from Car_reservation where Reservation_vol_id="+id;
        try {
            
            ste=cnx.createStatement();
            ste.executeUpdate(req);

        } catch (SQLException ex) {
            Logger.getLogger(ReservationCarService.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public void update(Car_reservation t) {

      String req=" update Car_reservation set  Start_date= ?,End_date= ? where Reservation_car_id=?";
        try {
            
            pst=cnx.prepareStatement(req);
            pst.setDate(1, t.getStart_date());
            pst.setDate(2,(java.sql.Date) t.getEnd_date());
           
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ReservationCarService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Car_reservation> getAll() {

        ArrayList<Car_reservation> CarR=new ArrayList<>();
        
        try {
            
            String req="select * from Car_reservation";

            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
             UserService us=new UserService();
             CarService cs=new CarService();
            while(rs.next()){
                int userId=rs.getInt(2);
                int carId=rs.getInt(3);
                
            CarR.add(new Car_reservation(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4),rs.getDate(5),rs.getDouble(6)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservationCarService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CarR;
        }

    @Override
    public Car_reservation getById(int car_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void deleteByID(Integer id) {
        String req="delete from Car_reservation where Reservation_car_id="+id;
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     *
     * @return
     * @throws SQLException
     */
    public ArrayList checkcar() throws SQLException{
         ArrayList Car_r = new ArrayList();
        
      try {
            
            String req="select Car_id from Car_reservation " ;

            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
             UserService us=new UserService();
             CarService cs=new CarService();
          while(rs.next()){
                
                
            Car_r.add(rs.getInt(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservationCarService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return Car_r;
        }
    public void DC() {
        

        String req="DELETE FROM car_reservation WHERE end_date <CURRENT_TIMESTAMP";
        try {
            
            ste=cnx.createStatement();
            ste.executeUpdate(req);

        } catch (SQLException ex) {
            Logger.getLogger(ReservationCarService.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public void delete(Car_reservation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Car_reservation t, int id) {
          String req=" update Car_reservation set user_id = ? , car_id = ? ,  Start_date= ?,End_date= ? , price = ? where Reservation_car_id="+id;
        try {
            
            pst=cnx.prepareStatement(req);
            pst.setInt(1,t.getUser_id());
            pst.setInt(2,t.getCar_id());
            pst.setDate(3, t.getStart_date());
            pst.setDate(4, t.getEnd_date());
            pst.setDouble(5,t.getPrice());
           
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ReservationCarService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


        
    }
    
           