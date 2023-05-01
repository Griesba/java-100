package com.griesba.java100.abtractfactory;

import com.griesba.java100.domain.entities.Automotive;
import com.griesba.java100.domain.entities.GasolineScooter;
import com.griesba.java100.domain.entities.GasolineVehicle;
import com.griesba.java100.domain.entities.Scooter;

public class GasolineVehicleFactory implements VehicleFactory{
    public Automotive createAutomotive(String color, String model, int power, double space) {
        return GasolineVehicle.builder().color(color).model(model).power(power).space(space).build();
    }

    public Scooter createScooter(String color, String model, int power) {
        return GasolineScooter.builder().color(color).model(model).power(power).build();
    }
}
