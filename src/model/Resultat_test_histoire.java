    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author user
 */
public class Resultat_test_histoire {
    private int id_resultat;
    private int id_user;
    private int id_test;
    private int score;
    private Date date;
    private int ligne_histoire;



    public Resultat_test_histoire() {
    }

     public Resultat_test_histoire(int id_resultat, int id_user, int id_test, int score, Date date, int ligne_histoire) {
        this.id_resultat = id_resultat;
        this.id_user = id_user;
        this.id_test = id_test;
        this.score = score;
        this.date = date;
        this.ligne_histoire = ligne_histoire;
    }

   

     public int getLigne_histoire() {
        return ligne_histoire;
    }

    public void setLigne_histoire(int ligne_histoire) {
        this.ligne_histoire = ligne_histoire;
    }
    
    public int getId_resultat() {
        return id_resultat;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_test() {
        return id_test;
    }

    public int getScore() {
        return score;
    }

    public Date getDate() {
        return date;
    }

    public void setId_resultat(int id_resultat) {
        this.id_resultat = id_resultat;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_test(int id_test) {
        this.id_test = id_test;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Resultat_test_histoire{" + "id_resultat=" + id_resultat + ", id_user=" + id_user + ", id_test=" + id_test + ", score=" + score + ", date=" + date + ", ligne_histoire=" + ligne_histoire + '}';
    }

   


    
    
}
