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

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public void addGenres(String genre){
        this.genres.add(genre);
    }

    public ArrayList<Solo> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Solo> members) {
        this.members = members;
    }

    public void addMember(Solo member){
        this.members.add(member);
    }

    public ArrayList<String> getSocials() {
        return socials;
    }

    public void addSocial(String socialLink){
        this.socials.add(socialLink);
    }

    public void setSocials(ArrayList<String> socials) {
        this.socials = socials;
    }
}
