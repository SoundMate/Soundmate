package it.soundmate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
        if (event.getSource() == addProfilePicBtn) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose an image");
            File file = fileChooser.showOpenDialog(addProfilePicBtn.getScene().getWindow());
            if (file != null) {
                try {
                    this.desktop.open(file);  //Funziona
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}