package it.soundmate.controller;

import java.io.IOException;

import it.soundmate.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class InfoController {

    @FXML
    private ImageView backBtn;

    @FXML
    void handleBackButtonClicked(MouseEvent event) throws IOException {
    	if (event.getSource() == backBtn) {
    		Stage stage = (Stage) backBtn.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/Register.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    	}
    }

}