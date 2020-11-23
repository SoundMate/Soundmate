package it.soundmate.controller;

import it.soundmate.utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LandingLoginGraphicController {

    @FXML
    private Button joinNowBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private void handleButtonAction (ActionEvent event) {

        if(event.getSource() == joinNowBtn) {
            Stage stage = Navigator.navigateToFXMLPage((Stage) joinNowBtn.getScene().getWindow(), "view/Register.fxml");
            assert stage != null;
            stage.show();
        }
    }

}
