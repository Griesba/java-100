package com.griesba.java100.domain.entities;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString
@SuperBuilder
public class ElectricalScooter extends Scooter {
    public void printDetails() {
        System.out.println(super.toString());
    }
}
