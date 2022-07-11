package com.griesba.java100.threads.threads.producerConsumer;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class NewMyProducerReentrantLock implements Runnable{

    private List<String> buffer;
    private ReentrantLock bufferLock;
    private String color;

    public NewMyProducerReentrantLock(List<String> buffer, ReentrantLock bufferLock, String color) {
        this.buffer = buffer;
        this.bufferLock = bufferLock;
        this.color = color;
    }

    @Override
    public void run() {
        String[] inputs = {"Paris", "Helsinki", "Chisino", "Lisbone", "Amsterdam"};

        for (String city : inputs) {
            System.out.println(color + "Adding " + city);
            try {
                bufferLock.lock();
                buffer.add(city);
            }finally {
                bufferLock.unlock();
            }
        }
        System.out.println(color + "Adding EOF and exiting ...");
        try {
            bufferLock.lock();
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }
}
