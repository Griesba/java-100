package com.leretvil;

import com.google.gson.GsonBuilder;

public class Coordonnees {
    private String x;
    private String y;

    public Coordonnees(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this, Coordonnees.class);
    }
}
