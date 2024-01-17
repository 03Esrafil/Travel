package com.example.test.Mainmodel;

public class datamodel {
   public int image ;
  public   String header, desc,price;

    public datamodel(int image, String header, String desc,String price) {
        this.image = image;
        this.header = header;
        this.desc = desc;
        this.price=price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }


}
