/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Car;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author wiemhjiri
 */
public class CarService implements IService<Car> {

    private Connection cnx;

    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public CarService() {
        cnx = DataSource.getInstance().getCon();
    }

    @Override
    public void insert(Car t) {
        String requete = "insert into Car (Car_id,Car_brand,Car_model,imgSrc,kilometrage,price,color) values ('"+t.getCar_id()+"','"+t.getCar_brand()+"','"+t.getCar_model()+"','"+t.getImgSrc()+"','"+t.getKilometrage()+"','"+t.getPrice()+"')";
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertPst(Car t) {
        String requete = "insert into Car (Car_brand,Car_model,imgSrc,kilometrage,price) values  (?,?,?,?,?)";

        try {
            pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getCar_brand());
            pst.setString(2, t.getCar_model());
            pst.setString(3, t.getImgSrc());
            pst.setInt(4, t.getKilometrage());
            pst.setDouble(5, t.getPrice());
            
            
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void delete(Car t) {
        String req="delete from Car where Car_id="+t.getCar_id();
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    @Override
    public void update(Car t) {

        String req=" update Car set Car_id = ? , Car_brand =? , Car_model= ? , imgSrc= ? , kilometrage= ? ,price= ?  where Car_id = ?";
        try {
            pst=cnx.prepareStatement(req);
            pst.setInt(1,t.getCar_id());
            pst.setString(2,t.getCar_brand());
            pst.setString(3, t.getCar_model());
             pst.setString(4, t.getImgSrc());
             pst.setInt(5, t.getKilometrage());
             
            pst.setDouble(6,t.getPrice());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public ArrayList<Car> getAll() {
         ArrayList<Car> Car_list=new ArrayList<>();
        String requete="select * from car";
        try {
            ste=cnx.createStatement();
           rs=ste.executeQuery(requete);
           while(rs.next()){
               Car_list.add(new Car(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5),rs.getDouble(6)));
           }
        } catch (SQLException ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Car_list;
    }

    @Override
    public Car getById(int id) {
        
        Car Cars=null;

        String req="select * from Car where Car_id = ? ";
        try {
            pst=cnx.prepareStatement(req);
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while(rs.next()){
            Cars = new Car(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5),rs.getDouble(6));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  Cars;
        
    }

    @Override
    public void delete(Car t, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Car t, int id) {
             String req=" update Car set Car_brand =? , Car_model= ? , imgSrc= ? , kilometrage= ? ,price= ? where Car_id ="+id;
        try {
            pst=cnx.prepareStatement(req);
            
            pst.setString(1,t.getCar_brand());
            pst.setString(2, t.getCar_model());
             pst.setString(3, t.getImgSrc());
             pst.setInt(4, t.getKilometrage());
            pst.setDouble(5,t.getPrice());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
       
    }
    