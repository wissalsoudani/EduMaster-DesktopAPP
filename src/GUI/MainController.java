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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.UserImplementation;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class MainController implements Initializable {
    UserImplementation u=new UserImplementation();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserImplementation u=new UserImplementation();
        // TODO
    }    

    @FXML
    private void Logout(MouseEvent event) throws IOException {
        Stage nouveauStage;
                u.ChangerEtatetat();
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene);
    }

    @FXML
    private void Profile(MouseEvent event) throws IOException {
   Stage nouveauStage;
               
                 Parent root = FXMLLoader.load(getClass().getResource("Profil.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene);
    }

    @FXML
    private void dashHistoire(MouseEvent event) throws IOException {
         Stage nouveauStage;
               
                Parent root = FXMLLoader.load(getClass().getResource("frontHistoire.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene);
    }

    @FXML
    private void home(MouseEvent event) {
        
    }

    @FXML
    private void Quiz(MouseEvent event) throws IOException {
          Stage nouveauStage;
               
                Parent root = FXMLLoader.load(getClass().getResource("Front_Quiz.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene);
    }

    @FXML
    private void Cours(ActionEvent event) throws IOException {
       Stage nouveauStage;
               
                Parent root = FXMLLoader.load(getClass().getResource("CoursFront1.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene); 
    }


    
}
