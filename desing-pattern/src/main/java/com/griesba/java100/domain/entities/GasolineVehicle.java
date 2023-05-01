package com.griesba.java100.domain.entities;

import com.griesba.java100.domain.entities.Automotive;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
public class GasolineVehicle extends Automotive {
    public void printDetails() {
        System.out.println(super.toString());
    }
}
