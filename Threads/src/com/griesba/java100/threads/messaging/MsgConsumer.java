package com.griesba.java100.threads.messaging;

import java.util.Random;

public class MsgConsumer implements Runnable {

    private Message message;

    public MsgConsumer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for(String latestMessage = this.message.read(); latestMessage.equals("Finished !"); latestMessage = this.message.read()){
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
    }
}
