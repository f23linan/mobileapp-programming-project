package com.example.networking;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Dogs {

    public String ID;
    @SerializedName("name")
    public String name;

    public String location;
    public String size;
    public String cost;
    public Dogs() {
        name = "Breed name:";
        location = "Originated:";
        size = "Aprox weight:";
        cost = "Aprox cost:";
    }

    public Dogs(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
        return location;
        return size;
        return cost;
    }

    public String getTitle() {
        return name;
        return location;
        return size;
        return cost;
    }

}