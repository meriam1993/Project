/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import Entity.Vol;
import Entity.Vol_reservation;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;
/**
 *
 * @author meria
 */
public class VolService implements IService<Vol> {
    
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public VolService() {
            cnx=DataSource.getInstance().getCon();
    }
    

    @Override
    public void insert(Vol t) {

        try {
            
            String req="insert into vol( departure_country,place_nb,classe,airline_company,vol_date,price) values (?,?,?,?,?,?)";
            
            pst=cnx.prepareStatement(req);
            pst.setString(1,t.getDeparture_country());
            pst.setInt(2,t.getPlace_nb());
            pst.setString(3,t.getClasse());
            pst.setString(4, t.getAirline_company());
            pst.setDate(5,t.getVol_date());
            pst.setFloat(6,t.getPrice());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Vol t,int id) {
        String req="delete from vol where vol_id="+t.getVol_id();
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
    
    public void deleteByID(Integer id) {
        String req="delete from vol where vol_id="+id;
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    @Override
    public void update(Vol t,int id) {

        String req=" update vol set Departure_country = ?, place_nb = ? , classe =? , airline_company = ?,vol_date = ? , price= ? where vol_id ="+id;
        try {
            pst=cnx.prepareStatement(req);
            pst.setString(1,t.getDeparture_country());
            pst.setInt(2,t.getPlace_nb());
            pst.setString(3,t.getClasse());
            pst.setString(4, t.getAirline_company());
            pst.setDate(5,t.getVol_date());
            pst.setFloat(6,t.getPrice());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public ArrayList<Vol> getAll() {

        ArrayList<Vol> Vols=new ArrayList<>();
        String req="select * from vol";

        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
            Vols.add(new Vol(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getFloat(7)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Vols;
    }

    @Override
    public Vol getById(int id) {
        
        Vol Vols=null;

        String req="select * from vol where vol_id = ? ";
        try {
            
            pst=cnx.prepareStatement(req);
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while(rs.next()){
            Vols = new Vol(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getFloat(7));
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Vols;
        
    }
    
        public void updateNbrPlace(Vol t,int id,int nb) {

        String req=" update vol set place_nb = ? where vol_id="+id;
        try {
            
            pst=cnx.prepareStatement(req);
            pst.setInt(1,nb);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ReservationVolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        public ArrayList<Vol> getFlight(String dep_coun,Date dep_date) {
        ArrayList<Vol> Vols=new ArrayList<>();
        String req="select * from vol where departure_country=? and vol_date >=?";
       

        try {
            
            pst=cnx.prepareStatement(req);
            pst.setString(1,dep_coun);
            pst.setDate(2,dep_date);
            rs=pst.executeQuery();
            while(rs.next()){
            Vols.add(new Vol(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getFloat(7)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Vols;
        
    }
   

   
    
}
