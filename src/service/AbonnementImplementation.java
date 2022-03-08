/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import interfaces.abonnement_i;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Abonnement;
import model.User;
import static service.UserImplementation.cnx;
import util.Maconnexion;

/**
 *
 * @author NEEEGROO
 */
public class AbonnementImplementation implements abonnement_i {
    static java.sql.Connection cnx = Maconnexion.getInstance().getCnx();

    @Override
    public void ajouterAbonnement(String login,String Type) {
   String req = "INSERT INTO `abonnement` (`login_user` , `Type`) VALUES ('"+login+"','"+Type+"')";
             try {
             //insert
            Statement st = cnx.createStatement();
            st.executeUpdate(req,0);
            System.out.println("Abonnement ajoute avec succes");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }     }

    @Override
    public List<Abonnement> afficherAbonnement() {
   List<Abonnement> abonnement =new ArrayList<>();
        //request
        String req="SELECT * FROM abonnement"; //cours c'est le nom de la table dans la bd
       
       
        try {
            Statement st=cnx.createStatement();
             ResultSet  rs = st.executeQuery(req);
             while(rs.next()){
        abonnement.add(new Abonnement(rs.getString(2),rs.getString(3)));
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return abonnement;    }

    @Override
    public void SupprimerAbonnement(Abonnement a) {
      String req="DELETE FROM abonnement WHERE login_user="+a.login_user();
        try{
              Statement st=cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("utilisateur supprimee avec succes");
           
        }
        catch(SQLException ex){  
         ex.printStackTrace();
        }    }

    @Override
    public void ModifierAbonnement(Abonnement a,int id ) {
        try {      
      String req=" UPDATE `abonnement` SET `type`='"+a.getType()+"' WHERE `id_abonnement`='"+id+"' " ;
       Statement st=cnx.createStatement();
       st.executeUpdate(req);
        System.out.println("Utilisateur modifie avec succes");
   
     }
     catch(SQLException ex){
         ex.printStackTrace();
     }    }
    @Override
    public String SelectRole(String login) {
     String req="SELECT `Type` FROM abonnement WHERE `login_user` like '"+login+"'"; 
       
       
        try {
            Statement st=cnx.createStatement();
             ResultSet  rs = st.executeQuery(req);
             while(rs.next()){
        return rs.getString(1);
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    return "vide";
    }
    
}
