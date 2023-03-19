package com.griesba.java100.builder.vehiclebundle;

public abstract class BundleVehicleBuilder {
    protected Bundle bundle;

    public abstract void buildPurchaseOrder(String clientName);

    public abstract void buildRegistrationOrder(String applicantName);

    public Bundle result() {
        return bundle;
    }
}
