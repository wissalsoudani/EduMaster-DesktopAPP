/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author NEEEGROO
 */
public class User  {
   private  int id_user;
   private int id_abonnement;
   private String login;
   private String mdp;
   private String nom;
   private String prenom;
   private int niveau;
   private String mail;
   
   
   public User() {
    }
   
    public User(String login, String mdp, String mail) {
        this.login = login;
        this.mdp = mdp;
        this.mail = mail;
    }

    public User(int id_user, int id_abonnement, String login, String mdp, String nom, String prenom, int niveau, String mail) {
        this.id_user = id_user;
        this.id_abonnement = id_abonnement;
        this.login = login;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.niveau = niveau;
        this.mail = mail;
    }

    public User( String login, String mdp, String nom, String prenom, int niveau, String mail) {
        
        this.login = login;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.niveau = niveau;
        this.mail = mail;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }
   
    public int getId_abonnement() {
        return id_abonnement;
    }

    public String getMail() {
        return mail;
    }

    public int getId_user() {
        return id_user;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    public void setId_abonnement(int id_abonnement) {
        this.id_abonnement = id_abonnement;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return "User : " + "Login=" + login + " Mail=" + mail + '.';
    }

   

    


}
