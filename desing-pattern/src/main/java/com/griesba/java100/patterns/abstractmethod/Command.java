package com.griesba.java100.patterns.abstractmethod;

public abstract class Command {
    protected double amount;

    public Command(double amount) {
        this.amount = amount;
    }

    public abstract boolean valid();
    public abstract void pay();
}
