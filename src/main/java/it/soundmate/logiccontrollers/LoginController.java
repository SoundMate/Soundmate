/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 28/11/20, 12:19
 */

package it.soundmate.logiccontrollers;

import it.soundmate.beans.UserBean;

public class LoginController {

    /* Singleton */

    private static LoginController instance = null;

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
    * attributi del bean da passare alla view. Per adesso esegue un login
    * finto con 50% di possibilità.
    *
    * */

    public UserBean login(String email, String password) {
        /*Verifica qui email e password*/
        UserBean userBean = new UserBean();
        userBean.setFirstName("Lorenzo");
        userBean.setLastName("Pantano");
        if (Math.random() > 0.5) {
            return userBean;
        } else return null;
    }

}
