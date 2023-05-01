package com.griesba.java100.patterns.decorator.dothis;

import com.griesba.java100.patterns.decorator.ComposantGraphiqueVehicule;

public class ModeleDecorateur extends Decorateur {
    public ModeleDecorateur(ComposantGraphiqueVehicule composant) {
        super(composant);
    }

    protected void afficheInfosTechniques() {
        System.out.println("Information techniques du modele");
    }

    public void affiche() {
        super.affiche();
        this.afficheInfosTechniques();
    }
}
