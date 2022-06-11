package com.griesba.java100.threads.producerConsumer;

import com.griesba.java100.threads.ThreadColors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class MainClassReentrantLock {

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock reentrantLock = new ReentrantLock();
        MyProducerReentrantLock producer = new MyProducerReentrantLock(buffer, ThreadColors.ANSI_BLUE, reentrantLock);
        MyConsumerReentrantLock consumer1 = new MyConsumerReentrantLock(buffer, ThreadColors.ANSI_GREEN, reentrantLock);
        MyConsumerReentrantLock consumer2 = new MyConsumerReentrantLock(buffer, ThreadColors.ANSI_CYAN, reentrantLock);
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProducerReentrantLock implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducerReentrantLock(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums) {
            try {
                System.out.println(color + "Adding " + num);
                bufferLock.lock();
                buffer.add(num);
                bufferLock.unlock();
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(color + "Adding EOF and exiting ...");
        bufferLock.lock();
        buffer.add("EOF");
        bufferLock.unlock();
    }
}

class MyConsumerReentrantLock implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumerReentrantLock(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        // Le piège ici c'est de ne pas faire attention aux close "continue" et break
        // si on met le lock au debut et à la fin de la boucle while, le reentrant lock va se bloquer
        // car dans le cas ou on fait continue, le lock n'est pas débloqué puisqu'on n'atteint jamais cette partie là.
        while (true) {
            bufferLock.lock();
            if (buffer.isEmpty()) {
                bufferLock.unlock();
                continue;
            }
            if ("EOF".equals(buffer.get(0))) {
                System.out.println("EOF");
                bufferLock.unlock();
                break;
            }
            System.out.println(color + " Consuming " + buffer.remove(0));
            bufferLock.unlock();
        }
    }
}
