/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 12/12/20, 14:38
 */

package it.soundmate.model;

import java.util.ArrayList;
import java.util.List;

public class Solo extends User {

    private ArrayList<String> favouriteGenres;
    private int age;
    private String instrument;
    private ArrayList<Band> bands;


    public Solo(User user) {
        super(user.getUserID(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getProfilePic(), UserType.SOLO);
    }

    public Solo(User user, List<String> favouriteGenres, int age, String instrument, List<Band> bands) {
        this(user);
        this.favouriteGenres = (ArrayList<String>) favouriteGenres;
        this.age = age;
        this.instrument = instrument;
        this.bands = (ArrayList<Band>) bands;
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

    public List<String> getFavouriteGenres() {
        return favouriteGenres;
    }

    public void setFavouriteGenres(List<String> favouriteGenres) {
        this.favouriteGenres = (ArrayList<String>) favouriteGenres;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

}
