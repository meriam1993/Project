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
public class rate {
     private int rate_id ;
     private user user;
     private int stars;

    public rate() {
    }

    public rate(user user, int stars) {
        this.user = user;
        this.stars = stars;
    }

    public rate( int stars) {
     
        this.stars = stars;
    }

    public rate(int rate_id, user user, int stars) {
        this.rate_id = rate_id;
        this.user = user;
        this.stars = stars;
    }

    public int getRate_id() {
        return rate_id;
    }

    public void setRate_id(int rate_id) {
        this.rate_id = rate_id;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "rate{" + "rate_id=" + rate_id + ", user=" + user + ", stars=" + stars + '}';
    }
     
}
