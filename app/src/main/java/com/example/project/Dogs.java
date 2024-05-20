package com.example.networking;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Dogs {

    public String ID;
    @SerializedName("name")
    public String name;


    @SerializedName("location")
    public String location;

    @SerializedName("size")

    public String size;
    @SerializedName("cost")

    public String cost;
    public Dogs() {
        name = "Breed name:";
        location = "Originated:";
        size = "Aprox weight:";
        cost = "Aprox cost:";
    }

    public Dogs(String name) {
        this.name = name;
        this.cost = cost;
        this.location = location;
        this.size = size;
    }

    @NonNull
    @Override
    public String toString() {
        return "Name: " + name + ", Location: " + location + ", Size: " + size + ", Cost: " + cost;
    }

    public String getTitle() {
        return "Name: " + name + ", Location: " + location + ", Size: " + size + ", Cost: " + cost;


    }

}