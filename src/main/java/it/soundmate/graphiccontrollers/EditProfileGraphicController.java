/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 12/12/20, 23:39
 */

package it.soundmate.graphiccontrollers;

import it.soundmate.logiccontrollers.EditProfileSoloController;
import it.soundmate.model.User;
import it.soundmate.utils.ImagePicker;
import it.soundmate.utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;

public class EditProfileGraphicController {

    public static final String UPDATE_EMAIL = "Update Email";
    public static final String UPDATE_PASSWORD = "Update Password";
    public static final String UPDATE_FIRST_NAME = "Update First Name";
    public static final String UPDATE_LAST_NAME = "Update Last Name";
    public static final String CANCEL = "Cancel";

    private final EditProfileSoloController editProfileSoloController = new EditProfileSoloController();
    private final Logger logger = LoggerFactory.getLogger(EditProfileGraphicController.class);
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
    private ImageView profilePicImgView;

    @FXML
    private Label nameLabel;

    @FXML
    private Button updateProfilePicBtn;

    @FXML
    private Button removeProfilePicBtn;

    @FXML
    private Label emailLabel;

    @FXML
    private Button updateEmailBtn;

    @FXML
    private TextField updateEmailTextField;

    @FXML
    private Button doneBtnEmail;

    @FXML
    private Label passwordLabel;

    @FXML
    private Button updatePasswordBtn;

    @FXML
    private TextField updatePasswordTextField;

    @FXML
    private Button doneBtnPassword;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Button updateFirstNameBtn;

    @FXML
    private TextField updateFirstNameTextField;

    @FXML
    private Button doneBtnFirstName;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Button updateLastNameBtn;

    @FXML
    private TextField updateLastNameTextField;

    @FXML
    private Button doneBtnLastName;

    @FXML
    private Button deleteAccountBtn;

    @FXML
    void onDeleteAccountAction(ActionEvent event) {
        //TODO: Implement delete account
    }

    @FXML
    void onLogoutAction() {
        Navigator.navigateToFXMLPage((Stage) this.logoutBtn.getScene().getWindow(), "view/LandingLogin.fxml");
    }

    @FXML
    void onMenuItemClick(MouseEvent event) {
        //TODO: Navigation
    }

    @FXML
    void onProfilePicAction(ActionEvent event) {
        if (event.getSource() == updateProfilePicBtn) {
            ImagePicker imagePicker = new ImagePicker();
            File chosenImage = imagePicker.chooseImage(this.profilePicImgView);
            this.profilePicImgView.setFitWidth(100);
            if(editProfileSoloController.saveProfilePicToDB(chosenImage, user.getUserID())) {
                logger.info("Saved profile pic for user: {} {}", user.getFirstName(), user.getLastName());
            } else logger.info("Profile Pic not saved, error");
        }
    }

    @FXML
    void onDoneButtonAction(ActionEvent event) {
        if (event.getSource() == doneBtnEmail) updateInDB(event, doneBtnEmail, updateEmailBtn, updateEmailTextField, emailLabel, UPDATE_EMAIL);
        if (event.getSource() == doneBtnPassword) updateInDB(event, doneBtnPassword, updatePasswordBtn, updatePasswordTextField, passwordLabel, UPDATE_PASSWORD);
        if (event.getSource() == doneBtnFirstName) updateInDB(event, doneBtnFirstName, updateFirstNameBtn, updateFirstNameTextField, firstNameLabel, UPDATE_FIRST_NAME);
        if (event.getSource() == doneBtnLastName) updateInDB(event, doneBtnLastName, updateLastNameBtn, updateLastNameTextField, lastNameLabel, UPDATE_LAST_NAME);
    }

    private static void updateInDB(ActionEvent event, Button doneBtn, Button updateBtn, TextField updateTextField, Label label, String btnText) {
        if (event.getSource() == doneBtn && updateBtn.getText().equals(CANCEL)) {
            if (updateTextField.getText().isEmpty()) {
                updateTextField.setPromptText("Text field is empty");
            } else {
                label.setText(updateTextField.getText());
                updateTextField.setVisible(false);
                doneBtn.setVisible(false);
                updateBtn.setText(btnText);
                //TODO: Update to DB
            }
        }
    }

    @FXML
    void onUpdateAction(ActionEvent event) {
        if (event.getSource() == updateEmailBtn) {
            updateFieldDisplay(updateEmailBtn, updateEmailTextField, UPDATE_EMAIL);
        }

        if (event.getSource() == updatePasswordBtn) {
            updateFieldDisplay(updatePasswordBtn, updatePasswordTextField, UPDATE_PASSWORD);
        }

        if (event.getSource() == updateFirstNameBtn) {
            updateFieldDisplay(updateFirstNameBtn, updateFirstNameTextField, UPDATE_FIRST_NAME);
        }

        if (event.getSource() == updateLastNameBtn) {
            updateFieldDisplay(updateLastNameBtn, updateLastNameTextField, UPDATE_LAST_NAME);
        }

    }

    private void updateFieldDisplay(Button updateEmailBtn, TextField updateEmailTextField, String btnText) {
        if (updateEmailBtn.getText().equals(btnText)) {
            updateEmailTextField.setVisible(true);
            switch (btnText) {
                case UPDATE_EMAIL:
                    this.doneBtnEmail.setVisible(true);
                    break;
                case UPDATE_PASSWORD:
                    this.doneBtnPassword.setVisible(true);
                    break;
                case UPDATE_FIRST_NAME:
                    this.doneBtnFirstName.setVisible(true);
                    break;
                case UPDATE_LAST_NAME:
                    this.doneBtnLastName.setVisible(true);
                    break;
                default:
                    return;
            }
            updateEmailBtn.setText(CANCEL);
        } else {
            updateEmailTextField.setVisible(false);
            switch (btnText) {
                case UPDATE_EMAIL:
                    this.doneBtnEmail.setVisible(false);
                    break;
                case UPDATE_PASSWORD:
                    this.doneBtnPassword.setVisible(false);
                    break;
                case UPDATE_FIRST_NAME:
                    this.doneBtnFirstName.setVisible(false);
                    break;
                case UPDATE_LAST_NAME:
                    this.doneBtnLastName.setVisible(false);
                    break;
                default:
                    return;
            }
            updateEmailBtn.setText(btnText);
        }
    }

    void initData(User user) {
        this.user = user;
        //Text Fields invisible
        updateEmailTextField.setVisible(false);
        updateFirstNameTextField.setVisible(false);
        updatePasswordTextField.setVisible(false);
        updateLastNameTextField.setVisible(false);
        //Done Buttons invisible
        doneBtnEmail.setVisible(false);
        doneBtnPassword.setVisible(false);
        doneBtnFirstName.setVisible(false);
        doneBtnLastName.setVisible(false);
        //User info
        emailLabel.setText(user.getEmail());
        firstNameLabel.setText(user.getFirstName());
        lastNameLabel.setText(user.getLastName());
        passwordLabel.setText(user.getPassword());
        nameLabel.setText(user.getFirstName() + " " + user.getLastName());
        profilePicImgView.setFitWidth(0);
    }
}
