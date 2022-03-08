/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Histoire;
import model.Test_histoire;
import service.HistoireI;
import service.Test_HistoireI;

/**
 * FXML Controller class
 *
 * @author user
 */
public class HistoireController implements Initializable {

    @FXML
    private ImageView cov_histoire;
    @FXML
    private Label nom_histoire;

    FrontHistoireController mainControll;
    @FXML
    private Button detailsbutton;

    Histoire CurrentHistoire;
    Test_histoire test;

    public Test_histoire getTest() {
        return test;
    }

    public void setTest(Test_histoire test) {
        this.test = test;
    }

    public Histoire getCurrentHistoire() {
        return CurrentHistoire;
    }

    public void setCurrentHistoire(Histoire CurrentHistoire) {
        this.CurrentHistoire = CurrentHistoire;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { 

        HistoireI h = new HistoireI();  

    }

    public void setMainController(FrontHistoireController controller) {
        this.mainControll = controller;
    }

    public void afficher(Histoire h) {
        setCurrentHistoire(h);
        Test_HistoireI t = new Test_HistoireI();
        setTest(t.afficherTest_histoire()
                .stream()
                .filter(e-> h.getId_histoire()==e.getId_histoire())
                .findAny()
                .orElse(null));
    
        nom_histoire.setText(h.getNom_histoire());
        File file = new File("C:\\Users\\pc\\Documents\\NetBeansProjects\\Edumasternew\\Prodeveurs\\src\\GUI\\assests\\couverture\\" + h.getCouverture_histoire());
        Image image = new Image(file.toURI().toString());
        cov_histoire.setImage(image);

    }

    @FXML
    private void details(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("detailsHistoire.fxml"));
            Parent root1;
            root1 = (Parent) loader.load();
            DetailsHistoireController controller = loader.getController();
            controller.afficher(getCurrentHistoire());
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
//            Stage CurrentStage = (Stage) detailsbutton.getScene().getWindow();
//            CurrentStage.close();

        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    @FXML
    private void test(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("testHistoire.fxml"));
            Parent root1;
            root1 = (Parent) loader.load();
            TestHistoireController controller = loader.getController();
            controller.afficher(getTest());
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
//            Stage CurrentStage = (Stage) detailsbutton.getScene().getWindow();
//            CurrentStage.close();

        } catch (IOException ex) {
            ex.getMessage();
        }
    }

}
