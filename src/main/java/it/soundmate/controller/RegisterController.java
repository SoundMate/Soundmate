package it.soundmate.controller;

import it.soundmate.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {

    @FXML
    private ImageView backBtn;

    @FXML
    private ImageView infoBtn;

    @FXML
    private Button bandRegisterBtn;

    @FXML
    private Button soloRegisterBtn;

    @FXML
    void handleBackClick(MouseEvent event) throws IOException {
        Stage stage = (Stage) backBtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/LandingLogin.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == bandRegisterBtn) {
            Stage stage = (Stage) bandRegisterBtn.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/RegisterBand.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void handleInfoClick(MouseEvent event) throws IOException {
    	if (event.getSource() == infoBtn) {
            Stage stage = (Stage) infoBtn.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/Info.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    	}
    }
   
}