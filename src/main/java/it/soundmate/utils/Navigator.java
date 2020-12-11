/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 11/12/20, 15:42
 */

package it.soundmate.utils;

import it.soundmate.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigator {

    private Navigator(){}

    public static Stage navigateToFXMLPage(Stage currentStage, String fxmlFilePath) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxmlFilePath));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            return currentStage;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
