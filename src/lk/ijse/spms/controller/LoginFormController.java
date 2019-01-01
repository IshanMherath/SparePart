/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.security.spec.InvalidKeySpecException;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.spms.common.PasswordUtil;
import lk.ijse.spms.dao.CrudUtil;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LoginFormController implements Initializable {

    @FXML
    private JFXButton loginBtn;
    @FXML
    private AnchorPane logingPanel;
    @FXML
    private JFXButton btnAfd;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXPasswordField txtPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(5000), logingPanel);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(2.0);
        fadeIn.play();
        btnAfd.setVisible(false);
    }

    @FXML
    private void lordDashBord(MouseEvent event) throws IOException, Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from user");
        if (rst.next()) {
            String userName = rst.getString(2);
            String salt = rst.getString(3);
            String secPw = rst.getString(4);

            boolean ifPasswordMatches = PasswordUtil.verifyUserPassword(txtPassword.getText(), secPw, salt);
            if (ifPasswordMatches && txtUserName.getText().equals(userName)) {

                Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/spms/view/DashBordForm.fxml"));
                Scene scene=new Scene(root);
                Stage stage=(Stage) this.logingPanel.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();

                TranslateTransition rempTranslate = new TranslateTransition(Duration.millis(500), scene.getRoot());
                rempTranslate.setFromY(+scene.getWidth());
                rempTranslate.setToY(0);
                rempTranslate.play();
            } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR,"Incorrect UserName and ",ButtonType.OK);
                    alert.showAndWait();
                    txtPassword.clear();
                    txtUserName.clear();
                    
            }

        }
    }

    @FXML
    private void addUser(MouseEvent event) throws Exception {
        try {
            String userName = txtUserName.getText();
            String password = txtPassword.getText();
            String salt = PasswordUtil.getSalt(30);
            String secPw = PasswordUtil.generateSecurePassword(password, salt);
            CrudUtil.executeUpdate("Insert into user values(?,?,?,?)", "001", userName, salt, secPw);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(LoginFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
