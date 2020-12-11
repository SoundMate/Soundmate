/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 11/12/20, 15:42
 */

/**
 * Register Controller
 *
 * The register controller handles the logic for the registration process.
 * The method "registerUser()" is shared between the three types of users: Band, BandRoom, Solo.
 * Depending on the parameter "type" the method performs a registration in the DB
 * for the type of user, registering the newly user in the User table and in the
 * corresponding table in the DB.
 *
 * Solo -> Registers in Users table and in Solo table (same ID)
 * Band -> Registers in Users table and in BandManager table with a foreign key on the Band table for the Band managed
 * BandRoom -> Registers in Users table and in BandRoomManager table (same ID).
 * */

package it.soundmate.logiccontrollers;

import it.soundmate.beans.UserBean;
import it.soundmate.database.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterController {

    private final UserDao userDao = UserDao.getInstance();
    private final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    public UserBean registerUser(String email, String password, String firstName, String lastName, int type, String bandOrRoomName){
        /*Register and then Login the registered User*/
        if (userDao.registerUser(email, password, firstName, lastName)) {
            logger.info("User Registered: {} {}", email, password);
            UserBean loginUser = userDao.getByEmailAndPassword(email, password);
            switch (type) {
                case 1:
                    //Register solo data
                    if (userDao.registerSoloFromUsers(loginUser.getUserID())){
                        return loginUser;
                    } else return null;
                case 2:
                    //Register band data and band manager data
                    if (userDao.registerBand(bandOrRoomName) && userDao.registerBandManager(loginUser.getUserID(), bandOrRoomName)){
                        return loginUser;
                    } else return null;
                case 3:
                    //Register Band Room Manager
                    if (userDao.registerBandRoomManager(loginUser.getUserID(), bandOrRoomName)) {
                        return loginUser;
                    } else return null;
                default:
                    return null;

            }
        } else return null;
    }
}
