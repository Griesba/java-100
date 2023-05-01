package com.griesba.java100.patterns.decorator.dothis;

import com.griesba.java100.patterns.decorator.ComposantGraphiqueVehicule;

public abstract class Decorateur implements ComposantGraphiqueVehicule {

    protected ComposantGraphiqueVehicule composant;

    public Decorateur(ComposantGraphiqueVehicule composant) {
        this.composant = composant;
    }

    @Override
    public void affiche() {
        this.composant.affiche();
    }
}
