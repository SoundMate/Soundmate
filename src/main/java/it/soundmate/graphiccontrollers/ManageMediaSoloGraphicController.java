/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 16/12/20, 19:58
 */
package it.soundmate.graphiccontrollers;

import it.soundmate.App;
import it.soundmate.model.Solo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageMediaSoloGraphicController {

    private Solo soloUser;

    @FXML
    private Label noPhotosLabel;

    @FXML
    private Region photosRegion;

    @FXML
    private Button uploadPhotosBtn;

    @FXML
    private Label noVideosLabel;

    @FXML
    private Region videosRegion;

    @FXML
    private Button uploadVideosBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Label manageMediaLabel;

    @FXML
    private HBox videosHbox;

    @FXML
    private HBox photosHbox;

    @FXML
    void backAction(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("view/SoloProfileSolo.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage currentStage = (Stage) this.manageMediaLabel.getScene().getWindow();
        currentStage.setScene(scene);
        SoloProfileSoloGraphicController soloProfileSoloGraphicController = loader.getController();
        soloProfileSoloGraphicController.initData(soloUser);
        currentStage.show();
    }

    @FXML
    void onUploadPhotos(ActionEvent event) {
        //Empty method
    }

    @FXML
    void onUploadVideos(ActionEvent event) {
        //Empty method
    }

    public void initData(Solo soloUser) {
        this.soloUser = soloUser;
        manageMediaLabel.setText("Manage Media for "+soloUser.getFirstName() +" "+soloUser.getLastName());

    }
}

