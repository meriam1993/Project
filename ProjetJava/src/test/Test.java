/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import Entity.user;
import Entity.Vol_reservation;
import Entity.Vol;
import java.sql.Date;
import static java.time.LocalDateTime.now;
import service.ReservationVolService;
import service.UserService;
import service.VolService;
import utils.DataSource;



/**
 *
 * @author wiemhjiri
 */
public class Test {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
       
//        DataSource ds1=DataSource.getInstance();
//        System.out.println(ds1);
//        
//        DataSource ds2=DataSource.getInstance();
//        System.out.println(ds2);
//        
//        DataSource ds3=DataSource.getInstance();
//        System.out.println(ds3);

    //Personne p1=new Personne(12,"test", "1cinfo2", 21);
    //PersonneService ps=new PersonneService();
    // ps.insert(p1);
    // ps.insertPst(p1);
    //  ps.getAll().forEach(e->System.out.println(e));
    //ps.delete(p1);
    //Date date=Date.valueOf("2022-06-14");

//     //Vol V1= new Vol(10,"A","Turkish airline",date,1200);
//     Vol V2= new Vol(15,"B","France airline",date,5200);
//     VolService psv1 = new VolService ();
//     psv1.insert(V2);
//     psv1.insert(V1);

    //psv1.delete(V2);
     //psv1.insert(V2);
     //user u1=new user(3,"user","Meriam","Hjiri","M_Hjiri","khouloud");
     //UserService psu1 = new UserService ();
     // psu1.insert(u1);
    //psu1.delete(u1);
      
      
     //vol_reservation RV1= new Vol_reservation (u1,V2,"Korea","Tunis", date ,1500);
    // ReservationVolService ps2=new ReservationVolService();
      //ps2.insert(RV1);
      //ps2.getAll().forEach(e->System.out.println(e));
      
     //ps.delete(V2);
//      System.out.println("TEST GET ALL");
//      ps.getAll().forEach(e->System.out.println(e));
//      System.out.println("TEST GET ID 2");
//
//      System.out.println(ps.getById(2));
      
      
              Date d=Date.valueOf("2022-06-14");

        System.out.println(d);
        VolService vs= new VolService();
        vs.getFlight("France",d).forEach(e->System.out.println(e));
        
       java.util.Date date = new java.util.Date(); 
        
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);
        System.out.println(System.getProperties());
        
      
    }
    
}
