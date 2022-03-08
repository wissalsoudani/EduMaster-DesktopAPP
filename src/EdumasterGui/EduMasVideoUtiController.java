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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class EduMasVideoUtiController implements Initializable {

    @FXML
    private ComboBox<?> comb;
    @FXML
    private StackPane StackPane;
    @FXML
    private MediaView MediaView;
    @FXML
    private Button btnplay;
    @FXML
    private Button btnpause;
    @FXML
    private Button btnstop;
    @FXML
    private Button btnslow;
    @FXML
    private Button btnarriere;
    @FXML
    private Button btnavant;
    @FXML
    private Button btnaccelere;
    @FXML
    private Slider volumeSlider;
    @FXML
    private Button btnrevenir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Select(ActionEvent event) {
    }

    @FXML
    private void Play(ActionEvent event) {
    }

    @FXML
    private void Pause(ActionEvent event) {
    }

    @FXML
    private void Stop(ActionEvent event) {
    }

    @FXML
    private void Slow(ActionEvent event) {
    }

    @FXML
    private void Moins(ActionEvent event) {
    }

    @FXML
    private void Plus(ActionEvent event) {
    }

    @FXML
    private void Go(ActionEvent event) {
    }

    @FXML
    private void Revenir(ActionEvent event) {
    }
    
}
