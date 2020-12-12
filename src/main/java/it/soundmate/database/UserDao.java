/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 11/12/20, 15:42
 */

package it.soundmate.database;

import it.soundmate.model.User;
import it.soundmate.model.UserType;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements Dao<User> {

    /*Singleton*/

    private static UserDao instance = null;

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    @Override
    public User getByID(long id) {
        return null;
    }

    public User getByEmailAndPassword(String email, String password) {
        String query = "select * from \"Users\" where email=? and password=?;";
        ResultSet result;
        try (PreparedStatement preparedStatement = Connector.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            result = preparedStatement.executeQuery();
            User user = new User();
            while (result.next()) {
                user.setFirstName(result.getString("firstName"));
                user.setLastName(result.getString("lastName"));
                user.setEmail(result.getString("email"));
                user.setUserID(result.getInt("id"));
                switch (result.getInt("type")) {
                    case 1:
                        user.setUserType(UserType.SOLO);
                        break;
                    case 2:
                        user.setUserType(UserType.BAND_MANAGER);
                        break;
                    case 3:
                        user.setUserType(UserType.BAND_ROOM_MANAGER);
                        break;
                    default:
                        return null;
                }
            }
            return user;
        } catch (SQLException e) {
            //TODO: Handle SQL Exception (Login Error)
            e.printStackTrace();
        }
        return null;
    }

    public boolean registerUser(String email, String password, String firstName, String lastName, int type) {
        String query = "insert into \"Users\" (email, password, \"firstName\", \"lastName\", type) values (?,?,?,?,?);";
        try (PreparedStatement preparedStatement = Connector.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setInt(5,type);
            //executeUpdate returns the numbers of affected row
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
    }

    public boolean registerSoloFromUsers(int id) {
        String query = "insert into \"Solos\" (\"userID\") values (?)";
        try (PreparedStatement preparedStatement = Connector.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            //executeUpdate returns the numbers of affected row
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
    }

    public boolean registerBand(String name) {
        String query = "insert into \"Bands\" (band_name) values (?)";
        try (PreparedStatement preparedStatement = Connector.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, name);
            //executeUpdate returns the numbers of affected row
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
    }

    public boolean registerBandManager(int id, String name) {
        String query = "insert into \"BandManagers\" (\"userID\", bands) values (?,?)";
        try (PreparedStatement preparedStatement = Connector.getInstance().getConnection().prepareStatement(query)) {
            String[] nameArray = {name};
            Array bandNameArray = Connector.getInstance().getConnection().createArrayOf("text", nameArray);
            preparedStatement.setInt(1, id);
            preparedStatement.setArray(2, bandNameArray);
            //executeUpdate returns the numbers of affected row
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
    }

    public boolean registerBandRoomManager(int id, String name) {
        String query = "insert into \"BandRoomManager\" (\"userid\", bandroomname) values (?,?)";
        try (PreparedStatement preparedStatement = Connector.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            //executeUpdate returns the numbers of affected row
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
    }

}
