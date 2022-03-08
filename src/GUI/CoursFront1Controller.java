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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.UserImplementation;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class CoursFront1Controller implements Initializable {

    @FXML
    private Button btnanglais;
    @FXML
    private Button btnfrancais;
    @FXML
    private Button btnscience;
    @FXML
    private Button btnmaths;
   
    @FXML
    private Button vidfrancais;
    @FXML
    private Button vidmaths;
    @FXML
    private Button vidsc;
    @FXML
    private Button vidanglais;
    @FXML
    private Button btnmaths1;
    @FXML
    private Button vidmaths1;
    UserImplementation u= new UserImplementation();
    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AccederAnglais(ActionEvent event) {
             try {
            Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("CoursUti2.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }

    @FXML
    private void AccederFrancais(ActionEvent event) {
             try {
            Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("CoursUti2.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }

    @FXML
    private void AccederScience(ActionEvent event) {
             try {
            Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("CoursUti2.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }

    @FXML
    private void AccederMaths(ActionEvent event) {
             try {
            Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("CoursUti2.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }



    @FXML
    private void VideoFrancais(ActionEvent event) {
            try {
            Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("EduMasVideoUti.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }

    @FXML
    private void VidMaths(ActionEvent event) {
            try {
            Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("EduMasVideoUti.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }

    @FXML
    private void VideoScience(ActionEvent event) {
            try {
            Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("EduMasVideoUti.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }

    @FXML
    private void Video(ActionEvent event) {
           try {
            Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("EduMasVideoUti.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    @FXML
    private void VideoAnglais(MouseEvent event) {   try {
            Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("EduMasVideoUti.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void AccederMaths1(ActionEvent event) {
                     try {
            Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("CoursUti2.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void VidSc(ActionEvent event) {
         try{ Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("EduMasVideoUti.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);

        } catch (IOException ex) 
        {
            ex.printStackTrace();
        }
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
    private void home(MouseEvent event) throws IOException {
       Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene);
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
               
                Parent root = FXMLLoader.load(getClass().getResource("CoursUti2.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene); 
    }

}
    

