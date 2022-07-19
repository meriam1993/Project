/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author user
 */
public class user {
    private int user_id;
    private String first_name;
        private String last_name;
        private String email;
        private String password;
        private String role;
        private String initial;

   

    public user() {
    }

    public user(int user_id) {
        this.user_id = user_id;
    }

    public user(int user_id,  String role,String first_name, String last_name, String email, String password,String initial) {
        this.user_id = user_id;
        this.role = role;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        
        this.initial = initial;
    }

    public user(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "user{" + "user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", password=" + password + ", role=" + role + ", initial=" + initial + '}';
    }

// 

    public user(String role,String first_name, String last_name, String email, String password ) {
      this.role = role;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        
    }

    public user(String first_name, String last_name, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    public String getInitial() {
       String initF=Character.toString(first_name.charAt(0) );
       String initL=Character.toString(last_name.charAt(0));
      String concatInit=initF.concat(initL);
       initial=concatInit;
        return initial;
    }

     public String getInitial1() {
        return this.initial;
    }
    public void setInitial(String initial) {
        this.initial = initial;
    }

    public user(String first_name, String last_name, String email, String password, String role, String initial) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.initial = initial;
    }

    public user(int user_id, String first_name, String last_name, String role) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
    }

    public user(String email, String password) {
        this.email = email;
        this.password = password;
    }
     
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

  
    

  


   

    
    
}
