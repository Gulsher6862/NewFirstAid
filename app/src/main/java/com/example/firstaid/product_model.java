package com.example.firstaid;

public class product_model {

    String id, name, image, desc, price;

    public product_model(String id, String name, String image, String desc, String price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.desc = desc;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDesc() {
        return desc;
    }

    public String getPrice() {
        return price;
    }
}
