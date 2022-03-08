/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Abonnement;
import model.User;
import org.controlsfx.control.Notifications;
import service.AbonnementImplementation;
import service.UserImplementation;
import util.Maconnexion;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class AjouterController implements Initializable {

    UserImplementation u = new UserImplementation();
    AbonnementImplementation a=new AbonnementImplementation();
    static java.sql.Connection cnx = Maconnexion.getInstance().getCnx();
    @FXML
    private TextField lblLogin;
    @FXML
    private TextField lblMdp;
    @FXML
    private TextField lblNom;
    @FXML
    private TextField lblPrenom;
    @FXML
    private TextField lblNiveau;
    @FXML
    private TextField lblMail;
    @FXML
    private Button btnInscrire;

    @FXML
    private ChoiceBox<String> typecombo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String t="Eleve";
        String t1="Professeur";
        typecombo.getItems().addAll(t,t1);
    }

    @FXML
    private void btnInscrire(ActionEvent event) throws IOException {
        if ((lblLogin.getText().equals("")) || (lblMdp.getText().equals("")) || (lblNom.getText().equals("")) || (lblPrenom.getText().equals("")) || (lblNiveau.getText().equals("")) || (lblMail.getText().equals(""))) {

            Notifications notificationBuilder = Notifications.create()
                    .title("Attention !").text("Un champ vide").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Ok");
                    });
            notificationBuilder.darkStyle();
            notificationBuilder.show();
        } else {

            User us = new User(lblLogin.getText(), lblMdp.getText(), lblNom.getText(), lblPrenom.getText(), Integer.parseInt(lblNiveau.getText().toString()), lblMail.getText());
            String choix= typecombo.getValue();
            
            u.ajouterUser(us);
            a.ajouterAbonnement(lblLogin.getText(), choix); 
            Notifications notificationBuilder = Notifications.create()
                    .title("").text("Vous etes inscrit veuillez vous connecter ! ").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Ok");
                    });
            notificationBuilder.darkStyle();
            notificationBuilder.show();
            Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);
        }
    }

}
