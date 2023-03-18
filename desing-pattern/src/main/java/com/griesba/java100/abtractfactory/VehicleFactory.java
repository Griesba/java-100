package com.griesba.java100.abtractfactory;

public interface VehicleFactory {
    Automotive createAutomotive(String color, String model, int power, double space) ;

    Scooter createScooter(String color, String model, int power) ;
}
