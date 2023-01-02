package com.griesba.bank.domain;

public class Client {
    private String id;
    private String firstName;
    private String lastName;

    public Client(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }
}
