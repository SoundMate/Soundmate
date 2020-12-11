/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 11/12/20, 15:42
 */

package it.soundmate.graphiccontrollers;

import it.soundmate.utils.Navigator;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class InfoGraphicController {

    @FXML
    private ImageView backBtn;

    @FXML
    void handleBackButtonClicked(MouseEvent event) {
    	if (event.getSource() == backBtn) {
            Stage stage = Navigator.navigateToFXMLPage((Stage) backBtn.getScene().getWindow(), "view/Register.fxml");
            assert stage != null;
            stage.show();
    	}
    }

}