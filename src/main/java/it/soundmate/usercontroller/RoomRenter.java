package it.soundmate.usercontroller;

import java.awt.*;
import java.util.ArrayList;

public class RoomRenter extends User{

    private ArrayList<Room> rooms;
    private String address;


    public RoomRenter(int userID, String email, String firstName, String lastName, String password, Image[] photos, Image profilePic) {
        super(userID, email, firstName, lastName, password, photos, profilePic);
    }

    public void addRoom(Room room){

    }


}
