/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.hotel;
import entite.reservation_hotel;
import entite.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import utils.DataSource;

/**
 *
 * @author user
 */

public class hotel_reservation_Service implements IService<reservation_hotel>{
    private final Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    
    public hotel_reservation_Service() {
        cnx = DataSource.getInstance().getCon();
    }
    
    
    @Override
 public void insert(reservation_hotel t) {
    String requete = "insert into hotel_reservation (user_id,hotel_id ,type_pension,type_chambre,arrival_date,departure_date,nb_dates,price) values (" + t.getUser1().getUser_id() + "," + t.getHotel().getHotel_id() + ",'" + t.getType_pension() + "','" + t.getType_chambre()+ "','" + t.getCheckin()+ "','" + t.getCheckout()+ "'," + t.getNb_dates()+ "," + t.getPrix()+ ")";
 
    try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            System.out.println("echec ajout user");
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    

    @Override
    public ArrayList<reservation_hotel> getAll() {

        ArrayList<reservation_hotel> Resh=new ArrayList<>();
        
        try {
            
            String req="select * from hotel_reservation";

            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                int userID=rs.getInt(2);
                int hotel_id=rs.getInt(3);
                UserService us =new UserService();                
                HotelService hs =new HotelService();
              Resh.add(new reservation_hotel(rs.getInt(1),us.getById(userID),hs.getById(hotel_id),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getDate(7),rs.getInt(8),rs.getDouble(9)));
                System.out.println(us.getById(userID));
           // Resh.add(new reservation_hotel(rs.getInt(1),us.getById(userID),hs.getById(hotel_id),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getDate(7),rs.getInt(8), (float) rs.getDouble(9)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(hotel_reservation_Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Resh;
        }


   
    @Override
    public reservation_hotel getById(int idh) {

        reservation_hotel Resh=null;
        String req="select * from hotel_reservation where id_reshotel=?";
        try {
            pst=cnx.prepareStatement(req);
            pst.setInt(1, idh);
            rs=pst.executeQuery();
            while(rs.next()){
                 int userID=rs.getInt(2);
                int hotel_id=rs.getInt(3);
                UserService us =new UserService();
                
                HotelService hs =new HotelService();
            Resh = new reservation_hotel(rs.getInt(1),us.getById(userID),hs.getById(hotel_id),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getDate(7),rs.getInt(8),rs.getFloat(9));
            }
        } catch (SQLException ex) {
            Logger.getLogger(reservation_hotel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Resh;
    }
    
    

    public void delete(int id) {
         try {
            String requete = " delete from hotel_reservation where id_reshotel="+id;
            ste=cnx.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(hotel_reservation_Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

 @Override
    public void update(reservation_hotel t) {
        String req=" update hotel_reservation set type_pension = ?, type_chambre =? , arrival_date = ? , departure_date = ? , nb_dates=? , price=?   where id_reshotel =?";
    

        try {            
            pst=cnx.prepareStatement(req);
            pst.setString(1,t.getType_pension());
            pst.setString(2,t.getType_chambre());
            pst.setDate(3, (java.sql.Date) t.getCheckin());
            pst.setDate(4, (java.sql.Date) t.getCheckout()); 
            pst.setInt(5, t.getNb_dates()); 
            pst.setDouble(6,  t.getPrix()); 
            pst.setInt(7, t.getId_reshotel()); 
            pst.executeUpdate();
              
            System.out.println("succes update user ");
 
        } catch (SQLException ex) {
           
            Logger.getLogger(hotel_reservation_Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(reservation_hotel t,int id) {

      String req=" update hotel_reservation set type_pension = ?, type_chambre =? , arrival_date = ? , departure_date = ? , nb_dates=? , price=?   where id_reshotel =?"+id;
        try {
            
            pst=cnx.prepareStatement(req);
            pst.setInt(1,t.getUser1().getUser_id());
            pst.setInt(2,t.getHotel().getHotel_id());
            pst.setString(3,t.getType_pension());
            pst.setString(4,t.getType_chambre());
            pst.setDate(5, (java.sql.Date)  t.getCheckin());
            pst.setDate(6,  (java.sql.Date) t.getCheckout());
            pst.setInt(7,t.getNb_dates());
            pst.setDouble(8,t.getPrix());
             
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(hotel_reservation_Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(reservation_hotel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(reservation_hotel t, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
}
