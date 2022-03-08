/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.HistoireService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Histoire;
import util.Maconnexion;

/**
 *
 * @author user
 */
public class HistoireI implements HistoireService {

    //var 
    static java.sql.Connection cnx = Maconnexion.getInstance().getCnx();

    @Override
    public void AjouterHistoire(Histoire h) {
        //request                                           
        String req = "INSERT INTO `histoire`( `age`, `langue`, `nom_histoire`, `contenu_histoire`, `couverture_histoire`,`catégorie`)  VALUES ('" + h.getAge() + "','" + h.getLangue() + "',  '" + h.getNom_histoire() + "' , '" + h.getContenu_histoire() + "', '" + h.getCouverture_histoire() + "', '" + h.getCatégorie() + "')";

        try {
            //insert
            Statement st = cnx.createStatement();
            st.executeUpdate(req);

            System.out.println("histoire ajoutee avec succes");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Histoire> afficherhistoire() {
        //var
        List<Histoire> histoires = new ArrayList<>();
        //request
        String req = "SELECT * FROM histoire";

        try {
            //exec
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                histoires.add(new Histoire(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return histoires;
    }

//    @Override
//    public int histoireID() {
//        List<Histoire> histoires = new ArrayList<>();
//
//        //request
//        String req = "SELECT id_histoire FROM histoire";
//
//        try {
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(req);
//            while (rs.next()) {
//
//                histoires.add(new Histoire(rs.getInt(1)));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return Histoire.id_histoire;
//    }

    public void SupprimerHistoire(Histoire H) {
        try {
            String req = "DELETE FROM histoire where id_histoire='" + H.getId_histoire()+ "'";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("histoire est supprime");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean ModifierHistoire(Histoire H) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nouvelle langue : ");
        String langue = sc.nextLine();
        String newlangue = langue.valueOf(langue);
        try {
            String req = " UPDATE `histoire` SET `langue` = '" + newlangue + "'  WHERE `id_histoire`= '" + H.getId_histoire()+ "' ";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Histoire> rechercherHistoire(String nomCherche) {

        List<Histoire> histoires = new ArrayList<>();
        String req = "SELECT * FROM `histoire` WHERE `nom_histoire` LIKE '" + nomCherche + "' ";
        try {

            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                histoires.add(new Histoire(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return histoires;
    }
    
    public boolean CheckHistoireByName(String name) {
                  
        boolean p = false;
        try {

            Statement pst = cnx.createStatement();

            ResultSet rs = pst.executeQuery("SELECT * from histoire WHERE nom_histoire='" + name + "'");

            while (rs.next()) {
                 p=true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return p;

    }

}
