/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import model.Test_histoire;
import org.controlsfx.control.Notifications;
import service.Test_HistoireI;
import util.Maconnexion;

/**
 * FXML Controller class
 *
 * @author wassimromdhane
 */
public class TestHistoireController implements Initializable {

    static java.sql.Connection cnx = Maconnexion.getInstance().getCnx();

    @FXML
    private Text q1;
    @FXML
    private Text r11;
    @FXML
    private Text r12;
    @FXML
    private Text r13;
    @FXML
    private ChoiceBox<String> choix1;
    @FXML
    private Text q2;
    @FXML
    private Text r21;
    @FXML
    private Text r22;
    @FXML
    private Text r23;
    @FXML
    private ChoiceBox<String> choix2;
    @FXML
    private Text q3;
    @FXML
    private Text r31;
    @FXML
    private Text r32;
    @FXML
    private Text r33;
    @FXML
    private ChoiceBox<String> choix3;
    @FXML
    private Label c1;
    @FXML
    private Label c2;
    @FXML
    private Label c3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Test_HistoireI th = new Test_HistoireI();

    }

    @FXML
    private void valider(ActionEvent event) {

        String choix = choix1.getValue().toUpperCase() + choix2.getValue().toUpperCase() + choix3.getValue().toUpperCase();
        String correction = c1.getText().toUpperCase() + c2.getText().toUpperCase() + c3.getText().toUpperCase();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Save changes");
        alert.setHeaderText(null);
        alert.setContentText("Etes vous sur de vos reponses?");
        Optional<ButtonType> result = alert.showAndWait();
        if ((result.get() == ButtonType.OK)) {
            if ((choix.equals(correction))) {
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Bravo");
                alert1.setHeaderText(null);
                alert1.setContentText("Votre reponse est correct!");
                alert1.showAndWait();
                System.out.println("reponse vraie");

//            try {
//                String requette = " UPDATE `resultat_test_histoire` SET `score` =  `score`+ 20 ";
//                Statement stm = cnx.createStatement();
//                stm.executeUpdate(requette);
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
                Notifications notificationBuilder = Notifications.create()
                        .title("BRAVO!").text("votre score a éte augmenté!").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                        .position(Pos.TOP_CENTER)
                        .onAction((ActionEvent event1) -> {
                            System.out.println("valider");
                        });

                notificationBuilder.darkStyle();
                notificationBuilder.show();

            } else {
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Desole");
                alert2.setHeaderText(null);
                alert2.setContentText("Votre reponse est fausse! Voir les reponses corrects");
                alert2.showAndWait();
                c1.setVisible(true);
                c2.setVisible(true);
                c3.setVisible(true);
            }
        }

    }

    public void afficher(Test_histoire t) {
        q1.setText(t.getQuestion1());
        q2.setText(t.getQuestion2());
        q3.setText(t.getQuestion3());
        r11.setText(t.getR11());
        r12.setText(t.getR12());
        r13.setText(t.getR13());
        r21.setText(t.getR21());
        r22.setText(t.getR22());
        r23.setText(t.getR23());
        r31.setText(t.getR31());
        r32.setText(t.getR32());
        r33.setText(t.getR33());
        choix1.getItems().addAll("A", "B", "C");
        choix2.getItems().addAll("A", "B", "C");
        choix3.getItems().addAll("A", "B", "C");

        c1.setText(t.getCorrectionQ1());
        c2.setText(t.getCorrectionQ2());
        c3.setText(t.getCorrectionQ3());
    }

}
