/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entity.Vol_reservation;
import Entity.user;
import Entity.Vol;
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
 * @author meria
 */
public class ReservationVolService implements IService<Vol_reservation> {
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public ReservationVolService() {
            cnx=DataSource.getInstance().getCon();
    }

    
    @Override
    public void insert(Vol_reservation t) {

    String req="INSERT INTO `vol_reservation`(`user_id`, `vol_id`, `departure_country`, `arrival_country`, `departure_date`, `price`) VALUES  ("+t.getUser().getUser_id()+","+ t.getVol().getVol_id()+",'"+ t.getDeparture_country()+"','"+t.getArrival_country()+"','"+t.getDeparture_date()+"',"+t.getPrice()+")";
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ReservationVolService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Vol_reservation t,int id) {
        

        String req="delete from vol_reservation where Reservation_vol_id="+id;
        try {
            
            ste=cnx.createStatement();
            ste.executeUpdate(req);

        } catch (SQLException ex) {
            Logger.getLogger(ReservationVolService.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public void update(Vol_reservation t,int id) {

      String req=" update vol_reservation set user_id = ? , vol_id = ? , departure_country = ?  , arrival_country = ? , departure_date= ? , price = ? where Reservation_vol_id="+id;
        try {
            
            pst=cnx.prepareStatement(req);
            pst.setInt(1,t.getUser().getUser_id());
            pst.setInt(2,t.getVol().getVol_id());
            pst.setString(3,t.getDeparture_country());
            pst.setString(4,t.getArrival_country());
            pst.setDate(5,t.getDeparture_date());
            pst.setFloat(6,t.getPrice());

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ReservationVolService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        

  public void deleteByID(Integer id) {
        String req="delete from vol_reservation where Reservation_vol_id="+id;
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
    
    public ArrayList<Vol_reservation> getAll() {

        ArrayList<Vol_reservation> ResV=new ArrayList<>();
        
        try {
            
            String req="select * from vol_reservation";

            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                int userId=rs.getInt(2);
                UserService us=new UserService();
                int VolId=rs.getInt(3);
                VolService vo=new VolService();
            ResV.add(new Vol_reservation(rs.getInt(1),us.getById(userId),vo.getById(VolId),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getFloat(7)));
            
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservationVolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ResV;
        }

    @Override
    public Vol_reservation getById(int idU) {

        Vol_reservation ResV=null;
        String req="select * from vol_reservation where reservation_vol_id=?";
        try {
            pst=cnx.prepareStatement(req);
            pst.setInt(1, idU);
            rs=pst.executeQuery();
            while(rs.next()){
            int userId=rs.getInt(2);
            UserService us=new UserService();
            int VolId=rs.getInt(3);
            VolService vo=new VolService();
            ResV = new Vol_reservation(rs.getInt(1),us.getById(userId),vo.getById(VolId),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getFloat(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationVolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ResV;
    }
    
    
}
