package it.soundmate.usercontroller;

import java.awt.*;

public class BandManager extends User{

    private Band[] bands;



    public BandManager(int userID, String email, String firstName, String lastName, String password, Image[] photos, Image profilePic) {
        super(userID, email, firstName, lastName, password, photos, profilePic);
    }
}
