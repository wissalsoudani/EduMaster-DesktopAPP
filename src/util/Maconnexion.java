/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; 
/**
 *
 * @author NEEEGROO
 */
public class Maconnexion {
 
    //BD Credentials
    final static String URL ="jdbc:mysql://127.0.0.1:3306/edumaster";
    final static String USERNAME = "root";
    final static String PWD = "";
    
    //att
    private Connection cnx;
    
    //singleton
    static Maconnexion instance = null;
    
    
    //constructor
     //singleton #2
    private Maconnexion() {
    
        try {
            cnx = DriverManager.getConnection(URL, USERNAME, PWD);
            System.out.println("connexion etablie avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //getters&setters
    public Connection getCnx() {
        return cnx;
    }

      
     //singleton #3

    public static Maconnexion getInstance() {
        if(instance == null){
            instance = new Maconnexion();
        }
        return instance;
    }
    
}
