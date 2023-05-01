package com.griesba.java100.patterns.abstractmethod;

public class CreditClient extends Client {
    @Override
    protected Command createCommand(double amount) {
        return new CreditCommand(amount);
    }
}
