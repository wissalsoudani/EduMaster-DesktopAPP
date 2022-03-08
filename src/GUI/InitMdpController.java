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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import service.UserImplementation;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class InitMdpController implements Initializable {

    @FXML
    private TextField lblLoginUser;
    @FXML
    private PasswordField lblMdpUser;
    @FXML
    private Button btnModifier;

    /**
     * Initializes the controller class.
     */
    UserImplementation u = new UserImplementation();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  
    
    @FXML
    private void InitMdp(ActionEvent event) throws IOException {
       u.MettrejourUser(lblLoginUser.getText(), lblMdpUser.getText());
        Notifications notificationBuilder = Notifications.create()
                    .title("").text("Mot de passe modifié veuillez vous reconnecter ! ").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
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

    @FXML
    private void onClickLogin(MouseEvent event) {
    }

    

    
}
