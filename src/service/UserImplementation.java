/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import util.Maconnexion; 
import interfaces.user_i;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import model.User;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Mail;
/**
 *
 * @author NEEEGROO
 */
public class UserImplementation implements user_i {
    static java.sql.Connection cnx = Maconnexion.getInstance().getCnx();
    
    public static String getRandomNumberString() {
    // It will generate 6 digit random Number.
    // from 0 to 999999
    Random rnd = new Random();
    int number = rnd.nextInt(9999);

    // this will convert any number sequence into 6 character.
    return String.format("%06d", number);
}
    
    @Override
    public void ajouterUser(User u) {
        byte[] output;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            String input=u.getMdp();
            md.update(input.getBytes());
            output = md.digest();
            u.setMdp( Base64.getEncoder().encodeToString(output));
            
        } catch (Exception ex) {
            System.out.println("Exception: "+ex);
        }
        String req = "INSERT INTO `user`( `login`, `mdp`, `nom`, `prenom`, `niveau`, `mail`) VALUES ('"+u.getLogin()+"','"+u.getMdp()+"','"+u.getNom()+"','"+u.getPrenom()+"','"+u.getNiveau()+"','"+u.getMail()+"')";
             try {
             //insert
            Statement st = cnx.createStatement();
            st.executeUpdate(req,0);
            System.out.println("utilisateur ajoute avec succes");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }  
    }

    @Override
    public List<User> afficherUser() {
         List<User> user =new ArrayList<>();
        //request
        String req="SELECT * FROM user";
       
       
        try {
            Statement st=cnx.createStatement();
             ResultSet  rs = st.executeQuery(req);
            while(rs.next()){
        user.add(new User(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public void Supprimer_Id(User u) {
          String req="DELETE FROM user WHERE id_user="+u.getId_user();
        try{
              Statement st=cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("utilisateur supprimee avec succes");
           
        }
        catch(SQLException ex){  
         ex.printStackTrace();
        }
     
    }

    @Override
    public void ModifierUser(User u,int id) {
     try {      
       String req=" UPDATE `user` SET  `login`='"+u.getLogin()+"',`mdp`='"+u.getMdp()+"',`nom`='"+u.getNom()+"', `prenom`='"+u.getPrenom()+"', `niveau` ='"+u.getNiveau()+"', `mail`='"+u.getMail()+"' WHERE `id_user`='"+id+"' " ;
       Statement st=cnx.createStatement();
       st.executeUpdate(req);
       System.out.println("Utilisateur modifie avec succes");
         }
     catch(SQLException ex){
         ex.printStackTrace();
     }
                                              }
    @Override
    public boolean VerifierCompte(String login,String mdp) {
            byte[] output;
            String nvmdp = null;
            
    try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            String input=mdp;
            md.update(input.getBytes());
            output = md.digest();
            nvmdp=( Base64.getEncoder().encodeToString(output)); 
        }catch(Exception ex) {System.out.println("Exception: "+ex); }
        
        String req= "SELECT `mail` FROM `user` WHERE `login` like '"+login+"' AND `mdp` like '"+nvmdp+"'";
        
   try {
             Statement st=cnx.createStatement();
             ResultSet  rs = st.executeQuery(req);
              if(rs.next()){
                           return true;
                           
                         } 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
               
            
          return false;  } 
    @Override
    public void MettrejourUser(String Login,String mdp){
            byte[] output;
            String nvmdp = null;
            try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            String input=mdp;
            md.update(input.getBytes());
            output = md.digest();
            nvmdp=( Base64.getEncoder().encodeToString(output)); 
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }   
            try {
                String req="UPDATE  `user` SET `mdp`='"+nvmdp+"' WHERE  `login` like '"+Login+"'";
                Statement st=cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Modifié avec succés !");}
            catch(SQLException ex){
                ex.printStackTrace();
     }
            
    }
    
    @Override
    public void Mails(String login){
                 String req= "SELECT `mail` FROM `user` WHERE `login` like '"+login+"'";
                 String c=getRandomNumberString();
                
                     try {
                              Statement st=cnx.createStatement();
                              ResultSet  rs = st.executeQuery(req);
              if(rs.next()){
                                  try {
                                      String req1="UPDATE  `user` SET `code`='"+c+"' WHERE  `login` like '"+login+"'";
                                      Statement st1=cnx.createStatement();
                                      st1.executeUpdate(req1);
                                      Mail.sendMail(rs.getString(1),c);
                                  } catch (Exception ex) {
                                      Logger.getLogger(UserImplementation.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                            }
            
        } catch (SQLException ex) {
                                ex.printStackTrace();
        }           

             }
    
    @Override
    public boolean ComparerCode(String c,String login){
        String req= "SELECT `code` FROM `user` WHERE `login` like '"+login+"'";
        
         try {
                              Statement st=cnx.createStatement();
                              ResultSet  rs = st.executeQuery(req);
              if(rs.next()) {
                                if (c.equals(rs.getString(1))){
                                         return true;}
                            }
            
        } catch (SQLException ex) {
                                ex.printStackTrace();
        }           
        return false;
    }
                 
    //ADMIN
    
        @Override
    public boolean VerifierCompteAdmin(String login,String mdp) {
            byte[] output;
            String nvmdp = null;
            
    try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            String input=mdp;
            md.update(input.getBytes());
            output = md.digest();
            nvmdp=( Base64.getEncoder().encodeToString(output)); 
        }catch(Exception ex) {System.out.println("Exception: "+ex); }
        
        String req= "SELECT `mail` FROM `admin` WHERE `login` like '"+login+"' AND `mdp` like '"+nvmdp+"'";
        
   try {
             Statement st=cnx.createStatement();
             ResultSet  rs = st.executeQuery(req);
              if(rs.next()){
                           return true;
                           
                         } 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        return false;  }
      
        
    @Override
        public void ajouterAdmin(User u) {
        byte[] output;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            String input=u.getMdp();
            md.update(input.getBytes());
            output = md.digest();
            u.setMdp( Base64.getEncoder().encodeToString(output));
            
        } catch (Exception ex) {
            System.out.println("Exception: "+ex);
        }
        String req = "INSERT INTO `admin`( `login`, `mdp`, `nom`, `prenom`, `niveau`, `mail`) VALUES ('"+u.getLogin()+"','"+u.getMdp()+"','"+u.getNom()+"','"+u.getPrenom()+"','"+u.getNiveau()+"','"+u.getMail()+"')";
             try {
             //insert
            Statement st = cnx.createStatement();
            st.executeUpdate(req,0);
            System.out.println("Admin ajoute avec succes");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }  
    }
    @Override
    public List<User> afficherAdmin() {
            List<User>user =new ArrayList<User>();
        //request
        String req="SELECT * FROM admin";
       
       
        try {
            Statement st=cnx.createStatement();
             ResultSet  rs = st.executeQuery(req);
            while(rs.next()){
                    user.add(new User(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
                            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    
    }
      @Override
    public void Supprimer_Id_Admin(User u) {
          String req="DELETE FROM admin WHERE id_admin="+u.getId_user();
        try{
              Statement st=cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("Admin supprimee avec succes");
           
        }
        catch(SQLException ex){  
         ex.printStackTrace();
        }
     
    }
    @Override
    public void ModifierAdmin(String Login,String Mdp,String Mail,int id) {
     try {      
       String req=" UPDATE `admin` SET  `login`='"+Login+"',`mdp`='"+Mdp+"', `mail`='"+Mail+"' WHERE `id_admin`='"+id+"' " ;
       Statement st=cnx.createStatement();
       st.executeUpdate(req);
       System.out.println("Admin modifie avec succes");
         }
     catch(SQLException ex){
         ex.printStackTrace();
     }
                                                                          }
    @Override
    public ObservableList<User> chercherUserid(String mot) {

      ObservableList<User> user=FXCollections.observableArrayList();
       
        //String req = "SELECT * FROM utilisateur WHERE nom='"+nom+"' OR idu="+id+" OR email='"+email+"'or best_game='"+bestgame+"' or id_e="+it+" ";
        String req = "SELECT * FROM user WHERE nom='"+mot+"' OR mail='"+mot+"'or login='"+mot+"'or niveau='"+mot+"'or prenom='"+mot+"'";
       
       
     
        try {
         Statement st = cnx.createStatement();
         ResultSet rs=st.executeQuery(req);
          while(rs.next()){
              
            user.add(new User(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
            }
        return user;
       
    }
    @Override
    public void ChangerEtat(String login){
             String etat="connecté";
                     try {
                String req="UPDATE  `user` SET `etat`='"+etat+"' WHERE  `login` like '"+login+"'";
                Statement st=cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Modifié avec succés !");}
            catch(SQLException ex){
                ex.printStackTrace();
     }
    
    }
       @Override
    public void ChangerEtatd(String login){
             String etat="deconnecté";
                     try {
                String req="UPDATE  `user` SET `etat`='"+etat+"' WHERE  `login` like '"+login+"'";
                Statement st=cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Modifié avec succés !");}
            catch(SQLException ex){
                                    ex.printStackTrace();
     }
    
    }
    @Override
    public User GetUserConnected() {
     String co="connecté";
     String req = "SELECT * FROM user WHERE etat='"+co+"'";
       
        try {
         Statement st = cnx.createStatement();
         ResultSet rs=st.executeQuery(req);
          while(rs.next()){
             
        User u1 =new User(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8));
        return u1;
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
            }
        return null;
        
        }
         @Override
    public void ChangerEtatetat(){
             String etat="connecté";
                     try {
                String req="UPDATE  `user` SET `etat`='"+"deconnecté"+"' WHERE  `etat` like '"+etat+"'";
                Statement st=cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Deconnecté avec succés !");}
            catch(SQLException ex){
                                    ex.printStackTrace();
     }
    
    }
}