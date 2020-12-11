package it.soundmate.usercontroller;

import java.util.ArrayList;
import java.util.List;

public class Band extends User{

    private ArrayList<String> genres;
    private ArrayList<Solo> members;
    private ArrayList<String> socials;
    //private Song songPreviews;

    public Band(User user) {
        super(user.getUserID(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getPhotos(), user.getProfilePic());
    }

    public Band(User user, List<String> genres, List<String> socials, List<Solo> members) {
        this(user);
        this.genres = (ArrayList<String>) genres;
        this.socials = (ArrayList<String>) socials;
        this.members = (ArrayList<Solo>) members;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = (ArrayList<String>) genres;
    }

    public List<Solo> getMembers() {
        return members;
    }

    public void setMembers(List<Solo> members) {
        this.members = (ArrayList<Solo>) members;
    }

    public List<String> getSocials() {
        return socials;
    }

    public void setSocials(List<String> socials) {
        this.socials = (ArrayList<String>) socials;
    }

}
