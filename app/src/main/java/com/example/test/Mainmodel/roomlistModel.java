package com.example.test.Mainmodel;

public class roomlistModel {
    public int roomtImage ;
    public   String hotelName, location,roomNumeber,roomprice;

    public roomlistModel(int roomtImage, String hotelName, String location, String roomNumeber, String roomprice) {
        this.roomtImage = roomtImage;
        this.hotelName = hotelName;
        this.location = location;
        this.roomNumeber = roomNumeber;
        this.roomprice = roomprice;
    }

    public int getRoomtImage() {
        return roomtImage;
    }

    public void setRoomtImage(int roomtImage) {
        this.roomtImage = roomtImage;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRoomNumeber() {
        return roomNumeber;
    }

    public void setRoomNumeber(String roomNumeber) {
        this.roomNumeber = roomNumeber;
    }

    public String getRoomprice() {
        return roomprice;
    }

    public void setRoomprice(String roomprice) {
        this.roomprice = roomprice;
    }
}
