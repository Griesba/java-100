package com.griesba.java100.patterns.prototype;

public class CertificatDeCession extends Document {
    @Override
    public void print() {
        System.out.println("Imprime de certificat de cession : " + content);
    }

    @Override
    public void show() {
        System.out.println("Affiche le certificat de cession : " + content);
    }
}
