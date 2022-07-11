/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entity.user;
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
public class UserService implements IService<user> {

    private static Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    private ArrayList<user> list;

    public UserService() {
        cnx = DataSource.getInstance().getCon();
    }

    @Override
    public void insert(user t) {
        String req = "insert into user(role,first_name,last_name,email,password,initial) values(?,?,?,?,?,?)";
        try {
            pst = cnx.prepareStatement(req);
            pst.setString(1, "Client");
            pst.setString(2, t.getFirst_name());
            pst.setString(3, t.getLast_name());
            pst.setString(4, t.getEmail());
            pst.setString(5, t.getPassword());
            pst.setString(6, t.getInitial().toUpperCase());
            pst.executeUpdate();
            System.out.println(t.getInitial());
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       public user getbyEmail(String mail){
        user us = new user();
//      String  init=us.getInitial();
        String req = "select * from user where email=?";
        try {
            pst = cnx.prepareStatement(req);
            pst.setString(1,mail.toString());
            
            
            rs = pst.executeQuery();
            while (rs.next()) {
                us = new user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7));
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

      return us;
    } 
    public boolean CheckEmailExist(String Email) throws SQLException {
        boolean emailExists = false;
        user us = null;
        String req2 = "select * from user where email=? ";
        try {
            pst = cnx.prepareStatement(req2);
            pst.setString(1, Email);
            rs = pst.executeQuery();
            while (rs.next()) {
                us = new user(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6));
                emailExists = true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return emailExists;

    }

    @Override
    public void delete(user t,int id) {
        String req = "delete from user where user_id="+id;
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(user t,int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<user> getAll() {
        ArrayList<user> list = new ArrayList<>();
        String requete = "select * from user";
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                list.add(new user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    @Override
    public user getById(int id) {

        user us = null;
        String req = "select * from user where user_id=?";
        try {
            pst = cnx.prepareStatement(req);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                us = new user(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return us;
    }

}
