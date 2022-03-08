/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.video;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Video;
import util.Maconnexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author dell
 */
public class Video_Implementation implements video {

    Connection cnx = Maconnexion.getInstance().getCnx();       
       
       @Override
    public void ajouterVideo(Video v) {
        
         String req="INSERT INTO `video`(`nom_video`, `date`, `description`, `duree_video`) VALUES ('"+v.getNom_video()+"','"+v.getDate()+"','"+v.getDescription()+"','"+v.getDuree_video()+"')";
         try {
             //insert
            Statement st = cnx.createStatement();
            st.executeUpdate(req,0); 
            System.out.println("video ajoutee avec succes!");
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }  
    }

   
    @Override
    public ObservableList<Video> afficher() {
 ObservableList<Video> videos =FXCollections.observableArrayList();        
         try {
            String req="SELECT * FROM `video`";
            Statement st= cnx.createStatement();
            ResultSet rs=st.executeQuery(req);
            while(rs.next()){
        
                videos.add(new Video(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5)));
                
            }
            
         }
         catch(SQLException ex)
         {
             ex.printStackTrace();
         }        
       
        return videos;
      
        
    }

   
    @Override
    public void SupprimerParId(Video v) {
       String req="DELETE FROM `video` WHERE id_video="+v.getId_video();
        try{
              Statement st=cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("video supprimee avec succes!");
            
        }
        catch(SQLException ex){  
         ex.printStackTrace();
        }
        
    }

   
    

    @Override
    public void ModifierVideo(Video v) {
        
        
        
        try{
            String req="UPDATE `video` SET`nom_video`='"+v.getNom_video()+"',`date`='"+v.getDate()+"',`description`='"+v.getDescription()+"',`duree_video`='" +v.getDuree_video()+"'WHERE id_video="+v.getId_video();
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("video modifiee avec succes!");
        }
        catch(SQLException ex){
            ex.printStackTrace();
            
        }
        
    }

   
    
}
