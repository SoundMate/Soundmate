/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 11/12/20, 22:21
 */

package it.soundmate.graphiccontrollers;

import it.soundmate.logiccontrollers.SoloProfileSoloController;
import it.soundmate.model.User;
import it.soundmate.utils.ImagePicker;
import it.soundmate.utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class SoloProfileSoloGraphicController {

    private final Logger logger = LoggerFactory.getLogger(SoloProfileSoloGraphicController.class);
    private final SoloProfileSoloController soloProfileSoloController = new SoloProfileSoloController();
    private User user;

    @FXML
    private StackPane homeStackPane;

    @FXML
    private StackPane searchStackPane;

    @FXML
    private StackPane messagesStackPane;

    @FXML
    private StackPane profileStackPane;

    @FXML
    private StackPane settingsStackPane;

    @FXML
    private Button logoutBtn;

    @FXML
    private Circle profilePicCircle;

    @FXML
    private Label nameLabel;

    @FXML
    private Circle instrumentCircle;

    @FXML
    private Label instrumentLabel;

    @FXML
    private Button addInstrumentBtn;

    @FXML
    private Button addGenreBtn;

    @FXML
    private Button editProfileBtn;

    @FXML
    private Button searchBandsBtn;

    @FXML
    private Button manageMediaBtn;

    @FXML
    void onAddButtonsAction(ActionEvent event) {
        if (event.getSource() == addInstrumentBtn) {
            //Add instrument dialog
        } else if (event.getSource() == addGenreBtn) {
            //Add genre dialog
        }
    }


    @FXML
    void onMainButtonsAction(ActionEvent event) {
        if (event.getSource() == editProfileBtn) {
            //Per ora imposta solo immagine profilo con image picker
            ImagePicker imagePicker = new ImagePicker();
            File chosenImage = imagePicker.chooseImage(this.profilePicCircle);
            if(soloProfileSoloController.saveProfilePicToDB(chosenImage, user.getUserID())) {
                logger.info("Saved profile pic for user: {} {}", user.getFirstName(), user.getLastName());
            } else logger.info("Profile Pic not saved, error");

        }
    }

    @FXML
    void onMenuItemClick(MouseEvent event) {
        //Navigation
    }

    @FXML
    void onLogoutAction(ActionEvent event) {
        Navigator.navigateToFXMLPage((Stage) this.logoutBtn.getScene().getWindow(), "view/LandingLogin.fxml");
    }


    void initData(User user) {
        this.user = user;
        this.nameLabel.setText(user.getFirstName() + " " + user.getLastName());
        Image addImage = new Image(getClass().getResourceAsStream("/it/soundmate/icons/add.png"));
        this.instrumentCircle.setFill(new ImagePattern(addImage));
        if (user.getProfilePic() != null) {
            Image profilePic = new Image(user.getProfilePic());
            this.profilePicCircle.setFill(new ImagePattern(profilePic));
        }

    }

}
