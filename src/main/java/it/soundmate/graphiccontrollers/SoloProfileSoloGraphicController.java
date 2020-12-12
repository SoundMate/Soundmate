/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 11/12/20, 22:21
 */

package it.soundmate.graphiccontrollers;

import it.soundmate.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

public class SoloProfileSoloGraphicController {

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
    void onHomeClicked(MouseEvent event) {

    }

    @FXML
    void onLogoutAction(ActionEvent event) {

    }

    @FXML
    void onMessagesClicked(MouseEvent event) {

    }

    @FXML
    void onProfileClicked(MouseEvent event) {

    }

    @FXML
    void onSearchClicked(MouseEvent event) {

    }

    @FXML
    void onSettingsClicked(MouseEvent event) {

    }

    void initData(User user) {
        this.nameLabel.setText(user.getFirstName() + " " + user.getLastName());
    }

}
