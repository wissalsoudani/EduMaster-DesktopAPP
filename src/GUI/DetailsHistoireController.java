 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.File;
import service.PDFClasse;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import model.Histoire;
import service.HistoireI;
import service.PDFClasse;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DetailsHistoireController implements Initializable {

    @FXML
    private ScrollPane contenu;
    @FXML
    private Text text;
    @FXML
    private Label nomHistoire;
    @FXML
    private ImageView couverture;
    @FXML
    private Label categorie;
    @FXML
    private Label age;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        HistoireI hs = new HistoireI();
    }

    @FXML
    private void test(ActionEvent event) {
        
        
    }

    public void afficher(Histoire h) {
        File file = new File("C:\\Users\\pc\\Documents\\NetBeansProjects\\Edumasternew\\Prodeveurs\\src\\GUI\\assests\\couverture\\"+h.getCouverture_histoire());
        Image image = new Image(file.toURI().toString());
        couverture.setImage(image);
        nomHistoire.setText(h.getNom_histoire());
        age.setText(String.valueOf(h.getAge()));
        categorie.setText(h.getCatégorie());
        PDFClasse p = new PDFClasse();
        text.setText(p.contenuHistoire(h));

    }
}
