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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Cours;
import service.Cours_implementation;
import util.Maconnexion;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class EduMasController implements Initializable {

    List<String> lstFile;
    static java.sql.Connection cnx = Maconnexion.getInstance().getCnx();
    @FXML
    private TextField tfNOM;
    @FXML
    private TextField tfCONTENU;
    @FXML
    private TextField tfPAGES;
    @FXML
    private TextField tfCHAPITRES;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private ListView lid;
    @FXML
    private Label myLabel;
    @FXML
    private Label label1;
    @FXML
    private DatePicker myDatePicker;
    @FXML
    private Button btntelecharger;

    Cours c = new Cours();
    Cours_implementation ci = new Cours_implementation();
    ObservableList<Cours> cour;
    @FXML
    private Button btnvisit;
    @FXML
    private Button btnvideo;
    @FXML
    private Button btnmodifier1;

    public void UpdateTable2() {
        cour = ci.afficher();
        lid.getItems().setAll(cour);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UpdateTable2();
        final FileChooser fileChooser = new FileChooser();
        final Desktop desktop = Desktop.getDesktop();

        btntelecharger.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tfCONTENU.clear();
                fileChooser.setTitle("Select Cours ");
                fileChooser.setInitialDirectory(new File(System.getProperty("user.home"),"\\Documents\\NetBeansProjects\\Edumasternew\\Prodeveurs\\src\\Images\\Media"));
                File file = fileChooser.showOpenDialog(null);
                
                if (file != null) {
                    List<File> files = Arrays.asList(file);
                    tfCONTENU.setText(file.getName());
                }
            }

        });                
    }

    @FXML
    private void AjouterCours(ActionEvent event) {

        Connection cnx = Maconnexion.getInstance().getCnx();

        /*try {
           /* String req = "INSERT INTO `cours`(`nom_cours`, `contenu_cours`, `nb_pages`, `nb_chapitres`) VALUES (?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, tfNOM.getText());
            pst.setString(2, tfCONTENU.getText());
            pst.setString(3, tfPAGES.getText());
            pst.setString(4, tfCHAPITRES.getText());
            pst.execute();
            UpdateTable2();
            JOptionPane.showMessageDialog(null, "Cours ajoute avec succes");

        } catch (Exception ex) {

            ex.printStackTrace();

        }*/
        if (Integer.parseInt(tfPAGES.getText()) > 20) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Verification pages ");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez resumer le cours!!!");
            alert.showAndWait();
        } else if ((tfCONTENU.getText().equals("")) || (tfCHAPITRES.getText().equals("")) || (tfNOM.getText().equals("")) || (tfPAGES.getText().equals(""))) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("champs");
            alert.setHeaderText(null);
            alert.setContentText("Il est obligatoire de remplir tous les champs !!!");
            alert.showAndWait();

        } else {
            try {
                String req = "INSERT INTO `cours`(`nom_cours`, `contenu_cours`, `nb_pages`, `nb_chapitres`) VALUES (?,?,?,?)";
                PreparedStatement pst = cnx.prepareStatement(req);
                pst.setString(1, tfNOM.getText());
                pst.setString(2, tfCONTENU.getText());
                pst.setString(3, tfPAGES.getText());
                pst.setString(4, tfCHAPITRES.getText());
                pst.execute();
                UpdateTable2();
                JOptionPane.showMessageDialog(null, "Cours ajoute avec succes");

            } catch (Exception ex) {

                ex.printStackTrace();
                ci.ajouterCours(c);
                lid.getItems().addAll(ci.afficher());
                Alert alert1 = new Alert(AlertType.INFORMATION);
                alert1.setTitle("Ajout avec succes?");
                alert1.setHeaderText(null);
                alert1.setContentText("Cours ajouté!");
                alert1.showAndWait();

            }
        }

    }

    @FXML
    private void ModifierCours(ActionEvent event) {
        try {

            Connection cnx = Maconnexion.getInstance().getCnx();
            Cours selecteditem = (Cours) lid.getSelectionModel().getSelectedItem();
            String req = "UPDATE cours SET nom_cours=?,contenu_cours=?,nb_pages=?,nb_chapitres=? WHERE id_cours=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, tfNOM.getText());
            pst.setString(2, tfCONTENU.getText());
            pst.setInt(3, Integer.parseInt(tfPAGES.getText()));
            pst.setInt(4, Integer.parseInt(tfCHAPITRES.getText()));
            pst.setInt(5, selecteditem.getId_cours());
            pst.executeUpdate();
            UpdateTable2();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ma Modification");
            alert.setHeaderText(null);
            alert.setContentText("cours bien modifié,vérifiez !");
            alert.showAndWait();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
        Cours selecteditem = (Cours) lid.getSelectionModel().getSelectedItem();
        tfNOM.setText(selecteditem.getNom_cours());
        tfCONTENU.setText(selecteditem.getContenu_cours());
        tfPAGES.setText(String.valueOf(selecteditem.getNb_pages()));
        tfCHAPITRES.setText(String.valueOf(selecteditem.getNb_chapitres()));
    }

    @FXML
    private void SupprimerCours(ActionEvent event) {
        Cours_implementation ci = new Cours_implementation();
        int selecteditem = lid.getSelectionModel().getSelectedIndex();
        ci.SupprimerParId((Cours) lid.getSelectionModel().getSelectedItem());
        lid.getItems().remove(selecteditem);

        UpdateTable2();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("SUPPRESSION");
        alert.setHeaderText(null);
        alert.setContentText("Le cours a été supprimé!");
        alert.showAndWait();

    }

    @FXML
    public void getDate(ActionEvent event) {
        LocalDate myDate = myDatePicker.getValue();
        String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        myLabel.setText(myFormattedDate);
        label1.setText("Votre dernier cours a été ajouté le: ");
        ;
    }

    @FXML
    private void VisiterCours(ActionEvent event) {
        try {
            Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("CoursFront1.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void AccederAjout(ActionEvent event) {
        try {
            Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("EduMasVideo.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void Quitter(ActionEvent event) throws IOException {
         Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("BackHome.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);
    }


}
