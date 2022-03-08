/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import service.AbonnementImplementation;
import service.UserImplementation;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class ProfilController implements Initializable {
    
    @FXML
    private TextField lblnom;
    @FXML
    private TextField lblogin;
    @FXML
    private TextField lblmail;
    @FXML
    private TextField lblprenom;
    UserImplementation u = new UserImplementation();
    AbonnementImplementation a= new AbonnementImplementation();
    @FXML
    private TextField lblRole;
    /**
     * Initializes the controller class.
     */void setUtilisateur(User u) {
        lblnom.setText(u.getNom());
        lblprenom.setText(u.getPrenom());
        lblogin.setText(u.getLogin());
        lblmail.setText(u.getMail());
        lblnom.setDisable(true);
        lblprenom.setDisable(true);
        lblogin.setDisable(true);
        lblmail.setDisable(true);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setUtilisateur(u.GetUserConnected());
        lblRole.setText(a.SelectRole(lblogin.getText()));
        lblRole.setDisable(true);
    }    

    @FXML
    private void Quit(ActionEvent event) throws IOException {
        
         Stage nouveauStage;
                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene);
    }

    @FXML
    private void Editer(ActionEvent event) {
         lblnom.setDisable(false);
         lblprenom.setDisable(false);
         lblmail.setDisable(false);
         
    }

    @FXML
    private void Modifier(ActionEvent event) {
        User u1=u.GetUserConnected();
        u1.setNom(lblnom.getText());
        u1.setPrenom(lblprenom.getText());
        u1.setMail(lblmail.getText());
        u.ModifierUser(u1,u1.getId_user());
        lblnom.setDisable(true);
        lblprenom.setDisable(true);
        lblmail.setDisable(true);
        
    }
      
    
}
