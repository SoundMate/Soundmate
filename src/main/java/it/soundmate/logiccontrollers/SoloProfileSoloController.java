/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 12/12/20, 19:39
 */

package it.soundmate.logiccontrollers;

import it.soundmate.database.SoloDao;
import it.soundmate.database.UserDao;
import it.soundmate.model.Solo;
import it.soundmate.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SoloProfileSoloController {

    private final SoloDao soloDao = SoloDao.getInstance();
    private final UserDao userDao = UserDao.getInstance();

    /*Singleton*/

    private static SoloProfileSoloController instance = null;

    public static SoloProfileSoloController getInstance() {
        if (instance == null) {
            instance = new SoloProfileSoloController();
        }
        return instance;
    }

    public Solo getSoloByUser(User user) {
        return soloDao.getSoloByUser(user);
    }

    public boolean addGenre(String genre, Solo solo) {
        return soloDao.addGenreToSolo(genre, solo);
    }

    public boolean updateEmail(Solo solo, String email) {
        return userDao.updateEmail(solo, email);
    }
    
    public boolean updatePassword(Solo solo, String password) {
        return userDao.updatePassword(solo, password);
    }
    
    public boolean updateFirstName(Solo solo, String firstName) {
        return userDao.updateFirstName(solo, firstName);
    } 
    
    public boolean updateLastName(Solo solo, String lastName) {
        return userDao.updateLastName(solo, lastName);
    }

    public boolean saveProfilePicToDB(File image, int userID) {
        try {
            InputStream inputStream = new FileInputStream(image);
            return userDao.saveProfilePicForUser(inputStream, userID);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAccount(Solo solo) {
        return userDao.deleteUser(solo);
    }
}

