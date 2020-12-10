package it.soundmate.usercontroller;

import java.awt.*;
import java.util.ArrayList;

public class BandManager extends User{

    private ArrayList<Band> bands;



    public BandManager(int userID, String email, String firstName, String lastName, String password, Image[] photos, Image profilePic) {
        super(userID, email, firstName, lastName, password, photos, profilePic);
    }
}
