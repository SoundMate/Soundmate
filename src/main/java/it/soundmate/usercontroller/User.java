package it.soundmate.usercontroller;

import java.awt.*;

public class User {

    private int userID;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    //private Image[] photos;
    private Image profilePic;
    //video


    public User(int userID, String email, String firstName, String lastName, String password, Image[] photos, Image profilePic) {
        this.userID = userID;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        //this.photos = photos;
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

//    public Image[] getPhotos() {
//        return photos;
//    }

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

//    public void setPhotos(Image[] photos) {
//        this.photos = photos;
//    }

    public void setProfilePic(Image profilePic) {
        this.profilePic = profilePic;
    }
}
