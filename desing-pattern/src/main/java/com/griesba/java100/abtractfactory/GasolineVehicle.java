package com.griesba.java100.abtractfactory;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
public class GasolineVehicle extends Automotive {
    public void printDetails() {
        System.out.println(super.toString());
    }
}
