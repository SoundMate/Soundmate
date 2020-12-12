/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 11/12/20, 15:42
 */

package it.soundmate.logiccontrollers;

import it.soundmate.model.User;
import it.soundmate.database.UserDao;

public class LoginController {

    /* Singleton */

    private static LoginController instance = null;
    private static final UserDao userDao = new UserDao();

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController();
        }
        return instance;
    }

    /*
    * Login Method
    *
    * Esegui accesso a DB, con email e password, e setta gli
    * attributi del bean da passare alla view.
    *
    * */

    public User login(String email, String password) {
        return userDao.getByEmailAndPassword(email, password);
    }

}
