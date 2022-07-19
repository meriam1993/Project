/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.util.ArrayList;
import entite.hotel;
import entite.reservation_hotel;
import utils.DataSource; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author user
 */
public class HotelService implements IService<hotel>{

    
     private final Connection cnx;

    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
     public HotelService() {
        cnx = DataSource.getInstance().getCon();
    } 
    @Override
    public void insert(hotel t) {
    String requete = "insert into hotel (hotel_name,location,room_nb,hotel_rate,ImgSrc,price) values ('" + t.getNom() + "','" + t.getLocation() + "'," + t.getNb_room() + "," + t.getHotel_rate()+ ",'" + t.getImgSrc() + "'," + t.getPrice() + ")";
 
    try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }
            throw new UnsupportedOperationException("inseré avec succé"); //To change body of generated methods, choose Tools | Templates.

    }
    
    
    public void delete(int id) {
         
             String req="delete from hotel where hotel_id="+id;
         try {
             ste=cnx.createStatement();
             ste.executeUpdate(req);
         } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
         }
             
             
    
    }
    
     @Override
    public void update(hotel h) {
      String req=" update hotel set hotel_name =? ,location=? , room_nb = ? , hotel_rate= ?,ImgSrc=?,price=? where hotel_id = ?";
        try {
            pst=cnx.prepareStatement(req);
            pst.setString(1,h.getNom());
            pst.setString(2,h.getLocation());
            pst.setInt(3, h.getNb_room());
            pst.setInt(4,h.getHotel_rate());
             pst.setString(5,h.getImgSrc());
              pst.setDouble(6,h.getPrice());
            pst.setInt(7,h.getHotel_id());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NOT WORKING");
        }
       
    }
    public void update(hotel t,int id) {

        String req=" update hotel set hotel_name = ? , location =? , room_nb = ? , hotel_rate= ?, ImgSrc= ?, price= ? where hotel_id ="+id;
        try {
            pst=cnx.prepareStatement(req);
            pst.setString(1,t.getNom());
            pst.setString(2,t.getLocation());
            pst.setInt(3, t.getNb_room());
            pst.setInt(4,t.getHotel_rate());
             pst.setString(5,t.getImgSrc());
              pst.setDouble(6,t.getPrice());
              pst.setDouble(7,t.getHotel_id());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    public ArrayList<hotel> getAll() {
         
             ArrayList<hotel> list1=new ArrayList<>();
             String req="select * from hotel";
             try {
             ste=cnx.createStatement();
             rs=ste.executeQuery(req);
             while(rs.next()){
             list1.add(new hotel(rs.getInt(1),rs.getString("hotel_name"),rs.getString("location"),rs.getInt(4),rs.getInt(5),rs.getString("ImgSrc"),rs.getDouble(7)));
                          }
         } catch (SQLException ex) {
             Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
         }
         return list1;
    
        }
    
     public ArrayList<hotel> getByname(String name) {
        ArrayList hotels =new ArrayList<>();
        String req="select * from hotel where hotel_name=?";
        try {
            pst=cnx.prepareStatement(req);
            pst.setString(1, name);
            rs=pst.executeQuery();
            while(rs.next()){  
           hotels.add(new hotel(rs.getInt(1),rs.getString("hotel_name"),rs.getString("location"),rs.getInt(4),rs.getInt(5),rs.getString("ImgSrc"),rs.getDouble(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(reservation_hotel.class.getName()).log(Level.SEVERE, null, ex);
        }
    return hotels;
    }
     

    @Override
    public hotel getById(int id) {
        hotel h=null;
        try {    
        String req="select * from hotel where hotel_id=?";

            pst=cnx.prepareStatement(req);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            while(rs.next()){
            h = new hotel(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getString(6),rs.getDouble(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(hotel.class.getName()).log(Level.SEVERE, null, ex); 
    }
         return h;
    }

    @Override
    public void delete(hotel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(hotel t, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   

        
    



}
   
    

