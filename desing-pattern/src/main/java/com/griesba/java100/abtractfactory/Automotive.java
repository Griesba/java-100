package com.griesba.java100.abtractfactory;


import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@ToString
@AllArgsConstructor
@SuperBuilder
public abstract class Automotive {
    protected int power;
    protected double space;
    protected String model;
    protected String color;

    public abstract void printDetails();
}
