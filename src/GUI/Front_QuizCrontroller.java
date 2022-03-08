/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.quiz;
import service.QuizzService;
import service.UserImplementation;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class Front_QuizCrontroller implements Initializable {
    UserImplementation u = new UserImplementation();
    @FXML
    private Pane pnl_quizs;
    @FXML
    private ScrollPane scrollpane_quiz;
    @FXML
    private HBox hbox_quizs;
    @FXML
    private Button btn_Quiz;
 QuizzService QS = new QuizzService();
    private int taille_quizs = 0;
    private int indiceQuiz = 0;
    static int id_quiz_static = 0;
    static int score_final = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
QS.ModifierQuizz_resultat();
        List<quiz> list = QS.afficherQuizz();
        taille_quizs = list.size();

        Node[] nodes_quiz = new Node[taille_quizs];
        scrollpane_quiz.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        for (indiceQuiz = 0; indiceQuiz < taille_quizs; indiceQuiz++) {
            try {

                id_quiz_static = list.get(indiceQuiz).getId_quizs();

                nodes_quiz[indiceQuiz] = FXMLLoader.load(getClass().getResource("/GUI/Item_Quiz.fxml"));

                hbox_quizs.getChildren().add(nodes_quiz[indiceQuiz]);
            } catch (IOException e) {

            }
        }
    }    

    @FXML
    private void handleClicks(ActionEvent event) {
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
    
}
