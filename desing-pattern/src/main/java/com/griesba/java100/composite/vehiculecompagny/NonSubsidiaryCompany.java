package com.griesba.java100.composite.vehiculecompagny;

public class NonSubsidiaryCompany extends Company {
    @Override
    public double computePriceMaintenance() {
        return nbrVehicle * unitPriceVehicle;
    }

    @Override
    public boolean addSubsidiaryCompany(Company subsidiary) {
        return false;
    }
}
