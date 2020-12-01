package it.soundmate.graphiccontrollers;

import it.soundmate.beans.LoginBean;
import it.soundmate.beans.UserBean;
import it.soundmate.logiccontrollers.LoginController;
import it.soundmate.utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LandingLoginGraphicController {

    @FXML
    private Button joinNowBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField pswTextField;

    private LoginController loginController;

    @FXML
    private void handleButtonAction (ActionEvent event) {

        if(event.getSource() == joinNowBtn) {
            Stage stage = Navigator.navigateToFXMLPage((Stage) joinNowBtn.getScene().getWindow(), "view/Register.fxml");
            assert stage != null;
            stage.show();
        } else if (event.getSource() == loginBtn) {
            LoginBean loginBean = new LoginBean();
            UserBean userBean = loginBean.validate(emailTextField.getText(), pswTextField.getText());
            if (userBean == null){
                System.out.println("ERROR IN LOGIN");
                //TODO: Handle Login Error
            } else {
                System.out.println("Login successful: " + userBean.getFirstName() + " " + userBean.getLastName());
                //TODO: Handle successful Login
            }
        }
    }

}
