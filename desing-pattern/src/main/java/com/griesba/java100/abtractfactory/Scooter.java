package com.griesba.java100.abtractfactory;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString
@SuperBuilder
@AllArgsConstructor
public abstract class Scooter {
    protected int power;
    protected String model;
    protected String color;

    public abstract void printDetails();
}
