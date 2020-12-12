/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 12/12/20, 14:38
 */

package it.soundmate.model;

import java.util.ArrayList;

public class BandManager extends User {

    private ArrayList<Band> managedBands;


    public BandManager(User user) {
        super(user.getUserID(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getProfilePic(), UserType.BAND_MANAGER);
    }

    public void addBandManagement(Band band){
        this.managedBands.add(band);
    }

    public void removeBandManagement(Band band){
        for (int i = 0; i < this.managedBands.size(); i++) {
            if (band.equals(this.managedBands.get(i))) {
                this.managedBands.remove(i);
                break;
            }
        }
    }
}
