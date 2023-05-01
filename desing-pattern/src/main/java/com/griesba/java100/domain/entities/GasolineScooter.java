package com.griesba.java100.domain.entities;

import com.griesba.java100.domain.entities.Scooter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString
@SuperBuilder
public class GasolineScooter extends Scooter {
    public void printDetails() {
        System.out.println(super.toString());
    }
}
