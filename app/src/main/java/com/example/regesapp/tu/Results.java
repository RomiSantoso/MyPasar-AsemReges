package com.example.regesapp.tu;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("tu")
    private String tu;


    public Results(String name) {
        this.tu = name;
    }

    public String getName() {
        return tu;
    }
}