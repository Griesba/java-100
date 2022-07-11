package com.griesba.java100.threads.threads.producerConsumer;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MyConsumerTryLock implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumerTryLock(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        int counter = 0; // count how many thread are waiting before we try to acquire the lock
        while (true) {
            if (bufferLock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(color + " The counter before we catch the lock" + counter);
                    counter = 0;
                    if (buffer.get(0).equals("EOF")) {
                        System.out.println(color + " Enf of file");
                        break;
                    }
                    System.out.println(color + " consuming " + buffer.remove(0));
                } finally {
                    bufferLock.unlock();
                }
            } else {
                counter++;
            }
        }
    }
}
