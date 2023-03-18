package com.griesba.java100.composite.vehiculecompagny;

import java.util.ArrayList;
import java.util.List;

public class MainCompany extends Company {

    protected List<Company> subsidiaries = new ArrayList<>();

    @Override
    public double computePriceMaintenance() {
        double price = 0.0;
        for (Company company : subsidiaries) {
            price += company.computePriceMaintenance();
        }
        return price + unitPriceVehicle * nbrVehicle;
    }

    @Override
    public boolean addSubsidiaryCompany(Company subsidiary) {
        return subsidiaries.add(subsidiary);
    }
}
