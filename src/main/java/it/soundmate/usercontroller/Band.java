package it.soundmate.usercontroller;

import java.awt.*;

public class Band extends User{


    private String[] genres;
    private Solo[] members;
    //private Song songPreviews;
    private String[] socials;


    public Band(int userID, String email, String firstName, String lastName, String password, Image[] photos, Image profilePic) {
        super(userID, email, firstName, lastName, password, photos, profilePic);
    }

    public Band(int userID, String email, String firstName, String lastName, String password, Image[] photos,
                Image profilePic, String[] genres, Solo[] members, String[] socials) {
        super(userID, email, firstName, lastName, password, photos, profilePic);
        this.genres = genres;
        this.members = members;
        this.socials = socials;
    }
}
