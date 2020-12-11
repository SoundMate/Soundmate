package it.soundmate.usercontroller;

import java.awt.*;
import java.util.ArrayList;

public class BandManager extends User{

    private ArrayList<Band> managedBands;


    public BandManager(int userID, String email, String firstName, String lastName, String password, Image[] photos, Image profilePic) {
        super(userID, email, firstName, lastName, password, photos, profilePic);
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
