package com.example.firstaid;

import android.os.Parcel;
import android.os.Parcelable;

public class product_model implements Parcelable {

    String id, name, image, desc, price, cart_id, user_id, quantity, total_prize;

    public product_model(String id, String name, String image, String desc, String price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.desc = desc;
        this.price = price;
    }

    public product_model(String id, String name, String image, String desc, String price,String quantity,String total_prize, String cart_id, String user_id) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.desc = desc;
        this.price = price;
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.quantity = quantity;
        this.total_prize = total_prize;
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

    public String getTotal_prize() {
        return total_prize;
    }

    protected product_model(Parcel in) {
        id = in.readString();
        name = in.readString();
        image = in.readString();
        desc = in.readString();
        price = in.readString();
        cart_id = in.readString();
        user_id = in.readString();
        quantity = in.readString();
        total_prize = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(image);
        dest.writeString(desc);
        dest.writeString(price);
        dest.writeString(cart_id);
        dest.writeString(user_id);
        dest.writeString(quantity);
        dest.writeString(total_prize);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<product_model> CREATOR = new Parcelable.Creator<product_model>() {
        @Override
        public product_model createFromParcel(Parcel in) {
            return new product_model(in);
        }

        @Override
        public product_model[] newArray(int size) {
            return new product_model[size];
        }
    };
}