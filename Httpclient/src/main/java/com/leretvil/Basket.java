package com.leretvil;

import com.google.gson.GsonBuilder;

import java.io.Serializable;

public class Basket implements Serializable {

    private String test;

    public Basket(String test) {
        this.test = test;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this, Basket.class);
    }
}
