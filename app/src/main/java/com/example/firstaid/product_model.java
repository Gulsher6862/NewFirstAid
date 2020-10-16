package com.example.firstaid;

public class product_model {

    String id, name, image, desc, price, cart_id, user_id, quantity;

    public product_model(String id, String name, String image, String desc, String price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.desc = desc;
        this.price = price;
    }

    public product_model(String id, String name, String image, String desc, String price,String quantity, String cart_id, String user_id) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.desc = desc;
        this.price = price;
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.quantity = quantity;
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

    public String getCart_id() {
        return cart_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getQuantity() {
        return quantity;
    }
}
