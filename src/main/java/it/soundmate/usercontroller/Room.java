package it.soundmate.usercontroller;

public class Room {

    private int number;
    private Double price;
    private String description;

    public Room(int number, Double price, String description) {
        this.number = number;
        this.price = price;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
