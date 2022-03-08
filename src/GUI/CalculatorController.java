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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class CalculatorController implements Initializable {
String op="";
    long number1;
    long number2;
    @FXML
    private TextField tfresult;
    @FXML
    private Button btncours;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Number(ActionEvent ae) {
            String no=((Button)ae.getSource()).getText();
       tfresult.setText(tfresult.getText()+no);
        
    }
    public void calculate(long n1,long n2,String op){
        switch(op){
            case"+": tfresult.setText(n1+n2+ "");break;
             case"-": tfresult.setText(n1-n2+ "");break;
              case"*": tfresult.setText(n1*n2+ "");break;
               case"/": 
                   if(n2==0){
                       tfresult.setText("0");break;
                   }
                   tfresult.setText(n1/n2+ "");break;
            
        }
    }

    @FXML
    private void Operation(ActionEvent ae) {
        String operation=((Button)ae.getSource()).getText();
        if(!operation.equals("=")){
            if(!op.equals("")){
                return;
            }
            op=operation;
            number1=Long.parseLong(tfresult.getText());
            tfresult.setText("");
        }
        else{
            if(op.equals("")){
                return;
            }
            number2=Long.parseLong(tfresult.getText());
            calculate(number1,number2,op);
            op="";
        }
    }

    @FXML
    private void RevenirCours(ActionEvent event) {
        int  opt=JOptionPane.showConfirmDialog(null, "avez vous terminez vos calcul?","confirm",JOptionPane.YES_NO_OPTION);
        if (opt==0){
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
}
