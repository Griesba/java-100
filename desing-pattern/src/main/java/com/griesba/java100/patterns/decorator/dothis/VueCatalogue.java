package com.griesba.java100.patterns.decorator.dothis;

import com.griesba.java100.patterns.decorator.VueVehicule;

public class VueCatalogue {

    public static void main(String[] args) {
        VueVehicule vueVehicule = new VueVehicule();
        ModeleDecorateur modeleDecorateur = new ModeleDecorateur(vueVehicule);
        MarqueDecorateur marqueDecorateur = new MarqueDecorateur(modeleDecorateur);
        marqueDecorateur.affiche();
    }
}
