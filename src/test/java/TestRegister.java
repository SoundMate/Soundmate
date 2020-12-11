/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 11/12/20, 16:01
 */

import it.soundmate.beans.RegisterBean;
import it.soundmate.beans.UserBean;
import it.soundmate.logiccontrollers.RegisterController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class TestRegister {

    @Test
    void testRegisterNullEmail() {
        RegisterBean registerBean = new RegisterBean("", "pass", "First", "Last", "Name");
        for (int i = 1; i <= 3 ; i++) {
            UserBean userBean = registerBean.registerUser(i);
            assertNull(userBean);
        }
    }

    @Test
    void testRegisterNullPass() {
        RegisterBean registerBean = new RegisterBean("email", "", "First", "Last", "Name");
        for (int i = 1; i <= 3 ; i++) {
            UserBean userBean = registerBean.registerUser(i);
            assertNull(userBean);
        }
    }

    @Test
    void testRegisterNullFirst() {
        RegisterBean registerBean = new RegisterBean("email", "pass", "", "Last", "Name");
        for (int i = 1; i <= 3 ; i++) {
            UserBean userBean = registerBean.registerUser(i);
            assertNull(userBean);
        }
    }

    @Test
    void testRegisterNullLast() {
        RegisterBean registerBean = new RegisterBean("email", "pass", "First", "", "Name");
        for (int i = 1; i <= 3 ; i++) {
            UserBean userBean = registerBean.registerUser(i);
            assertNull(userBean);
        }
    }


    //Users of type solo don't need "name" field (loop starts at 2)
    @Test
    void testRegisterNullName() {
        RegisterBean registerBean = new RegisterBean("email", "pass", "First", "Last", "");
        for (int i = 2; i <= 3 ; i++) {
            UserBean userBean = registerBean.registerUser(i);
            assertNull(userBean);
        }
    }

}
