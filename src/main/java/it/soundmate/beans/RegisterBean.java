/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 04/12/20, 16:45
 */

package it.soundmate.beans;

import it.soundmate.logiccontrollers.RegisterController;

public class RegisterBean {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String city;
    private String mainInstrument;
    private String address;
    private String bandName;
    private String bandRoomName;

    private final RegisterController registerController = new RegisterController();

    public String getFavGenre() {
        return favGenre;
    }

    public void setFavGenre(String favGenre) {
        this.favGenre = favGenre;
    }

    private String favGenre;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMainInstrument() {
        return mainInstrument;
    }

    public void setMainInstrument(String mainInstrument) {
        this.mainInstrument = mainInstrument;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getBandRoomName() {
        return bandRoomName;
    }

    public void setBandRoomName(String bandRoomName) {
        this.bandRoomName = bandRoomName;
    }

    public boolean emptyCommonFields() {
        return getEmail() == null || getPassword() == null || getFirstName() == null || getLastName() == null;
    }

    public boolean emptySoloFields() {
        return getCity() == null;
    }

    public boolean emptyBandRoomFields() {
        return getCity() == null || getBandRoomName() == null || getAddress() == null;
    }

    public UserBean registerUser(String email, String password, String firstName, String lastName, String bandOrRoomName, int type) {
        return registerController.registerUser(email, password, firstName, lastName, type, bandOrRoomName);
    }
}
