package com.griesba.java100.patterns.abstractmethod;

public class CashCommand extends Command {
    public CashCommand(double amount) {
        super(amount);
    }

    @Override
    public boolean valid() {
        return amount >= 1000d && amount <= 5000d;
    }

    @Override
    public void pay() {
        System.out.println("Le paiement de la commande au credit de : " +
                amount + " est effectue.");
    }
}
