/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 12/12/20, 23:57
 */

package it.soundmate.logiccontrollers;

import it.soundmate.database.UserDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class EditProfileSoloController {

    UserDao userDao = UserDao.getInstance();

    public boolean saveProfilePicToDB(File image, int userID) {
        try {
            InputStream inputStream = new FileInputStream(image);
            return userDao.saveProfilePicForUser(inputStream, userID);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
