package it.soundmate.controller;

import it.soundmate.utils.ImagePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterBandController {

    private final Logger logger = Logger.getLogger(RegisterBandController.class.getName());

    @FXML
    private ImageView imgViewProfile;

    @FXML
    private Button addProfilePicBtn;

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

        else if (event.getSource() == continueBtn) {
            //TODO: Implement Continue Button;
        }
    }
}