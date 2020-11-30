/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 30/11/20, 16:37
 */

package it.soundmate.database;

import it.soundmate.beans.UserBean;
import it.soundmate.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements Dao<User>{

    @Override
    public User getByID(long id) {
        return null;
    }

    public UserBean getByEmailAndPassword(String email, String password) {
        String query = "select * from \"Users\" where email=? and password=?;";
        ResultSet result;
        try (PreparedStatement preparedStatement = Connector.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            result = preparedStatement.executeQuery();
            UserBean user = new UserBean();
            while (result.next()) {
                user.setFirstName(result.getString("firstName"));
                user.setLastName(result.getString("lastName"));
            }
            return user;
        } catch (SQLException e){
            //TODO: Handle SQL Exception (Login Error)
            e.printStackTrace();
        }
        return null;
    }

}
