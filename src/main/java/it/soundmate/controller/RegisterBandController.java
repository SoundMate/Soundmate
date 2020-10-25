package it.soundmate.controller;

import it.soundmate.utils.ImagePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class RegisterBandController {

    /*
    * The Desktop class if platform dependent
    * To check if is supported by OS use the static method Desktop.isDesktopSupported()
    * */
    private Desktop desktop;

    @FXML
    private ImageView imgViewProfile;

    @FXML
    private Button addProfilePicBtn;

    @FXML
    private Button continueBtn;

    public RegisterBandController() {
        if (Desktop.isDesktopSupported()) {
            this.desktop = Desktop.getDesktop();
        } else {
            //TODO: Handle desktop not supported
        }
    }

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
                //this.desktop.open(file);  //Funziona
                addProfilePicBtn.setText("Change image");
            } else {
                System.out.println("Error uploading image\n");
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