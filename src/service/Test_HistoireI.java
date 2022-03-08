/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.Test_HistoireService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.scene.control.Alert;
import model.Histoire;
import model.Test_histoire;
import static service.HistoireI.cnx;
import util.Maconnexion;

/**
 *
 * @author user
 */
public class Test_HistoireI implements Test_HistoireService {

    //var 
    static java.sql.Connection cnx = Maconnexion.getInstance().getCnx();
    public int id_test;

    @Override
    public void AjouterTest_histoire(Test_histoire t) {
//request                                           
        String req = "INSERT INTO `test_histoire`( `id_histoire`, `question1`, `R11`, `R12`, `R13`, `correctionQ1`, `question2`, `R21`, `R22`, `R23`, `correctionQ2`, `question3`, `R31`, `R32`, `R33`, `correctionQ3`) VALUES ('" + t.getId_histoire() + "', '" + t.getQuestion1() + "', '" + t.getR11() + "','" + t.getR12() + "','" + t.getR13() + "','" + t.getCorrectionQ1() + "','" + t.getQuestion2() + "','" + t.getR21() + "','" + t.getR22() + "','" + t.getR23() + "','" + t.getCorrectionQ2() + "','" + t.getQuestion3() + "','" + t.getR31() + "','" + t.getR32() + "','" + t.getR33() + "','" + t.getCorrectionQ3() + "')";
        try {
            //insert
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("test ajoutee avec succes");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Test_histoire> afficherTest_histoire() {
        //var
        List<Test_histoire> tests = new ArrayList<>();
        //request
        String req = "SELECT * FROM test_histoire";

        try {
            //exec
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                tests.add(new Test_histoire(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16),rs.getString(17)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tests;
    }

    @Override
    public void SupprimerTest_histoire(Test_histoire T) {
        try {
            String req = "DELETE FROM test_histoire where id_test='"+T.getId_test()+"'";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("test est supprime");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
   

    @Override
    public boolean ModifierTest_histoire(Test_histoire T) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nouveau type : ");
        String correction = sc.nextLine();
        String newcorrection = correction.valueOf(correction);
        try {
            String req = " UPDATE `test_histoire` SET `correction` = '" + newcorrection + "'  WHERE `id_test`= '" + T.getId_test() + "' ";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

}
