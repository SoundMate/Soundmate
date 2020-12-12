/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 11/12/20, 15:42
 */

import it.soundmate.beans.LoginBean;
import it.soundmate.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestLogin {

    @Test
    void testLoginNotInDB() {
        LoginBean loginBean = new LoginBean();
        loginBean.setEmail("dummy.email");
        loginBean.setPassword("dummy password");
        User user = loginBean.validate();
        String name = user.getFirstName();
        assertNull(name);
    }

    @Test
    void testLoginNullEmail() {
        LoginBean loginBean = new LoginBean();
        loginBean.setEmail("");
        loginBean.setPassword("dummy password");
        User user = loginBean.validate();
        assertNull(user);
    }

    @Test
    void testLoginNullPassword() {
        LoginBean loginBean = new LoginBean();
        loginBean.setEmail("dummy.email");
        loginBean.setPassword("");
        User user = loginBean.validate();
        assertNull(user);
    }

}
