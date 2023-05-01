package com.griesba.java100.patterns.abstractmethod;

public class TestingClass {
    public static void main(String[] args) {
        Client client;
        client = new CashClient();
        client.newCommand(2000d);
        client.newCommand(10000d);
        client = new CreditClient();
        client.newCommand(2000d);
        client.newCommand(10000d);
    }
}
