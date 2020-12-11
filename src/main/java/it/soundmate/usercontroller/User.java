package it.soundmate.usercontroller;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class User {

    private int userID;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private ArrayList<Image> photos;
    private Image profilePic;
    //video


    public User(int userID, String email, String firstName, String lastName, String password, List<Image> photos, Image profilePic) {
        this.userID = userID;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.photos = (ArrayList<Image>) photos;
        this.profilePic = profilePic;
    }

    public int getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public Image getProfilePic() {
        return profilePic;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Image> getPhotos() { return this.photos; }

    public void setProfilePic(Image profilePic) {
        this.profilePic = profilePic;
    }

    public void uploadPhotos(Image pic){
        this.photos.add(pic);
        //database upload
    }

}
