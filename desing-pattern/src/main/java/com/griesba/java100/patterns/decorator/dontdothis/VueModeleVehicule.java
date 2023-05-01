package com.griesba.java100.patterns.decorator.dontdothis;

import com.griesba.java100.patterns.decorator.VueVehicule;

public class VueModeleVehicule extends VueVehicule {
    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Information technique du modele");
    }
}
