package com.griesba.java100.threads.producerConsumer.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

import static com.griesba.java100.threads.AppConstant.EOF;

public class BlockingQueueConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public BlockingQueueConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) { // synchronized in a synchronized data structure to prevent NPE like explained in UnsafeBlockingQueueConsumer
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + " Enf of file" + buffer.take());
                        break;
                    }
                    System.out.println(color + " consuming " + buffer.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
