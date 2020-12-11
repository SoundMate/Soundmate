/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 11/12/20, 15:42
 */

package it.soundmate.graphiccontrollers;

/**
* RegisterGraphicController
*
* Is the graphic controller shared by the three types of
* registration pages: Band, Room and Solo.
* Each view is handled graphically and logically by a
* single controller.
* */

import it.soundmate.App;
import it.soundmate.beans.RegisterBean;
import it.soundmate.beans.UserBean;
import it.soundmate.utils.ImagePicker;
import it.soundmate.utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class RegisterGraphicController {

    private final Logger logger = LoggerFactory.getLogger(RegisterGraphicController.class);

    @FXML
    private ImageView imgViewProfile;

    @FXML
    private Button addProfilePicBtn;

    @FXML
    private ImageView backBtn;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField bandOrRoomNameTextField;

    @FXML
    private Label registerLabel;

    @FXML
    private Button continueBtn;

    @FXML
    void handleButtonAction(ActionEvent event) {

        /*
        * Add profile picture Button
        *
        * Open the system file chooser and pick an image
        * then add it to the image view beyond the button.
        * Update the button text to "Change image".
        * */

        if (event.getSource() == addProfilePicBtn) {
            ImagePicker imagePicker = new ImagePicker();
            int imgResult = imagePicker.chooseImage(imgViewProfile);
            if (imgResult == 0) {
                addProfilePicBtn.setText("Change image");
            } else {
                logger.debug("Error uploading image");
            }
        }

        /*
        * Continue Button
        *
        * Check if the fields are not empty or
        * there's some error in them.
        * If there's not then register the user.
        * */

        if (event.getSource() == continueBtn) {
            RegisterBean registerBean;
            switch (this.assignType()) {
                case 1:
                    registerBean = new RegisterBean(emailTextField.getText(), passwordTextField.getText(), firstNameTextField.getText(), lastNameTextField.getText());
                    break;
                case 2:
                case 3:
                    registerBean = new RegisterBean(emailTextField.getText(), passwordTextField.getText(), firstNameTextField.getText(), lastNameTextField.getText(), bandOrRoomNameTextField.getText());
                    break;
                default:
                    return;
            }
            UserBean registeredUserBean = registerBean.registerUser(this.assignType());
            if (registeredUserBean != null) {
                logger.info("User Registered: {} {}", registerBean.getEmail(), registerBean.getPassword());
                try {
                    FXMLLoader loader = new FXMLLoader(App.class.getResource("view/SoloProfileSolo.fxml"));
                    Scene scene = new Scene(loader.load());
                    Stage currentStage = (Stage) this.continueBtn.getScene().getWindow();
                    currentStage.setScene(scene);
                    SoloProfileSoloGraphicController soloProfileSoloGraphicController = loader.getController();
                    soloProfileSoloGraphicController.initData(registeredUserBean);
                    currentStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.info("IO Exception loafing FXML SoloProfileSolo.fxml");
                }
            } else {
                logger.info("User NOT Registered, something went wrong");
            }
        }

    }

    @FXML
    void handleBackButton(MouseEvent event) {
        if (event.getSource() == this.backBtn) {
            Stage stage = Navigator.navigateToFXMLPage((Stage) backBtn.getScene().getWindow(), "view/Register.fxml");
            assert stage != null;
            stage.show();
        }
    }

    private int assignType() {
        switch (registerLabel.getText()) {
            case "Band Registration":
                return 2;
            case "Band Room Registration":
                return 3;
            case "Solo Registration":
                return 1;
            default:
                return 0;
        }
    }


}