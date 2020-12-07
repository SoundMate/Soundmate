/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 04/12/20, 16:45
 */

package it.soundmate.beans;

import it.soundmate.logiccontrollers.RegisterController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterBean {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String name;   //Could be the Band Name or the Band Room Name

    private final RegisterController registerController = new RegisterController();
    private final Logger logger = LoggerFactory.getLogger(RegisterBean.class);

    //RegisterBean for Solo constructor (Generic)
    public RegisterBean(String email, String password, String firstName, String lastName){
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //RegisterBean for Band or Band Room constructor
    public RegisterBean(String email, String password, String firstName, String lastName, String name) {
        this(email, password, firstName, lastName);
        this.name = name;
    }

    public RegisterBean(){}


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Returns true if one the common fields is null
    public boolean checkFields(){
        return this.email == null || this.password == null || this.firstName == null || this.lastName == null
        || this.email.isEmpty() || this.password.isEmpty() || this.firstName.isEmpty() || this.lastName.isEmpty();
    }

    //Returns true if name is null
    public boolean checkName() {
        return (this.name == null || this.name.isEmpty());
    }

    public UserBean registerUser(int type) {
        logger.info("Registering user of type: {}", type);
        if (!checkFields()) {
            if (type == 1) {  //When user is solo, name must be null
                logger.info("Registering solo user");
                return registerController.registerUser(getEmail(), getPassword(), getFirstName(), getLastName(), type, null);
            } else {
                logger.info("Checking name...");
                if (!checkName()) {
                    logger.info("Name is not null: {}", getName());
                    return registerController.registerUser(getEmail(), getPassword(), getFirstName(), getLastName(), type, getName());
                } else {
                    logger.info("Band or BandRoom name field is empty");
                    return null;
                }
            }
        } else {
            logger.info("Some common fields are empty");
            return null;
        }
    }

}
