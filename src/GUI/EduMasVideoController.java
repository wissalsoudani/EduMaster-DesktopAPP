/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import java.io.File;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
//import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
//import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import model.Video;
import service.Video_Implementation;
import util.Maconnexion;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class EduMasVideoController implements Initializable {

    private String path;
    private MediaPlayer mediaPlayer;
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
    private ListView listV;
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

    Video v = new Video();
    Video_Implementation vi = new Video_Implementation();

    ObservableList<Video> Videos;
    @FXML
    private Slider volumeSlider;
    @FXML
    private Button btnvid;
    @FXML
    private Button btnajout;
  

    public void UpdateTable() {
        Videos = vi.afficher();
        listV.getItems().setAll(Videos);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

       UpdateTable();
       
        
    }

    @FXML
    private void AjouterVideo(ActionEvent event) {

        Connection cnx = Maconnexion.getInstance().getCnx();

        try {
            String req = "INSERT INTO `video`(`nom_video`, `date`, `description`, `duree_video`) VALUES (?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, tfNOMV.getText());
            pst.setString(2, tfDATE.getText());
            pst.setString(3, tfDESC.getText());
            pst.setString(4, tfD.getText());
            pst.execute();
            UpdateTable();
Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Regardez!");
            alert.setHeaderText(null);
            alert.setContentText("Video ajoutée avec succés !");
            alert.showAndWait();
        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }

    @FXML
    private void SupprimerVideo(ActionEvent event) {
        Video_Implementation vi = new Video_Implementation();
        int selecteditem = listV.getSelectionModel().getSelectedIndex();
        vi.SupprimerParId((Video) listV.getSelectionModel().getSelectedItem());
        listV.getItems().remove(selecteditem);

        UpdateTable();
Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SUPPRESSION");
            alert.setHeaderText(null);
            alert.setContentText("OOPS! Video supprimée!");
            alert.showAndWait();    }

    @FXML
    private void getPublication(ActionEvent event) {
        LocalDate myDate = DatePicker.getValue();
        String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Label2.setText("Video ajoutée ce jour:");
        tfDATE.setText(myFormattedDate);
        ;
    }

    @FXML
    private void ChooseFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        File file = fileChooser.showOpenDialog(null);
        path = file.toURI().toString();
        

        if (path != null) {
            Media media = new Media(path);
            mediaPlayer = new MediaPlayer(media);
            View.setMediaPlayer(mediaPlayer);
         mediaPlayer.play();
        
            
            volumeSlider.setValue(mediaPlayer.getVolume()*100);
            volumeSlider.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    mediaPlayer.setVolume(volumeSlider.getValue()/100);
                }
            });
            
            mediaPlayer.currentTimeProperty().addListener(new ChangeListener<javafx.util.Duration>() {
                @Override
                public void changed(ObservableValue<? extends javafx.util.Duration> observable, javafx.util.Duration oldValue, javafx.util.Duration newValue) {
                    slider.setValue(newValue.toSeconds());
                }
            }
            );
            
            slider.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    mediaPlayer.seek(javafx.util.Duration.seconds(slider.getValue()));
                }
            });
            
            slider.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    mediaPlayer.seek(javafx.util.Duration.seconds(slider.getValue()));
                }
            });
            
            mediaPlayer.setOnReady(new Runnable() {
                @Override
                public void run() {
                    javafx.util.Duration total = media.getDuration();
                    slider.setMax(total.toSeconds());
                }
            });
            
            mediaPlayer.play();
        }
    }
           
@FXML
         public void playVideo(ActionEvent event){
        mediaPlayer.play();
        mediaPlayer.setRate(1);
    }

    @FXML
    private void PauseVideo(ActionEvent event) {
mediaPlayer.pause();
    }

    @FXML
    private void stopVideo(ActionEvent event) {
         mediaPlayer.stop();
    }

    @FXML
    private void slow(ActionEvent event) {
          mediaPlayer.setRate(0.5);
    }

    @FXML
    private void minus(ActionEvent event) {
         mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(-5)));
    }

    @FXML
    private void plus(ActionEvent event) {
         mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(5)));
    }

    @FXML
    private void speed(ActionEvent event) {
        mediaPlayer.setRate(2);
    }

    @FXML
    private void VisiterVideo(ActionEvent event) {
                   try {
            Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("EduMasVideoUti.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void RevenirCours(ActionEvent event) {
                           try {
            Stage nouveauStage;
            Parent root = FXMLLoader.load(getClass().getResource("EduMas.fxml"));
            nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            nouveauStage.setScene(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
         
    }
        }
           

    

    
   
