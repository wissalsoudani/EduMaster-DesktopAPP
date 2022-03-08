/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EdumasterGui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class EduMasVideoController implements Initializable {

    @FXML
    private Label Label2;
    @FXML
    private TextField tfNOMV;
    @FXML
    private TextField tfDATE;
    @FXML
    private TextField tfDESC;
    @FXML
    private TextField tfD;
    @FXML
    private ListView<?> listV;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnSuppV;
    @FXML
    private DatePicker DatePicker;
    @FXML
    private StackPane StackPane;
    @FXML
    private MediaView View;
    @FXML
    private Slider slider;
    @FXML
    private Button file;
    @FXML
    private Button play;
    @FXML
    private Slider volumeSlider;
    @FXML
    private Button btnvid;
    @FXML
    private Button btnajout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterVideo(ActionEvent event) {
    }

    @FXML
    private void SupprimerVideo(ActionEvent event) {
    }

    @FXML
    private void getPublication(ActionEvent event) {
    }

    @FXML
    private void ChooseFile(ActionEvent event) {
    }

    @FXML
    private void playVideo(ActionEvent event) {
    }

    @FXML
    private void PauseVideo(ActionEvent event) {
    }

    @FXML
    private void stopVideo(ActionEvent event) {
    }

    @FXML
    private void slow(ActionEvent event) {
    }

    @FXML
    private void minus(ActionEvent event) {
    }

    @FXML
    private void plus(ActionEvent event) {
    }

    @FXML
    private void speed(ActionEvent event) {
    }

    @FXML
    private void VisiterVideo(ActionEvent event) {
    }

    @FXML
    private void RevenirCours(ActionEvent event) {
    }
    
}
