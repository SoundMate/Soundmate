package it.soundmate.graphiccontrollers;

import it.soundmate.utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ChooseRegisterGraphicController {

    @FXML
    private ImageView backBtn;

    @FXML
    private ImageView infoBtn;

    @FXML
    private Button bandRegisterBtn;

    @FXML
    private Button soloRegisterBtn;

    @FXML
    private Button roomRegisterBtn;

    @FXML
    void handleBackClick(MouseEvent event) {
        if (event.getSource() == backBtn) {
            Stage stage = Navigator.navigateToFXMLPage((Stage) backBtn.getScene().getWindow(), "view/LandingLogin.fxml");
            assert stage != null;
            stage.show();
        }
    }

    @FXML
    void handleButtonAction(ActionEvent event) {
        if (event.getSource() == bandRegisterBtn) {
            Stage stage = Navigator.navigateToFXMLPage((Stage) bandRegisterBtn.getScene().getWindow(), "view/RegisterBand.fxml");
            assert stage != null;
            stage.show();
        }
        else if (event.getSource() == soloRegisterBtn) {
            Stage stage = Navigator.navigateToFXMLPage((Stage) soloRegisterBtn.getScene().getWindow(), "view/RegisterSolo.fxml");
            assert stage != null;
            stage.show();
        } else if (event.getSource() == roomRegisterBtn) {
            Stage stage = Navigator.navigateToFXMLPage((Stage) roomRegisterBtn.getScene().getWindow(), "view/RegisterRoom.fxml");
            assert stage != null;
            stage.show();
        }
    }

    @FXML
    void handleInfoClick(MouseEvent event) {
        if (event.getSource() == infoBtn) {
            Stage stage = Navigator.navigateToFXMLPage((Stage) infoBtn.getScene().getWindow(), "view/Info.fxml");
            assert stage != null;
            stage.show();
        }
    }
   
}