package com.example.test.fragment.fragModel;

import java.security.PublicKey;

public class tripModel {
    public int modelImage;
    public String placeName,price,orderNumber;

    public tripModel() {
    }

    public tripModel(int modelImage, String placeName, String price, String orderNumber) {
        this.modelImage = modelImage;
        this.placeName = placeName;
        this.price = price;
        this.orderNumber = orderNumber;
    }

    public int getModelImage() {
        return modelImage;
    }

    public void setModelImage(int modelImage) {
        this.modelImage = modelImage;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
