package com.griesba.java100.threads.producerConsumer.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

import static com.griesba.java100.threads.AppConstant.EOF;

public class UnsafeBlockingQueueConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public UnsafeBlockingQueueConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
                try {
                    /* this implementation is unsafe.
                    * a thread t1 can be suspended just after running buffer.isEmpty() instruction
                    * the following thread will run it, pass throw and remove the last element of the array
                    * when the thread t1 will wake up, the array will be empty,
                    *  it will try to take an element from and an NPE will be thrown
                     */
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
