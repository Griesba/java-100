package com.griesba.java100.patterns.prototype;

public class Main {
    public static void main(String[] args) {
        LiasseVierge liasseVierge = LiasseVierge.getInstance();
        liasseVierge.add(new BonDeCommande());
        liasseVierge.add(new CertificatDeCession());
        liasseVierge.add(new DemandeImmatriculation());

        LiasseClient liasseClient1 = new LiasseClient("Martin");
        LiasseClient liasseClient2 = new LiasseClient("Durant");
        liasseClient1.showDocument();
        liasseClient2.showDocument();
    }
}
