/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 11/12/20, 15:42
 */

package it.soundmate.utils;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import java.io.File;

public class ImagePicker {
    private final FileChooser fileChooser;

    public ImagePicker() {
        this.fileChooser = new FileChooser();
        configureFileChooser(this.fileChooser);
    }

    public File chooseImage(ImageView imageView) {
        File file = this.fileChooser.showOpenDialog(imageView.getScene().getWindow());
        if (file != null) {
            Image chosenImage = new Image(file.toURI().toString());
            imageView.setImage(chosenImage);
            return file;
        } else return null;
    }

    public File chooseImage(Circle circle) {
        File file = this.fileChooser.showOpenDialog(circle.getScene().getWindow());
        if (file != null) {
            Image chosenImage = new Image(file.toURI().toString());
            circle.setFill(new ImagePattern(chosenImage));
            return file;
        } else return null;
    }

    private void configureFileChooser(FileChooser fileChooser) {
        fileChooser.setTitle("Choose an image for your band profile");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
    }
}
