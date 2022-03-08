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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import service.UserImplementation;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class MailingController implements Initializable {
    UserImplementation u = new UserImplementation();
    @FXML
    private TextField lblLoginMail;
    @FXML
    private Button mail;
    @FXML
    private TextField lblCodeMail;
    @FXML
    private Button verifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    String C;
    @FXML
    private void envoyezMail(ActionEvent event) {
     u.Mails(lblLoginMail.getText());
     Notifications notificationBuilder = Notifications.create()
                    .title("").text("Mail envoyé ! ").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Ok");
                    });
            notificationBuilder.darkStyle();
            notificationBuilder.show();
     
    }

    @FXML
    private void comparerCode(ActionEvent event) throws IOException {
     if (u.ComparerCode(lblCodeMail.getText(),lblLoginMail.getText())) {
         
              Notifications notificationBuilder = Notifications.create()
                    .title("").text("Code correct vous pouvez vous connecter ! ").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Ok");
                    });
              notificationBuilder.darkStyle();
              notificationBuilder.show();
            
             Stage nouveauStage;
                Parent root = FXMLLoader.load(getClass().getResource("InitMdp.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene);
                
             
     }
     else {
      Notifications notificationBuilder = Notifications.create()
                    .title("").text("Erreur code! ").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Ok");
                    });
                   notificationBuilder.darkStyle();
                   notificationBuilder.show();
            lblCodeMail.setText("");
           
     }
    }
    
}
