package com.griesba.java100.patterns.proxy;

public class Film implements Animation {
    @Override
    public void draw() {
        System.out.println("Affichage du film");
    }

    @Override
    public void click() {
    }

    public void charge()
    {
        System.out.println("Chargement du film");
    }

    public void joue()
    {
        System.out.println("Lecture du film");
    }
}
