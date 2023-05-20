package com.griesba.java100.patterns.prototype;

public class DemandeImmatriculation extends Document {
    public void show() {
        System.out.println("Affiche la demande d'immatriculation : " + content);
    }

    public void print() {
        System.out.println("Imprime la demande d'immatriculation : " + content);
    }
}
