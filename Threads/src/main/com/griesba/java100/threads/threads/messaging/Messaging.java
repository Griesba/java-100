package com.griesba.java100.threads.threads.messaging;

public class Messaging {
    public static void main(String[] args) {
        Message message = new Message();
        new Thread(new Producer(message)).start();
        new Thread(new MsgConsumer(message)).start();
    }
}
