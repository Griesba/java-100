package com.griesba.java100.threads.threads.producerConsumer.blockingQueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueProducer implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;

    public BlockingQueueProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {

        String[] inputs = {"Paris", "Helsinki", "Chisino", "Lisbone", "Amsterdam", "Minks"};
        Random random = new Random();
        for (String city : inputs) {
            System.out.println(color + "Adding " + city);
            try {
                buffer.put(city);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(color + "Adding EOF and exiting ...");
        try {
            buffer.put("EOF"); // add throw exception but put will block when no space left
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
