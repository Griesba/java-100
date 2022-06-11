package com.griesba.java100.threads.producerConsumer;

import com.griesba.java100.threads.ThreadColors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.griesba.java100.threads.producerConsumer.MainClass.EOF;

public class MainClassThreadSafe {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        MyProducerThreadSafe producer = new MyProducerThreadSafe(buffer, ThreadColors.ANSI_PURPLE);
        MyConsumerThreadSafe consumer = new MyConsumerThreadSafe(buffer, ThreadColors.ANSI_GREEN);
        MyConsumerThreadSafe consumer1 = new MyConsumerThreadSafe(buffer, ThreadColors.ANSI_BLUE);
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer1).start();
    }
}


class MyProducerThreadSafe implements Runnable {

    private List<String> buffer;
    private String color;

    public MyProducerThreadSafe(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for(String num : nums) {
            try {
                System.out.println(color + "Adding ..." + num);
                synchronized (buffer) { // prevent producer  suspension
                    buffer.add(num);
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting ...");
        synchronized (buffer) {
            buffer.add("EOF");
        }
    }
}

class MyConsumerThreadSafe implements Runnable {
    private List<String> buffer;
    private String color;

    public MyConsumerThreadSafe(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals(EOF)) {
                    System.out.println(color + "Exiting");
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            }
        }
    }
}
