/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.Stage;
import model.Cours;
import service.Cours_implementation;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class CoursUti2Controller implements Initializable {

    private String path;
    @FXML
    private ComboBox combo;
    @FXML
    private Button btnback;

    Cours_implementation ci = new Cours_implementation();
    Cours c = new Cours();

    @FXML
    private ImageView cour_image;

    @FXML
    private Button Calcul;

    Cours currentcour;

    public Cours getCurrentcour() {
        return currentcour;
    }

    public void setCurrentcour(Cours currentcour) {
        this.currentcour = currentcour;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo.setItems(ci.afficher());

        //.addAll(ci.afficher())   
    }


    @FXML
    private void Calculer(ActionEvent event) {

        try {
            Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    public void affichercour(ActionEvent event) {

        Cours s =(Cours)combo.getValue();

        // File file = new File("");
        File path = new File("C:/Users/pc/Documents/NetBeansProjects/Edumasternew/Prodeveurs/src/Images/Media/"+s.getContenu_cours());
        System.out.println(path);
        //Media media = new Media(new File(path).toURI().toString());
//       Image image1= new Image(getClass().getResourceAsStream(s.getContenu_cours()));
        Image image = new Image(path.toURI().toString());
        cour_image.setImage(image);
//        cour_image.setVisible(true);
//        StackPane root= new StackPane();
//        root.getChildren().add(cour_image);

    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
          Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("CoursFront1.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);
    }

}
