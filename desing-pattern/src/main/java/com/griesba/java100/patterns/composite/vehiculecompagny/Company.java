package com.griesba.java100.patterns.composite.vehiculecompagny;

public abstract class Company {
    protected static double unitPriceVehicle = 5.0;
    protected int nbrVehicle;

    public void addVehicle() {
        nbrVehicle++;
    }

    public abstract double computePriceMaintenance();

    public abstract boolean addSubsidiaryCompany(Company subsidiary);
}
