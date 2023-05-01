package com.griesba.java100.patterns.decorator.dontdothis;

public class VueMarqueVehicule extends VueModeleVehicule {
    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Logo de la marque");
    }
}
