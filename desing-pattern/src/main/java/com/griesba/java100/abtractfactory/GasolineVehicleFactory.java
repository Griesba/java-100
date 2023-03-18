package com.griesba.java100.abtractfactory;

public class GasolineVehicleFactory implements VehicleFactory{
    public Automotive createAutomotive(String color, String model, int power, double space) {
        return GasolineVehicle.builder().color(color).model(model).power(power).space(space).build();
    }

    public Scooter createScooter(String color, String model, int power) {
        return GasolineScooter.builder().color(color).model(model).power(power).build();
    }
}
