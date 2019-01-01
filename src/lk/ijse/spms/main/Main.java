/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.main;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 *
 * @author User
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent=FXMLLoader.load(this.getClass().getResource("/lk/ijse/spms/view/LoginForm.fxml"));
        Scene scene=new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
         TranslateTransition rempTranslate = new TranslateTransition(Duration.millis(500), scene.getRoot());
            rempTranslate.setFromY(+scene.getWidth());
            rempTranslate.setToY(0);
            rempTranslate.play();
 
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
