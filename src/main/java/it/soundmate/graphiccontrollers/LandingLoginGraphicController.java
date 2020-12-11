/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 11/12/20, 15:42
 */

package it.soundmate.graphiccontrollers;

import it.soundmate.beans.LoginBean;
import it.soundmate.beans.UserBean;
import it.soundmate.utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LandingLoginGraphicController {

    private final Logger logger = LoggerFactory.getLogger(LandingLoginGraphicController.class);

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
            UserBean userBean = loginBean.validate();
            if (userBean == null){
                logger.error("Error in Login"); //To be handled with Exceptions
                //TODO: Handle Login Error
            } else {
                logger.info("Login Successful: {} {}",userBean.getFirstName(),userBean.getLastName());
                //TODO: Handle successful Login
            }
        }
    }

}
