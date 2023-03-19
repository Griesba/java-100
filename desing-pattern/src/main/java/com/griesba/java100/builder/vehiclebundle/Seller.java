package com.griesba.java100.builder.vehiclebundle;

public class Seller {

    protected BundleVehicleBuilder builder;

    public Seller(BundleVehicleBuilder builder) {
        this.builder = builder;
    }

    public Bundle build(String clientName) {
        builder.buildPurchaseOrder(clientName);
        builder.buildRegistrationOrder(clientName);
        return builder.result();
    }
}
