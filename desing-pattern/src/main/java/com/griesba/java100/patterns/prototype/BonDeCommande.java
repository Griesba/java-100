package com.griesba.java100.patterns.prototype;

public class BonDeCommande extends Document {
    public void print() {
        System.out.println("Imprime le bon de commande : " + content);
    }

    public void show() {
        System.out.println("Affiche le bon de commande : " + content);
    }

}
