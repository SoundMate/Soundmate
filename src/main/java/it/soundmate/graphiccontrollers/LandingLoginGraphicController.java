/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 11/12/20, 15:42
 */

package it.soundmate.graphiccontrollers;

import it.soundmate.App;
import it.soundmate.beans.LoginBean;
import it.soundmate.model.User;
import it.soundmate.utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static it.soundmate.model.UserType.*;

public class LandingLoginGraphicController {

    private final Logger logger = LoggerFactory.getLogger(LandingLoginGraphicController.class);

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button joinNowBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField pswTextField;

    @FXML
    private void handleButtonAction (ActionEvent event) {

        if(event.getSource() == joinNowBtn) {
            Stage stage = Navigator.navigateToFXMLPage((Stage) joinNowBtn.getScene().getWindow(), "view/Register.fxml");
            assert stage != null;
            stage.show();
        } else if (event.getSource() == loginBtn) {
            LoginBean loginBean = new LoginBean(emailTextField.getText(), pswTextField.getText());   //Nel Login Bean avviene un controllo di sintassi sui campi
            User user = loginBean.validate();
            if (user == null){
                logger.error("Error in Login"); //To be handled with Exceptions
                //TODO: Handle Login Error
            } else {
                logger.info("Login Successful: {} {}", user.getFirstName(), user.getLastName());
                try {
                    loginUserUI(user, this.borderPane);
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.info("IO Exception loading fxml.");
                }
            }
        }
    }

    public static void loginUserUI(User user, Pane borderPane) throws IOException {
        switch (user.getUserType()) {
            case SOLO:
                FXMLLoader loader = new FXMLLoader(App.class.getResource("view/SoloProfileSolo.fxml"));
                Scene scene = new Scene(loader.load());
                Stage currentStage = (Stage) borderPane.getScene().getWindow();
                currentStage.setScene(scene);
                SoloProfileSoloGraphicController soloProfileSoloGraphicController = loader.getController();
                soloProfileSoloGraphicController.initData(user);
                currentStage.show();
                break;
            case BAND_MANAGER:
                break;
            case BAND_ROOM_MANAGER:
                break;
            default:
                throw new RuntimeException();
        }
    }

}
