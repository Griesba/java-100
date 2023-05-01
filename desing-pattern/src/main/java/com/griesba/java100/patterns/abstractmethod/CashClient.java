package com.griesba.java100.patterns.abstractmethod;

public class CashClient extends Client {
    @Override
    protected Command createCommand(double amount) {
        return new CashCommand(amount);
    }
}
