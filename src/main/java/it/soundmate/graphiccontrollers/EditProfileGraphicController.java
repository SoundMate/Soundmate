/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 12/12/20, 23:39
 */

package it.soundmate.graphiccontrollers;

import it.soundmate.App;
import it.soundmate.logiccontrollers.SoloProfileSoloController;
import it.soundmate.model.Solo;
import it.soundmate.utils.ImagePicker;
import it.soundmate.utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class EditProfileGraphicController {

    public static final String UPDATE_EMAIL = "Update Email";
    public static final String UPDATE_PASSWORD = "Update Password";
    public static final String UPDATE_FIRST_NAME = "Update First Name";
    public static final String UPDATE_LAST_NAME = "Update Last Name";
    public static final String CANCEL = "Cancel";

    SoloProfileSoloController soloProfileSoloController = SoloProfileSoloController.getInstance();
    private final Logger logger = LoggerFactory.getLogger(EditProfileGraphicController.class);
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
    private Button backBtn;

    @FXML
    private Button deleteAccountBtn;

    @FXML
    void onBackAction(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("view/SoloProfileSolo.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage currentStage = (Stage) this.backBtn.getScene().getWindow();
        currentStage.setScene(scene);
        SoloProfileSoloGraphicController soloProfileSoloGraphicController = loader.getController();
        soloProfileSoloGraphicController.initData(soloUser);
        currentStage.show();
    }

    @FXML
    void onDeleteAccountAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Account");
        alert.setHeaderText("Deleting the account is permanent, if you want to use Soundmate\n again you will need to create a new account");
        alert.setContentText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            logger.info("Result is present");
            if (result.get() == ButtonType.OK){
                logger.info("Result is OK");
                if (soloProfileSoloController.deleteAccount(this.soloUser)) {
                    Navigator.navigateToFXMLPage((Stage) this.deleteAccountBtn.getScene().getWindow(), "view/LandingLogin.fxml");
                } else {
                    logger.info("Unable to delete Account");
                }
            } else {
                logger.info("Exited confirmation dialog");
            }
        }
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
            if(soloProfileSoloController.saveProfilePicToDB(chosenImage, soloUser.getUserID())) {
                logger.info("Saved profile pic for user: {} {}", soloUser.getFirstName(), soloUser.getLastName());
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

    private void updateInDB(ActionEvent event, Button doneBtn, Button updateBtn, TextField updateTextField, Label label, String btnText) {
        if (event.getSource() == doneBtn && updateBtn.getText().equals(CANCEL)) {
            if (updateTextField.getText().isEmpty()) {
                updateTextField.setPromptText("Text field is empty");
            } else {
                label.setText(updateTextField.getText());
                updateTextField.setVisible(false);
                doneBtn.setVisible(false);
                updateBtn.setText(btnText);
                switch (btnText) {
                    case UPDATE_EMAIL:
                        if (soloProfileSoloController.updateEmail(soloUser, updateTextField.getText())) {
                            logger.info("Updated email in DB ({}) for user {}", soloUser.getUserID(), updateTextField.getText());
                        }
                        break;
                    case UPDATE_PASSWORD:
                        if (soloProfileSoloController.updatePassword(soloUser, updateTextField.getText())) {
                            logger.info("Updated password in DB ({}) for user {}", soloUser.getUserID(), updateTextField.getText());
                        }
                        break;
                    case UPDATE_FIRST_NAME:
                        if (soloProfileSoloController.updateFirstName(soloUser, updateTextField.getText())) {
                            logger.info("Updated first name in DB ({}) for user {}", soloUser.getUserID(), updateTextField.getText());
                        }
                        break;
                    case UPDATE_LAST_NAME:
                        if (soloProfileSoloController.updateLastName(soloUser, updateTextField.getText())) {
                            logger.info("Updated last name in DB ({}) for user {}", soloUser.getUserID(), updateTextField.getText());
                        }
                        break;
                    default:
                        logger.info("Unable to update in DB");
                }
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

    void initData(Solo user) {
        this.soloUser = user;
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
