/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 11/12/20, 15:42
 */

import it.soundmate.beans.LoginBean;
import it.soundmate.beans.UserBean;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestLogin {

    @Test
    void testLoginNotInDB() {
        LoginBean loginBean = new LoginBean();
        loginBean.setEmail("dummy.email");
        loginBean.setPassword("dummy password");
        UserBean userBean = loginBean.validate();
        String name = userBean.getFirstName();
        assertNull(name);
    }

    @Test
    void testLoginNullEmail() {
        LoginBean loginBean = new LoginBean();
        loginBean.setEmail("");
        loginBean.setPassword("dummy password");
        UserBean userBean = loginBean.validate();
        assertNull(userBean);
    }

    @Test
    void testLoginNullPassword() {
        LoginBean loginBean = new LoginBean();
        loginBean.setEmail("dummy.email");
        loginBean.setPassword("");
        UserBean userBean = loginBean.validate();
        assertNull(userBean);
    }

}
