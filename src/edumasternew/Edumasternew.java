/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edumasternew;

import interfaces.user_i;
import model.Mail;
import model.User;
import service.UserImplementation;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author NEEEGROO
 */
public class Edumasternew {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserImplementation u=new UserImplementation() ;
       // User u4=new User(8,"warrior","warrior98","chouchane","abdou",3,"dhakerbadri.bbt@gmail.com");
        User u5=new User("Admin","Admin98","mch.kifkif@gmail.com");
       u.ajouterAdmin(u5);
       
       // u.ModifierUser(u4, 2);
       //System.out.println(u.afficherUser());
      // u.VerifierCompte("killer","killer98");
    //  u.VerifierCompte("warrior", "warrior99");
      
    
     
    
    
    
    
  
 }
}
    
    

