/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.User;
import org.controlsfx.control.Notifications;
import service.UserImplementation;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField lblLoginUser;
    @FXML
    PasswordField lblMdpUser;
    @FXML
    Button btnLoginUser;
    UserImplementation u = new UserImplementation();
    @FXML
    private Button btninit;
    private Object fxml;
    @FXML
    private Button btnCreate;
    @FXML
    private TextField lblLoginAdmin;
    @FXML
    private PasswordField lblPassAdmin;
    static Button btnModifier;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onClickLogin(MouseEvent btnLoginUser) throws IOException {
            if (lblLoginUser.getText().equals("")) {
                       
             Notifications notificationBuilder = Notifications.create()
                    .title("Attention !").text("Le champ login est vide").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Ok");
                    });

            notificationBuilder.darkStyle();
            notificationBuilder.show();
        }
            if (lblMdpUser.getText().equals("")) {
                       
             Notifications notificationBuilder = Notifications.create()
                    .title("Attention !").text("Le champ mot de passe est vide").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Ok");
                    });

            notificationBuilder.darkStyle();
            notificationBuilder.show();
        }
        if (u.VerifierCompte(lblLoginUser.getText(), lblMdpUser.getText())) {
//            Alert alert = new Alert(AlertType.INFORMATION);
//            alert.setTitle("Edumaster");
//            alert.setHeaderText(null);
//            alert.setContentText("Bienvenue!");
//            alert.showAndWait(); 
            
              Notifications notificationBuilder = Notifications.create()
                    .title("").text("Bienvenue ! ").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Ok");
                    });
            notificationBuilder.darkStyle();
            notificationBuilder.show();
            //etat :
           u.ChangerEtat(lblLoginUser.getText());
               Stage nouveauStage;
                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                nouveauStage = (Stage) ((Node) btnLoginUser.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene);
            
        } else {
             Notifications notificationBuilder = Notifications.create()
                    .title("").text("Erreur mot de passe ou login  ! ").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Ok");
                    });
              notificationBuilder.darkStyle();
              notificationBuilder.show();
              btninit.setText("Réeinitialisez ?"); 
            
        }
          
    }


    @FXML
    private void NavigateToAjouter(ActionEvent event) throws IOException {
        Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("Ajouter.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);
    }

    @FXML
    private void btninit(ActionEvent event) throws IOException {
        Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("Mailing.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);  
    }

    @FXML
    private void LoginAdmin(ActionEvent event) throws IOException {
         if (u.VerifierCompteAdmin(lblLoginAdmin.getText(), lblPassAdmin.getText())) {
                    Notifications notificationBuilder = Notifications.create()
                    .title("").text("Bienvenue ! ").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Ok");
                    });
                      notificationBuilder.darkStyle();
                      notificationBuilder.show();
            
              Stage nouveauStage;
              Parent root = FXMLLoader.load(getClass().getResource("BackHome.fxml"));
              nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              Scene scene = new Scene(root);
              nouveauStage.setScene(scene);
            
        } else {
                     Notifications notificationBuilder = Notifications.create()
                    .title("").text("Erreur mot de passe ou login  ! ").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Ok");
                    });
                       notificationBuilder.darkStyle();
                       notificationBuilder.show(); 
            lblLoginUser.setText("");
            lblMdpUser.setText("");
           
        }
             if (lblLoginAdmin.getText().equals("")) {
                       
             Notifications notificationBuilder = Notifications.create()
                    .title("Attention !").text("Le champ login est vide").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Ok");
                    });

            notificationBuilder.darkStyle();
            notificationBuilder.show();
        }
            if (lblPassAdmin.getText().equals("")) {
                       
             Notifications notificationBuilder = Notifications.create()
                    .title("Attention !").text("Le champ mot de passe est vide").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Ok");
                    });
             notificationBuilder.darkStyle();
            notificationBuilder.show();
         
         
    } }


}
