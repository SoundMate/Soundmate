package it.soundmate.usercontroller;

import java.util.ArrayList;

public class BandManager extends User{

    private ArrayList<Band> managedBands;


    public BandManager(User user) {
        super(user.getUserID(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getPhotos(), user.getProfilePic());
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
