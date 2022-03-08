/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.User;
import org.controlsfx.control.Notifications;
import service.UserImplementation;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class AdminController implements Initializable {
    UserImplementation u=new UserImplementation();
    @FXML
    private ListView<User> LstUser=new ListView();
    @FXML
    private TextField mdp;
    @FXML
    private TextField mail;
    @FXML
    private TextField lgn;
    @FXML
    private ListView<User> lstAdmin=new ListView();
    @FXML
    private TextField lblRecherche;
   
   
    

      
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       LstUser.getItems().setAll(u.afficherUser());
       lstAdmin.getItems().setAll(u.afficherAdmin());
       
       
     
    }    

    @FXML
    private void btnSupprimer(ActionEvent event) {
       User selecteditem = (User) LstUser.getSelectionModel().getSelectedItem();
       u.Supprimer_Id(selecteditem);
       LstUser.getItems().setAll(u.afficherUser());
    }



    @FXML
    private void btnSupprimerAdmin(ActionEvent event) {
        User selecteditem = (User) lstAdmin.getSelectionModel().getSelectedItem();
        u.Supprimer_Id_Admin(selecteditem);
        lstAdmin.getItems().setAll(u.afficherAdmin());
    }

    @FXML
    private void ajouter(ActionEvent event) {
          User us=new User(lgn.getText(),mdp.getText(),mail.getText());
        
                 if (lgn.getText().equals("")) {
                       
             Notifications notificationBuilder = Notifications.create()
                    .title("Attention !").text("Le champ mot de passe est vide").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Ok");
                    });
             notificationBuilder.darkStyle();
            notificationBuilder.show();
         
         
    }
                        else  if (mdp.getText().equals("")) {
                       
             Notifications notificationBuilder = Notifications.create()
                    .title("Attention !").text("Le champ mot de passe est vide").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Ok");
                    });
             notificationBuilder.darkStyle();
            notificationBuilder.show();
         
         
    }
               else  if (mail.getText().equals("")) {
                       
             Notifications notificationBuilder = Notifications.create()
                    .title("Attention !").text("Le champ mot de passe est vide").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Ok");
                    });
             notificationBuilder.darkStyle();
            notificationBuilder.show();
         
         
    }
               else  {
                     u.ajouterAdmin(us);
                     Notifications notificationBuilder = Notifications.create()
                    .title("").text("Admin ajouté ").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Ok");
                    });
                lstAdmin.getItems().setAll(u.afficherAdmin()); }
                   
    }

    @FXML
    private void ModifierAdmin(ActionEvent event) {
            User selecteditem = (User) lstAdmin.getSelectionModel().getSelectedItem();
            u.ModifierAdmin(lgn.getText(),mdp.getText(),mail.getText(),selecteditem.getId_user());
            lstAdmin.getItems().setAll(u.afficherAdmin());
    }

    @FXML
    private void SelectionnerAdmin(ActionEvent event) {
       User selecteditem = (User) lstAdmin.getSelectionModel().getSelectedItem();
       lgn.setText(selecteditem.getLogin());
       mdp.setText(selecteditem.getMdp());
       mail.setText(selecteditem.getMail());
      
    }

    @FXML
    private void Rechercher(ActionEvent event) {
       LstUser.getItems().setAll(u.chercherUserid(lblRecherche.getText()));
       
    }

   

    @FXML
    private void ReloadPage(MouseEvent event) {
         LstUser.getItems().setAll(u.afficherUser());
         lstAdmin.getItems().setAll(u.afficherAdmin()); 
    }


    private void Allercours(MouseEvent event) throws IOException {
        Stage nouveauStage;
               
                Parent root = FXMLLoader.load(getClass().getResource("EduMas.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene);
    }

    private void Allerexos(MouseEvent event) throws IOException {
        Stage nouveauStage;
               
                Parent root = FXMLLoader.load(getClass().getResource("Home_Quiz.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene);
    }

    private void AllerLogout(MouseEvent event) throws IOException {
        Stage nouveauStage;
               
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene);
    }



    private void allerHistoire(MouseEvent event) throws IOException {
        Stage nouveauStage;
               
                Parent root = FXMLLoader.load(getClass().getResource("GestionHistoire_Admin.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene);
    }

    private void AllerHome(MouseEvent event) throws IOException {
        Stage nouveauStage;
               
                Parent root = FXMLLoader.load(getClass().getResource("BackHome.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene);
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
