/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author dell
 */
public class Video {
     private int id_video;
     private String nom_video ;
     private String date;
     private String description;
     private String duree_video;

    public Video() {
    }

    public Video(int id_video, String nom_video, String date, String description, String duree_video) {
        this.id_video = id_video;
        this.nom_video = nom_video;
        this.date = date;
        this.description = description;
        this.duree_video = duree_video;
    }

    public Video(String nom_video, String date, String description, String duree_video) {
        this.nom_video = nom_video;
        this.date = date;
        this.description = description;
        this.duree_video = duree_video;
    }

   
    

    
   

    public int getId_video() {
        return id_video;
    }

    public void setId_video(int id_video) {
        this.id_video = id_video;
    }

    public String getNom_video() {
        return nom_video;
    }

    public void setNom_video(String nom_video) {
        this.nom_video = nom_video;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuree_video() {
        return duree_video;
    }

    public void setDuree_video(String duree_video) {
        this.duree_video = duree_video;
    }

    
    @Override
    public String toString() {
        return "Video{" + "id_video=" + id_video + ", nom_video=" + nom_video + ", date=" + date + ", description=" + description + ", duree_video=" + duree_video + '}';
    }

    
     
     
     
 
}
