package it.soundmate.usercontroller;

import java.awt.*;
import java.util.ArrayList;

public class Band extends User{


    private ArrayList<String> genres;
    private ArrayList<Solo> members;
    //private Song songPreviews;
    private ArrayList<String> socials;


    public Band(int userID, String email, String firstName, String lastName, String password, Image[] photos, Image profilePic) {
        super(userID, email, firstName, lastName, password, photos, profilePic);
    }

    public Band(int userID, String email, String firstName, String lastName, String password, Image[] photos,
                Image profilePic, ArrayList<String> genres, ArrayList<Solo> members, ArrayList<String> socials) {
        super(userID, email, firstName, lastName, password, photos, profilePic);
        this.genres = genres;
        this.members = members;
        this.socials = socials;
    }
}
