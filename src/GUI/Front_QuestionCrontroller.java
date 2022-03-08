/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Alert.AlertDialog;
import static GUI.Item_quizController.quiz_static;
import GUI.Front_QuizCrontroller;
import GUI.Item_quizController;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.question;
import service.QuestionService;
import service.UserImplementation;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class Front_QuestionCrontroller implements Initializable {
 UserImplementation u= new UserImplementation();
    @FXML
    private Pane pnl_quess;
    @FXML
    private ScrollPane scrollpane_ques;
    @FXML
    private HBox hbox_quess;
    @FXML
    private Button btn_resultat;
    @FXML
    private Button btn_Quiz;
    @FXML
    private ImageView image_user;
QuestionService QS = new QuestionService();
     private int taille_questions = 0;
   static int indicequestions = 0;
   static int id_question_apartir_quiz=0;
  
    private List<question> questonss = QS.start_quiz(quiz_static.getId_quizs());
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         System.out.println(quiz_static);
      
            taille_questions = questonss.size();
            System.out.println(questonss);
       
       
        Node[] nodes_quess = new Node[taille_questions];
        scrollpane_ques.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        for (indicequestions = 0; indicequestions < taille_questions; indicequestions++) {
            try {
id_question_apartir_quiz=questonss.get(indicequestions).getId_question();
                nodes_quess[indicequestions] = FXMLLoader.load(getClass().getResource("/GUI/Item_Question.fxml"));

                hbox_quess.getChildren().add(nodes_quess[indicequestions]);
            } catch (IOException e) {

            }
        }
    }    

    @FXML
    private void resultat(ActionEvent event) {
        AlertDialog.showNotification("Resultat final", "Votre resultat est : "+Front_QuizCrontroller.score_final, AlertDialog.image_checked);
         Front_QuizCrontroller.score_final=0;
         
    }

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {
        if (event.getSource() == btn_Quiz) {
               Front_QuizCrontroller.score_final=0;
            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/Front_Quiz.fxml")));
            stage.setScene(scene);
            stage.show();

        }
    }

       @FXML
    private void Logout(MouseEvent event) throws IOException {
         Stage nouveauStage;
                u.ChangerEtatetat();
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene);
    }

    @FXML
    private void Profile(MouseEvent event) throws IOException {
        Stage nouveauStage;
               
                Parent root = FXMLLoader.load(getClass().getResource("Profil.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene);
    }

    @FXML
    private void dashHistoire(MouseEvent event) throws IOException {
        Stage nouveauStage;
               
                Parent root = FXMLLoader.load(getClass().getResource("frontHistoire.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene);
    }

    @FXML
    private void Cours(ActionEvent event) throws IOException {
           Stage nouveauStage;
               
                Parent root = FXMLLoader.load(getClass().getResource("CoursFront1.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene); 
    }

    @FXML
    private void Quiz(MouseEvent event) throws IOException {
           Stage nouveauStage;
               
                Parent root = FXMLLoader.load(getClass().getResource("Front_Quiz.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene); 
    }

    @FXML
    private void home(MouseEvent event) throws IOException {
           Stage nouveauStage;
               
                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                nouveauStage.setScene(scene); 
    }

    @FXML
    private void Quiz(ActionEvent event) {
    }
    
}
