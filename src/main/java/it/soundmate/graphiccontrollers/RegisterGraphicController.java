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

import it.soundmate.utils.ImagePicker;
import it.soundmate.utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterGraphicController {

    private final Logger logger = Logger.getLogger(RegisterGraphicController.class.getName());

    @FXML
    private ImageView imgViewProfile;

    @FXML
    private Button addProfilePicBtn;

    @FXML
    private ImageView backBtn;

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
                logger.log(Level.WARNING, "Error uploading image");
            }
        }

        /*
        * Continue Button
        *
        * Check if the fields are not empty or
        * there's some error in them.
        * If there's not then launch the second registration page.
        * */

    }

    @FXML
    void handleBackButton(MouseEvent event) {
        if (event.getSource() == this.backBtn) {
            Stage stage = Navigator.navigateToFXMLPage((Stage) backBtn.getScene().getWindow(), "view/Register.fxml");
            assert stage != null;
            stage.show();
        }
    }
}