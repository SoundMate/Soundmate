/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 11/12/20, 22:21
 */

package it.soundmate.graphiccontrollers;

import it.soundmate.App;
import it.soundmate.logiccontrollers.SoloProfileSoloController;
import it.soundmate.model.Solo;
import it.soundmate.model.User;
import it.soundmate.utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class SoloProfileSoloGraphicController {

    private final Logger logger = LoggerFactory.getLogger(SoloProfileSoloGraphicController.class);
    private final SoloProfileSoloController soloProfileSoloController = new SoloProfileSoloController();
    private Solo soloUser;

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
    private HBox genresHbox;

    @FXML
    void onAddButtonsAction(ActionEvent event) {
        if (event.getSource() == addInstrumentBtn) {
            //Add instrument dialog
        } else if (event.getSource() == addGenreBtn) {
            Optional<String> result = favGenreDialog();
            result.ifPresent(s -> logger.info("User input genre: {}", s));
            if (result.isPresent() && soloProfileSoloController.addGenre(result.get(), this.soloUser)) {
                logger.info("Added new genre to solo user: {} {}; {}",this.soloUser.getFirstName(), this.soloUser.getLastName(), result.get());
                updateUI(this.soloUser, result.get());
            } else {
                logger.info("Error adding genre");
            }
        }
    }

    private void updateUI(Solo soloUser, String favGenre) {
        soloUser.addFavGenre(favGenre);
        Button newGenre = new Button(favGenre);
        newGenre.setStyle("-fx-background-color: #00b540; -fx-text-fill: white; -fx-background-insets: 0 5px;");
        this.genresHbox.getChildren().add(newGenre);
    }

    private Optional<String> favGenreDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Favourite Genres");
        dialog.setHeaderText("Add a new favourite genre");
        dialog.setContentText("Enter a genre:");
        return dialog.showAndWait();
    }


    @FXML
    void onMainButtonsAction(ActionEvent event) {
        if (event.getSource() == editProfileBtn) {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("view/EditProfileSolo.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage currentStage = (Stage) this.editProfileBtn.getScene().getWindow();
            currentStage.setScene(scene);
            EditProfileGraphicController editProfileGraphicController = loader.getController();
            editProfileGraphicController.initData(soloUser);
            currentStage.show();
        }

        if (event.getSource() == manageMediaBtn) {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("view/ManageMediaSolo.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage currentStage = (Stage) this.manageMediaBtn.getScene().getWindow();
            currentStage.setScene(scene);
            ManageMediaSoloGraphicController manageMediaSoloGraphicController = loader.getController();
            manageMediaSoloGraphicController.initData(soloUser);
            currentStage.show();
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


    public void initData(User user) {
        this.soloUser = soloProfileSoloController.getSoloByUser(user);
        initUserData(this.soloUser);
    }

    private void initUserData(Solo user) {
        this.nameLabel.setText(soloUser.getFirstName() + " " + soloUser.getLastName());
        Image addImage = new Image(getClass().getResourceAsStream("/it/soundmate/icons/add.png"));
        this.instrumentCircle.setFill(new ImagePattern(addImage));
        if (user.getProfilePic() != null) {
            //TODO: Set up image (JavaFX Image? Image from awt? ByteArray?)
        }
        this.profileStackPane.setStyle("-fx-background-color: #00b540");
        if (user.getFavouriteGenres() != null) {
            List<String> favouriteGenres = user.getFavouriteGenres();
            for (String favGenre : favouriteGenres) {
                Button genre = new Button(favGenre);
                genre.setStyle("-fx-background-color: #00b540; -fx-text-fill: white; -fx-background-insets: 0 5px;");
                this.genresHbox.getChildren().add(genre);
            }
        }
    }

    public void initData(Solo soloUser) {
        this.soloUser = soloUser;
        try {
            initUserData(soloUser);
        } catch (IllegalArgumentException e) {
            logger.info("Caught Exception. Unable lo load profile image");
        }
    }

}
