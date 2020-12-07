/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 28/11/20, 12:16
 */

package it.soundmate.beans;

import it.soundmate.logiccontrollers.LoginController;

public class LoginBean {
    private String email;
    private String password;

    public LoginBean(){}

    public LoginBean(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /* Nel Bean si può fare un controllo sintattico sui dati inseriti */
    public UserBean validate() {
        if (this.email.isEmpty() || this.password.isEmpty()) {
            return null;
        } else {
            return LoginController.getInstance().login(this.email, this.password);
        }
    }
}
