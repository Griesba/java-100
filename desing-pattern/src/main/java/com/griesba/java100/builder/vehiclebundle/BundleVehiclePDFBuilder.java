package com.griesba.java100.builder.vehiclebundle;

public class BundleVehiclePDFBuilder extends BundleVehicleBuilder {
    public BundleVehiclePDFBuilder() {
        bundle = new BundlePdf();
    }

    @Override
    public void buildPurchaseOrder(String clientName) {
        String document;
        document = "<PDF>Bon de commande Client : " +
                clientName + "</PDF>";
        bundle.addDocument(document);
    }

    @Override
    public void buildRegistrationOrder(String applicantName) {
        String document;
        document =
                "<PDF>Demande d'immatriculation Demandeur : " +
                        applicantName + "</PDF>";
        bundle.addDocument(document);
    }
}
