/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Histoire;
import service.HistoireI;
import model.Test_histoire;
import service.Test_HistoireI;
import util.Maconnexion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import sun.security.util.Length;

/**
 * FXML Controller class
 *
 * @author user
 */
public class GestionHistoire_AdminController implements Initializable {

    static java.sql.Connection cnx = Maconnexion.getInstance().getCnx();

    @FXML
    private TextField L_age;
    @FXML
    private TextField L_langue;
    @FXML
    private TextField L_nom;
    @FXML
    private TextField L_contenu;
    @FXML
    private Button importContenu;
    @FXML
    private TextField L_couverture;
    @FXML
    private TextField L_catégorie;
    @FXML
    private ListView<Histoire> L_afficher;
    @FXML
    private Button B_supp;
    @FXML
    private Button importcouverture;
    @FXML
    private ComboBox<Histoire> histoire_a_choisir;
    @FXML
    private Button ajoutertest;
    @FXML
    private TextField L_Q1;
    @FXML
    private TextField L_C1Q1;
    @FXML
    private TextField L_C2Q1;
    @FXML
    private TextField L_C3Q1;
    @FXML
    private TextField L_C1Q2;
    @FXML
    private TextField L_C3Q2;
    @FXML
    private TextField L_C2Q2;
    @FXML
    private TextField L_Q2;
    @FXML
    private TextField L_Q3;
    @FXML
    private TextField L_C1Q3;
    @FXML
    private TextField L_C2Q3;
    @FXML
    private TextField L_C3Q3;
    @FXML
    private ListView<Test_histoire> L_affichertest;
    @FXML
    private Button modifierTest;
    @FXML
    private Button afficherTest;
    @FXML
    private Button supprimerTest;
    @FXML
    private TextField C1;
    @FXML
    private TextField C2;
    @FXML
    private TextField C3;
    @FXML
    private Button backretour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        HistoireI hs = new HistoireI();
        Histoire h = new Histoire();
        Test_HistoireI tH = new Test_HistoireI();

        histoire_a_choisir.getItems().addAll(hs.afficherhistoire());
        // choisir le file du contenu et couverture histoire
        final FileChooser fileChooser = new FileChooser();
        final Desktop desktop = Desktop.getDesktop();

        importContenu.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                L_contenu.clear();
                fileChooser.setTitle("Select PDF");

                fileChooser.setInitialDirectory(new File(System.getProperty("user.home"), "\\Documents\\NetBeansProjects\\Edumasternew\\Prodeveurs\\src\\GUI\\assests\\"));
                File file = fileChooser.showOpenDialog(null);

                if (file != null) {
                    List<File> files = Arrays.asList(file);
                    L_contenu.setText(file.getName());
                }
            }
        }
        );

        importcouverture.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                L_couverture.clear();
                fileChooser.setTitle("Select image");

                fileChooser.setInitialDirectory(new File(System.getProperty("user.home"), "\\Documents\\NetBeansProjects\\Edumasternew\\Prodeveurs\\src\\GUI\\assests\\"));
                File file = fileChooser.showOpenDialog(null);

                if (file != null) {
                    List<File> files = Arrays.asList(file);
                    L_couverture.setText(file.getName());
                }
            }
        }
        );
        /// 

    }

    @FXML
    private void afficherHistoire(ActionEvent event) {
        HistoireI hs = new HistoireI();
        L_afficher.getItems().addAll(hs.afficherhistoire());
    }

    @FXML
    private void ajouterHistoire(ActionEvent event) {
        HistoireI hs = new HistoireI();
        Histoire h = new Histoire();

        h.setAge(Integer.parseInt(L_age.getText()));
        h.setLangue(L_langue.getText());
        h.setNom_histoire(L_nom.getText());
        h.setContenu_histoire(L_contenu.getText());
        h.setCouverture_histoire(L_couverture.getText());
        h.setCatégorie(L_catégorie.getText());

        //controle saisie 
        if ((Integer.parseInt(L_age.getText()) > 11) || (L_langue.getText().equals("")) || (L_nom.getText().equals(""))||(L_contenu.getText().equals(""))||(L_couverture.getText().equals(""))||(L_catégorie.getText().equals("")))
               {                 
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("verifier les champ vides!");
            alert.showAndWait();

        } else {
            hs.AjouterHistoire(h);
            L_afficher.getItems().addAll(hs.afficherhistoire());
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("histoire ajoutée!");
            alert.showAndWait();

        }
    }

    @FXML
    private void index(MouseEvent event) {
        Histoire selectedItem = L_afficher.getSelectionModel().getSelectedItem();
        L_age.setText(String.valueOf(selectedItem.getAge()));
        L_langue.setText(selectedItem.getLangue());
        L_nom.setText(selectedItem.getNom_histoire());
        L_contenu.setText(selectedItem.getContenu_histoire());
        L_couverture.setText(selectedItem.getCouverture_histoire());
        L_catégorie.setText(selectedItem.getCatégorie());
    }

    @FXML
    private void supprimerHistoire(ActionEvent event) {

        HistoireI hs = new HistoireI();
        hs.SupprimerHistoire(L_afficher.getSelectionModel().getSelectedItem());
        int selecteditem = L_afficher.getSelectionModel().getSelectedIndex();
        L_afficher.getItems().remove(selecteditem);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("histoire est supprimée!");
        alert.showAndWait();
        L_age.setText("");
        L_langue.setText("");
        L_nom.setText("");
        L_contenu.setText("");
        L_couverture.setText("");
        L_catégorie.setText("");
    }

    @FXML
    private void modifierHistoire(ActionEvent event) {

        HistoireI hs = new HistoireI();
        Histoire h = new Histoire();
        try {

            String sql = " UPDATE histoire SET age=?,langue=?,nom_histoire=?,contenu_histoire=?,couverture_histoire=?,catégorie=? WHERE id_histoire=?";
            PreparedStatement pst = cnx.prepareStatement(sql);
            Histoire selectedItem = L_afficher.getSelectionModel().getSelectedItem();

            pst.setInt(1, Integer.parseInt(L_age.getText()));
            pst.setString(2, L_langue.getText());
            pst.setString(3, L_nom.getText());
            pst.setString(4, L_contenu.getText());
            pst.setString(5, L_couverture.getText());
            pst.setString(6, L_catégorie.getText());
            pst.setInt(7, selectedItem.getId_histoire());

            int i = pst.executeUpdate();
            if (i == 1) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("histoire modifié!");
                alert.showAndWait();
                L_age.setText("");
                L_langue.setText("");
                L_nom.setText("");
                L_contenu.setText("");
                L_couverture.setText("");
                L_catégorie.setText("");

            }
        } catch (SQLException ex) {
            System.out.println("Problem");
            System.out.println(ex.getMessage());
        }

//        L_afficher 
        L_afficher.getItems().clear();
        L_afficher.getItems().addAll(hs.afficherhistoire());

    }

    private void quitterfenetre(ActionEvent event) {
        javafx.application.Platform.exit();
    }

    //*******************************************************************
    @FXML
    private void ajouterTestHistoire(ActionEvent event) {
        Test_HistoireI ts = new Test_HistoireI();
        Test_histoire t = new Test_histoire();
        t.setId_histoire(histoire_a_choisir.getValue().getId_histoire());

        t.setQuestion1(L_Q1.getText());
        t.setR11(L_C1Q1.getText());
        t.setR12(L_C2Q1.getText());
        t.setR13(L_C3Q1.getText());
        t.setCorrectionQ1(C1.getText());
        t.setQuestion2(L_Q2.getText());
        t.setR21(L_C1Q2.getText());
        t.setR22(L_C2Q2.getText());
        t.setR23(L_C3Q2.getText());
        t.setCorrectionQ2(C2.getText());
        t.setQuestion3(L_Q3.getText());
        t.setR31(L_C1Q3.getText());
        t.setR32(L_C2Q3.getText());
        t.setR33(L_C3Q3.getText());
        t.setCorrectionQ3(C3.getText());
        System.out.println(t);
        ts.AjouterTest_histoire(t);
        L_affichertest.getItems().addAll(ts.afficherTest_histoire());
        L_Q1.setText("");
        L_C1Q1.setText("");
        L_C2Q1.setText("");
        L_C3Q1.setText("");
        C1.setText("");
        L_Q2.setText("");
        L_C1Q2.setText("");
        L_C2Q2.setText("");
        L_C3Q2.setText("");
        C2.setText("");
        L_Q3.setText("");
        L_C1Q3.setText("");
        L_C2Q3.setText("");
        L_C3Q3.setText("");
        C3.setText("");

    }

    @FXML
    private void afficherTestHistoire(ActionEvent event) {
        Test_HistoireI ts = new Test_HistoireI();
        L_affichertest.getItems().addAll(ts.afficherTest_histoire());
    }

    @FXML
    private void modifierTestHistoire(ActionEvent event) {

        Test_HistoireI ts = new Test_HistoireI();
        Test_histoire t = new Test_histoire();
        try {

            String sql = " UPDATE test_histoire SET question1=?,R11=?,R12=?,R13=?,correctionQ1=?, question2=?, R21=?, R22=?, R23=?, correctionQ2=?, question3=?, R31=?, R32=?, R33=?, correctionQ3=? WHERE id_histoire=?";
            PreparedStatement pst = cnx.prepareStatement(sql);
            Test_histoire selectedItem = L_affichertest.getSelectionModel().getSelectedItem();

            pst.setString(1, L_Q1.getText());
            pst.setString(2, L_C1Q1.getText());
            pst.setString(3, L_C2Q1.getText());
            pst.setString(4, L_C3Q1.getText());
            pst.setString(5, C1.getText());
            pst.setString(6, L_Q2.getText());
            pst.setString(7, L_C1Q2.getText());
            pst.setString(8, L_C2Q2.getText());
            pst.setString(9, L_C3Q2.getText());
            pst.setString(10, C2.getText());
            pst.setString(11, L_Q3.getText());
            pst.setString(12, L_C1Q3.getText());
            pst.setString(13, L_C2Q3.getText());
            pst.setString(14, L_C3Q3.getText());
            pst.setString(15, C3.getText());
            pst.setInt(16, selectedItem.getId_histoire());

            int i = pst.executeUpdate();
            if (i == 1) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("test histoire modifié!");
                alert.showAndWait();

                L_affichertest.getItems().clear();
                L_affichertest.getItems().addAll(ts.afficherTest_histoire());
                L_Q1.setText("");
                L_C1Q1.setText("");
                L_C2Q1.setText("");
                L_C3Q1.setText("");
                C1.setText("");
                L_Q2.setText("");
                L_C1Q2.setText("");
                L_C2Q2.setText("");
                L_C3Q2.setText("");
                C2.setText("");
                L_Q3.setText("");
                L_C1Q3.setText("");
                L_C2Q3.setText("");
                L_C3Q3.setText("");
                C3.setText("");

            }
        } catch (SQLException ex) {
            System.out.println("Problem");
            System.out.println(ex.getMessage());
        }

//        L_afficher 
    }

    @FXML
    private void supprimerTestHistoire(ActionEvent event) {

        Test_HistoireI ts = new Test_HistoireI();
        ts.SupprimerTest_histoire(L_affichertest.getSelectionModel().getSelectedItem());
        int selecteditem = L_affichertest.getSelectionModel().getSelectedIndex();
        L_affichertest.getItems().remove(selecteditem);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("test histoire est supprimée!");
        alert.showAndWait();
        L_Q1.setText("");
        L_C1Q1.setText("");
        L_C2Q1.setText("");
        L_C3Q1.setText("");
        C1.setText("");
        L_Q2.setText("");
        L_C1Q2.setText("");
        L_C2Q2.setText("");
        L_C3Q2.setText("");
        C2.setText("");
        L_Q3.setText("");
        L_C1Q3.setText("");
        L_C2Q3.setText("");
        L_C3Q3.setText("");
        C3.setText("");
    }

    @FXML
    private void indexTest(MouseEvent event) {
        Test_histoire t = L_affichertest.getSelectionModel().getSelectedItem();
        HistoireI hs = new HistoireI();
        histoire_a_choisir.setValue(hs.afficherhistoire().stream().filter(h -> h.getId_histoire() == t.getId_histoire()).findAny().orElse(null));
        L_Q1.setText(t.getQuestion1());
        L_C1Q1.setText(t.getR11());
        L_C2Q1.setText(t.getR12());
        L_C3Q1.setText(t.getR13());
        C1.setText(t.getCorrectionQ1());
        L_Q2.setText(t.getQuestion2());
        L_C1Q2.setText(t.getR21());
        L_C2Q2.setText(t.getR22());
        L_C3Q2.setText(t.getR23());
        C2.setText(t.getCorrectionQ2());
        L_Q3.setText(t.getCorrectionQ3());
        L_C1Q3.setText(t.getR31());
        L_C2Q3.setText(t.getR32());
        L_C3Q3.setText(t.getR33());
        C3.setText(t.getCorrectionQ3());

    }

    @FXML
    private void AllerHome(MouseEvent event) throws IOException {
         Stage nouveauStage;
               
                Parent root = FXMLLoader.load(getClass().getResource("BackHome.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene);
    }

    
}
