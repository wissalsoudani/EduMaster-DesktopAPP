/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NEEEGROO
 */
public class Abonnement {
    private int id_abonnement;
    private String login_user;
    private String Type;

    public Abonnement() {
    }

    public Abonnement(String login_user, String Type) {
        this.login_user = login_user;
        this.Type = Type;
    }

    public Abonnement(int id_abonnement, String login_user, String Type) {
        this.id_abonnement = id_abonnement;
        this.login_user = login_user;
        this.Type = Type;
    }

    public int getId_abonnement() {
        return id_abonnement;
    }

    public String login_user() {
        return login_user;
    }

    public String getType() {
        return Type;
    }

    public void setId_abonnement(int id_abonnement) {
        this.id_abonnement = id_abonnement;
    }

    public void setId_user(int id_user) {
        this.login_user= login_user;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    @Override
    public String toString() {
        return "Abonnement{" + "id_abonnement=" + id_abonnement + ", login_user=" + login_user+ ", Type=" + Type + '}';
    }

 
    

}
