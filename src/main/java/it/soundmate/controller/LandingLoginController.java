package it.soundmate.controller;

import java.io.IOException;

import it.soundmate.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LandingLoginController {

    @FXML
    private Button joinNowBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private void handleButtonAction (ActionEvent event) throws IOException {

        if(event.getSource() == joinNowBtn) {
            Stage stage = (Stage) joinNowBtn.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/Register.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

}
