/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.rate;
import entite.user;
import utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class RateService implements IService<rate> {
  private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
      public RateService() {
            cnx=DataSource.getInstance().getCon();
    }
    @Override
    public void insert(rate t) {
   String req = "insert into rate(user_id,stars) values(?,?)";
        try {

            pst = cnx.prepareStatement(req);
           
            pst.setInt(1, t.getUser().getUser_id());
            pst.setInt(2,t.getStars());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
    

    @Override
    public void delete(rate t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(rate t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<rate> getAll() {
        ArrayList<rate> liste = new ArrayList<>();
        try {
            
            String req="select * from rate";

            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                int userId=rs.getInt(2);
                UserService us=new UserService();
  
            liste.add(new rate(rs.getInt(1),us.getById(userId),rs.getInt(3)));
            
            }

        } catch (SQLException ex) {
            Logger.getLogger(RateService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
        }
  public int getRateByUser(int idU) {
          rate us=null;

      int  nbStars = 0;
        try {
            
            String req="select stars from rate where user_id="+idU;

            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                while (rs.next()) {
                us = new rate(rs.getInt(1));
                nbStars=us.getStars();
            }
            }   } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nbStars;
        }
    @Override
    public rate getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(rate t, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(rate t, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
