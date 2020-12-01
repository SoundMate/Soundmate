/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 28/11/20, 12:19
 */

package it.soundmate.logiccontrollers;

import it.soundmate.beans.UserBean;
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

    public UserBean login(String email, String password) {
        UserBean user;
        user = userDao.getByEmailAndPassword(email, password);
        return user;
    }

}
