package com.griesba.java100.patterns.abstractmethod;

public class CreditCommand extends Command {
    public CreditCommand(double amount) {
        super(amount);
    }

    @Override
    public boolean valid() {
        return true;
    }

    @Override
    public void pay() {
        System.out.println("Le paiement de la commande au comptant de : " +
                amount + " est effectué.");
    }
}
