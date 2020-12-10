package it.soundmate.usercontroller;

import java.awt.*;

public class RoomRenter extends User{

    private Room[] rooms;
    private String address;




    public RoomRenter(int userID, String email, String firstName, String lastName, String password, Image[] photos, Image profilePic) {
        super(userID, email, firstName, lastName, password, photos, profilePic);
    }
}
