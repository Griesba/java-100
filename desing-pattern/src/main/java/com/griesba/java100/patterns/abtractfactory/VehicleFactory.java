package com.griesba.java100.patterns.abtractfactory;

import com.griesba.java100.domain.entities.Automotive;
import com.griesba.java100.domain.entities.Scooter;

public interface VehicleFactory {
    Automotive createAutomotive(String color, String model, int power, double space) ;

    Scooter createScooter(String color, String model, int power) ;
}
