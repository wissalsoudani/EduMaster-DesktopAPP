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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.quiz;
import service.QuizzService;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class Item_quizController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label matiere_txt;
    @FXML
    private Label diff_txt;
    @FXML
    private ImageView image_qr;
    @FXML
    private Button btn_start;
private QuizzService QS = new QuizzService();
    static quiz quiz_static = null;
    private String ImageUrl = "http://localhost/";
    private quiz q=QS.getQuiz(Front_QuizCrontroller.id_quiz_static);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
   
         Image image = new Image(ImageUrl + q.getImage());
        
        image_qr.setImage(image);
        diff_txt.setText(q.getDifficulte());
         matiere_txt.setText(q.getMatiere());
    }    

    @FXML
    private void start(ActionEvent event) throws IOException {
         quiz_static=q;
           Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/Front_Question.fxml")));
            stage.setScene(scene);
            stage.show();
    }
    
}
