package it.soundmate.usercontroller;

import java.awt.*;
import java.util.ArrayList;

public class RoomRenter extends User{

    private ArrayList<Room> rooms;
    private String address;


    public RoomRenter(User user) {
        super(user.getUserID(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getPhotos(), user.getProfilePic());
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addRoom(Room room){
        this.rooms.add(room);
    }
    public void removeRoom(Room room){
        for (int i = 0; i < this.rooms.size(); i++) {
            if (room.equals(this.rooms.get(i))) {
                this.rooms.remove(i);
                break;
            }
        }
    }


}
