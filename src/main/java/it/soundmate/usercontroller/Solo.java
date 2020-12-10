package it.soundmate.usercontroller;

import java.awt.*;
import java.util.ArrayList;

public class Solo extends User{

    private ArrayList<String> favouriteGenres;
    private int age;
    private String instrument;
    private ArrayList<Band> bands;


    public Solo(int userID, String email, String firstName, String lastName, String password, Image[] photos, Image profilePic) {
        super(userID, email, firstName, lastName, password, photos, profilePic);
    }

    public Solo(int userID, String email, String firstName, String lastName, String password, Image[] photos,
                Image profilePic, ArrayList<String> favouriteGenres, int age, String instrument, ArrayList<Band> bands) {
        super(userID, email, firstName, lastName, password, photos, profilePic);
        this.favouriteGenres = favouriteGenres;
        this.age = age;
        this.instrument = instrument;
        this.bands = bands;
    }

    public void joinBand(Band band){
        this.bands.add(band);
    }
    public void leaveBand(Band band) {
        for (int i = 0; i < this.bands.size(); i++) {
            if (band.equals(this.bands.get(i))) {
                this.bands.remove(i);
                break;
            }
        }
    }

}
