package it.soundmate.graphiccontrollers;

import it.soundmate.beans.LoginBean;
import it.soundmate.beans.UserBean;
import it.soundmate.utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LandingLoginGraphicController {

    private final Logger logger = LoggerFactory.getLogger(LandingLoginGraphicController.class);

    @FXML
    private Button joinNowBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField pswTextField;

    @FXML
    private void handleButtonAction (ActionEvent event) {

        if(event.getSource() == joinNowBtn) {
            Stage stage = Navigator.navigateToFXMLPage((Stage) joinNowBtn.getScene().getWindow(), "view/Register.fxml");
            assert stage != null;
            stage.show();
        } else if (event.getSource() == loginBtn) {
            LoginBean loginBean = new LoginBean();   //Nel Login Bean avviene un controllo di sintassi sui campi
            UserBean userBean = loginBean.validate(emailTextField.getText(), pswTextField.getText());
            if (userBean == null){
                logger.error("Error in Login"); //To be handled with Exceptions
                //TODO: Handle Login Error
            } else {
                logger.info("Login Successful: {} {}",userBean.getFirstName(),userBean.getLastName());
                //TODO: Handle successful Login
            }
        }
    }

}
