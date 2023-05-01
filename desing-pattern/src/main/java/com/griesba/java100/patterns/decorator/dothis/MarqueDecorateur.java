package com.griesba.java100.patterns.decorator.dothis;

import com.griesba.java100.patterns.decorator.ComposantGraphiqueVehicule;

public class MarqueDecorateur extends Decorateur {

    public MarqueDecorateur(ComposantGraphiqueVehicule composant) {
        super(composant);
    }

    protected void afficheLogo() {
        System.out.println("Logo de la marque");
    }

    public void affiche() {
        super.affiche();
        this.afficheLogo();
    }
}
