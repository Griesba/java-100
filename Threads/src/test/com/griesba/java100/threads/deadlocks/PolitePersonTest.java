package com.griesba.java100.threads.deadlocks;


import org.junit.jupiter.api.Test;

public class PolitePersonTest {

    @Test
    public void shouldSayHelloAndHelloBack() {
        PolitePerson jane = new PolitePerson("jana");
        PolitePerson john = new PolitePerson("john");

        jane.sayHello(john);
        john.sayHello(jane);
    }

    @Test
    public void shouldSayHelloAndDeadlock() {
        PolitePerson jane = new PolitePerson("jana");
        PolitePerson john = new PolitePerson("john");
        // this is deadlock prone as in most case the thread won't run the sayHelloBack method
        // because it is suspended by the other thread
        new Thread(() -> jane.sayHello(john)).start();

        new Thread(() -> john.sayHello(jane)).start();
    }

}