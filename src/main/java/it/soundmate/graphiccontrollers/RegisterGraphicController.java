/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 21/11/20, 16:06
 */

package it.soundmate.graphiccontrollers;

/*
* RegisterGraphicController
*
* Is the graphic controller shared by the three types of
* registration pages: Band, Room and Solo.
* Each view is handled graphically and logically by a
* single controller.
* */

import it.soundmate.beans.UserBean;
import it.soundmate.logiccontrollers.RegisterController;
import it.soundmate.utils.ImagePicker;
import it.soundmate.utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterGraphicController {

    private final Logger logger = LoggerFactory.getLogger(RegisterGraphicController.class);
    private final RegisterController registerController= new RegisterController();

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
        * If there's not then launch the second registration page.
        * */

        if (event.getSource() == continueBtn) {
            this.registerUser();
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

    private void registerUser() {
        int type = this.assignType();
        if (emailTextField.getText().isEmpty() || passwordTextField.getText().isEmpty() || firstNameTextField.getText().isEmpty() || lastNameTextField.getText().isEmpty()) {
            logger.info("Some fields are blank");
            //TODO: Handle blank fields
        } else {
            UserBean newUser;
            if (type == 1) {
                newUser = registerController.registerUser(emailTextField.getText(), passwordTextField.getText(), firstNameTextField.getText(), lastNameTextField.getText(), type, null);
            } else {
                newUser = registerController.registerUser(emailTextField.getText(), passwordTextField.getText(), firstNameTextField.getText(), lastNameTextField.getText(), type, bandOrRoomNameTextField.getText());
            }
            logger.info("User Logged: {}", newUser.getEmail());
        }
    }

}