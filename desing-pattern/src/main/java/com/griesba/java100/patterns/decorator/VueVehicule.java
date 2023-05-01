package com.griesba.java100.patterns.decorator;

public class VueVehicule implements ComposantGraphiqueVehicule {
    @Override
    public void affiche() {
        System.out.println("Affichage du vehicule");
    }
}
