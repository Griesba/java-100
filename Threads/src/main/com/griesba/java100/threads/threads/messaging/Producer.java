package com.griesba.java100.threads.threads.messaging;

import java.util.Random;

public class Producer implements Runnable {

    private Message message;

    public Producer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {
                "1 - Individual and interactions over process and tools",
                "2 - Working software over comprehensive documentation",
                "3 - Customer collaboration over contract negotiation",
                "4 - Responding to change over following a plan"
        };
        Random random = new Random();
        for (int i = 0; i < messages.length; i++) {
            message.write(messages[1]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
        message.write("Finished !");
    }
}
