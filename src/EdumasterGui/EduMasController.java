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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class EduMasController implements Initializable {

    @FXML
    private TextField tfNOM;
    @FXML
    private TextField tfCONTENU;
    @FXML
    private TextField tfPAGES;
    @FXML
    private TextField tfCHAPITRES;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private ListView<?> lid;
    @FXML
    private Label myLabel;
    @FXML
    private DatePicker myDatePicker;
    @FXML
    private Button btntelecharger;
    @FXML
    private Label label1;
    @FXML
    private Button btnvisit;
    @FXML
    private Button btnvideo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterCours(ActionEvent event) {
    }

    @FXML
    private void getSelected(MouseEvent event) {
    }

    @FXML
    private void ModifierCours(ActionEvent event) {
    }

    @FXML
    private void SupprimerCours(ActionEvent event) {
    }

    @FXML
    private void getDate(ActionEvent event) {
    }

    @FXML
    private void VisiterCours(ActionEvent event) {
    }

    @FXML
    private void AccederAjout(ActionEvent event) {
    }
    
}
