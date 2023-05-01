package com.griesba.java100.patterns.builder.vehiclebundle;

public class BundleVehicleHTMLBuilder extends BundleVehicleBuilder {

    public BundleVehicleHTMLBuilder() {
        bundle = new BundleHtml();
    }

    @Override
    public void buildPurchaseOrder(String clientName) {
        String document;
        document = "<HTML>Bon de commande Client : " +
                clientName + "</HTML>";
        bundle.addDocument(document);
    }

    @Override
    public void buildRegistrationOrder(String applicantName) {
        String document;
        document =
                "<HTML>Demande d'immatriculation Demandeur : " +
                        applicantName + "</HTML>";
        bundle.addDocument(document);
    }
}
