package com.griesba.java100.threads.producerConsumer;

import com.griesba.java100.threads.AppConstant;
import com.griesba.java100.threads.ThreadColors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainClass {


    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        MyProducer producer = new MyProducer(buffer, ThreadColors.ANSI_PURPLE);
        MyConsumer consumer = new MyConsumer(buffer, ThreadColors.ANSI_GREEN);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColors.ANSI_BLUE);
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer1).start();
    }
}


class MyProducer implements Runnable {

    private List<String> buffer;
    private String color;

    public MyProducer(List<String> buffer, String color) {
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
                // as ArrayList is not thread safe, the producer can sleep
                buffer.add(num);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting ...");
        buffer.add("EOF");
    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        System.out.println(color + "hello");
        while (true) {
            if (buffer.isEmpty()) {
                continue;
            }
            if (buffer.get(0).equals(AppConstant.EOF)) {
                System.out.println(color + "Exiting");
                break;
            } else {
                System.out.println(color + "Removed " + buffer.remove(0));
            }
        }
    }
}
