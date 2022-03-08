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
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class EduMasVideoUtiController implements Initializable {

    private String path;

    private MediaPlayer mediaPlayer;
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
    private ComboBox comb;
    @FXML
    private Button btnrevenir;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     ObservableList<String> list=FXCollections.observableArrayList("Anglais","Francais","Maths","Science");
     comb.setItems(list);
    
     

    }

    /* Media media = new Media(path);
            mediaPlayer = new MediaPlayer(media);
            MediaView.setMediaPlayer(mediaPlayer);
     volumeSlider.setValue(mediaPlayer.getVolume()*100);
            volumeSlider.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    mediaPlayer.setVolume(volumeSlider.getValue()/100);
                }
            }*/

    @FXML
    private void Play(ActionEvent event) {
        mediaPlayer.play();
        mediaPlayer.setRate(1);
         volumeSlider.setValue(mediaPlayer.getVolume()*100);
            volumeSlider.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    mediaPlayer.setVolume(volumeSlider.getValue()/100);
                }
    }); }

    @FXML
    private void Pause(ActionEvent event) {
     
        mediaPlayer.pause();
    }

    @FXML
    private void Stop(ActionEvent event) {
        mediaPlayer.stop();
        Play(event);
    }

    @FXML
    private void Slow(ActionEvent event) {
        mediaPlayer.setRate(0.5);
    }

    @FXML
    private void Moins(ActionEvent event) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(-5)));
    }

    @FXML
    private void Plus(ActionEvent event) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(5)));
    }

    @FXML
    private void Go(ActionEvent event) {
        mediaPlayer.setRate(2);
    }

    @FXML
    private void Select(ActionEvent event) {
 String s=comb.getSelectionModel().getSelectedItem().toString();
        if (s=="Maths"){
        String path = new File("C:/Users/pc/Documents/NetBeansProjects/Edumasternew/Prodeveurs/src/Videos/foufou.mp4").getAbsolutePath();
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        MediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);}
        else if(s=="Francais")
        {String path = new File("C:/Users/pc/Documents/NetBeansProjects/Edumasternew/Prodeveurs/src/Videos/francais.mp4").getAbsolutePath();
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        MediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);
        }
        else if(s=="Anglais") {
        String path = new File("C:/Users/pc/Documents/NetBeansProjects/Edumasternew/Prodeveurs/src/Videos/anglais.mp4").getAbsolutePath();
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        MediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);}
         else if(s=="Science") {
        String path = new File("C:/Users/pc/Documents/NetBeansProjects/Edumasternew/Prodeveurs/src/Videos/science.mp4").getAbsolutePath();
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        MediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);}
        
            }

    @FXML
    private void Revenir(ActionEvent event) {
           try {
            Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("CoursFront1.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
