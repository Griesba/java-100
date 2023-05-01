package com.griesba.java100.abtractfactory;

import com.griesba.java100.domain.entities.Automotive;
import com.griesba.java100.domain.entities.ElectricalCar;
import com.griesba.java100.domain.entities.ElectricalScooter;
import com.griesba.java100.domain.entities.Scooter;

public class ElectricalVehicleFactory implements VehicleFactory {
    public Automotive createAutomotive(String color, String model, int power, double space) {
        return ElectricalCar.builder().color(color).model(model).power(power).space(space).build();
    }

    public Scooter createScooter(String color, String model, int power) {
        return ElectricalScooter.builder().color(color).model(model).power(power).build();
    }
}
