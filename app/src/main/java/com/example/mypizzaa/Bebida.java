package com.example.mypizzaa;

import android.os.Parcel;
import android.os.Parcelable;

public class Bebida implements Parcelable {
    private String name;
    private double price;

    public Bebida(String name, double price) {
        this.name = name;
        this.price = price;
    }

    protected Bebida(Parcel in) {
        name = in.readString();
        price = in.readDouble();
    }

    public static final Creator<Bebida> CREATOR = new Creator<Bebida>() {
        @Override
        public Bebida createFromParcel(Parcel in) {
            return new Bebida(in);
        }

        @Override
        public Bebida[] newArray(int size) {
            return new Bebida[size];
        }
    };

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(price);
    }
}
