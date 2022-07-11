package com.griesba.java100.threads.threads.producerConsumer.blockingQueue;

import com.griesba.java100.threads.threads.ThreadColors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainWithBlockingQueue {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(6);
        ExecutorService executorService = Executors.newFixedThreadPool(4);

       BlockingQueueProducer producer = new BlockingQueueProducer(arrayBlockingQueue, ThreadColors.ANSI_CYAN);
       UnsafeBlockingQueueConsumer consumerOne = new UnsafeBlockingQueueConsumer(arrayBlockingQueue, ThreadColors.ANSI_BLUE);
       UnsafeBlockingQueueConsumer consumerTwo = new UnsafeBlockingQueueConsumer(arrayBlockingQueue, ThreadColors.ANSI_PURPLE);
       BlockingQueueConsumer consumerThree = new BlockingQueueConsumer(arrayBlockingQueue, ThreadColors.ANSI_GREEN);

        executorService.execute(producer);
        executorService.execute(consumerOne); // NPE prone use BlockQueueConsumer instead
        executorService.execute(consumerTwo); // NPE prone use BlockQueueConsumer instead


        executorService.shutdown();
    }
}
