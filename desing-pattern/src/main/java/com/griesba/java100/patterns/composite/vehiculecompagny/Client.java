package com.griesba.java100.patterns.composite.vehiculecompagny;

public class Client {
    public static void main(String[] args) {
        Company carTravelCompany = new MainCompany();
        Company carGreen = new NonSubsidiaryCompany();
        carGreen.addVehicle();
        carGreen.addVehicle();

        Company westCar = new MainCompany();
        westCar.addVehicle();
        westCar.addVehicle();

        Company southCar = new NonSubsidiaryCompany();
        southCar.addVehicle();
        westCar.addSubsidiaryCompany(southCar);

        carTravelCompany.addSubsidiaryCompany(carGreen);
        carTravelCompany.addSubsidiaryCompany(westCar);

        System.out.println("Total cost of maintenance : " + carTravelCompany.computePriceMaintenance());

    }
}
