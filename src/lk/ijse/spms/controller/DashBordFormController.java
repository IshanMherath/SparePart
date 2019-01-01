/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DashBordFormController implements Initializable {

    @FXML
    private AnchorPane lordPane;
    @FXML
    private JFXButton prtBtn;
    @FXML
    private AnchorPane pnlLord;
    @FXML
    private JFXButton orderBtn;
    @FXML
    private JFXButton suplierBtn;
    @FXML
    private JFXButton mghtStockBtn;
    @FXML
    private Label dateLb;
    @FXML
    private Label timeLb;
    @FXML
    private JFXButton custBtn;
    @FXML
    private JFXButton reportsBtn;
    @FXML
    private JFXButton btnLogOut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(5000), lordPane);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
        setDateTime();
    }    

    @FXML
    private void lordparts(MouseEvent event) throws IOException {
        AnchorPane anchorPane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/spms/view/PartsForm.fxml"));
        pnlLord.getChildren().add(anchorPane);
    }

    @FXML
    private void LordOrder(MouseEvent event) throws IOException {
    AnchorPane anchorPane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/spms/view/OrderForm.fxml"));
    pnlLord.getChildren().add(anchorPane);
    }

    @FXML
    private void supplierLord(MouseEvent event) throws IOException {
       AnchorPane anchorPane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/spms/view/SupplierForm.fxml"));
       pnlLord.getChildren().add(anchorPane);
   
    
    }

    @FXML
    private void LordStockPanel(MouseEvent event) throws IOException {
    AnchorPane anchorPane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/spms/view/MakePaymentForm.fxml"));
       pnlLord.getChildren().add(anchorPane);
       
    }
     private void setDateTime() {
     Timeline newTimeLine=new Timeline(new KeyFrame(Duration.seconds(0),new EventHandler<ActionEvent>(){
         @Override
         public void handle(ActionEvent event) {
          dateLb.setText(new SimpleDateFormat("YYYY:MM:DD").format(new Date()));
          timeLb.setText(new SimpleDateFormat("hh:mm:ss a").format(new Date()));
         }
     }),new KeyFrame(Duration.seconds(1)));
     newTimeLine.setCycleCount(Animation.INDEFINITE);
     newTimeLine.play();
     
    }



    @FXML
    private void CustomerFormLoard(ActionEvent event) throws IOException {
     AnchorPane anchorPane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/spms/view/CustomerForm.fxml"));
    pnlLord.getChildren().add(anchorPane);
   
    }

    @FXML
    private void loardReports(ActionEvent event) throws IOException {
     AnchorPane anchorPane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/spms/view/Reports.fxml"));
    pnlLord.getChildren().add(anchorPane);
   
    
    }

    @FXML
    private void logOut(ActionEvent event) {
        Stage stage=(Stage) this.lordPane.getScene().getWindow();
        Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure",ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> showAndWait = a.showAndWait();
        if(showAndWait.get() ==  ButtonType.YES){
            stage.close();
        }
        
    }
}
