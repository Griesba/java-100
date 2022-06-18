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

        String typeOfDebug = "default";
        switch (typeOfDebug) {
            case "default":
                MyProducerReentrantLock producer = new MyProducerReentrantLock(buffer, ThreadColors.ANSI_BLUE, reentrantLock);
                MyConsumerReentrantLock consumer1 = new MyConsumerReentrantLock(buffer, ThreadColors.ANSI_GREEN, reentrantLock);
                MyConsumerReentrantLock consumer2 = new MyConsumerReentrantLock(buffer, ThreadColors.ANSI_CYAN, reentrantLock);
                new Thread(producer).start();
                new Thread(consumer1).start();
                new Thread(consumer2).start();
                break;
            case "tryFinally":
                System.out.println(ThreadColors.ANSI_RED + " New section start with try finally reentrant lock.");

                NewMyProducerReentrantLock producerWithTryFinally = new NewMyProducerReentrantLock(buffer, reentrantLock, ThreadColors.ANSI_BLUE);
                MyBetterConsumerReentrantLock consumer1WithTryFinally = new MyBetterConsumerReentrantLock(buffer, ThreadColors.ANSI_GREEN, reentrantLock);
                MyBetterConsumerReentrantLock consumer2WithTryFinally = new MyBetterConsumerReentrantLock(buffer, ThreadColors.ANSI_CYAN, reentrantLock);
                new Thread(producerWithTryFinally).start();
                new Thread(consumer1WithTryFinally).start();
                new Thread(consumer2WithTryFinally).start();
                break;
            case "tryLock":
                System.out.println(ThreadColors.ANSI_RED + " New section with REENTRANT TRY LOCK.");

                NewMyProducerReentrantLock producerWithTryFinally2 = new NewMyProducerReentrantLock(buffer, reentrantLock, ThreadColors.ANSI_BLUE);
                MyConsumerTryLock consumer1WithTryLock = new MyConsumerTryLock(buffer, ThreadColors.ANSI_GREEN, reentrantLock);
                MyConsumerTryLock consumer2WithTryLock = new MyConsumerTryLock(buffer, ThreadColors.ANSI_CYAN, reentrantLock);
                new Thread(producerWithTryFinally2).start();
                new Thread(consumer1WithTryLock).start();
                new Thread(consumer2WithTryLock).start();
                break;
        }
    }
}

class NewMyProducerReentrantLock implements Runnable {
    private List<String> buffer;
    private ReentrantLock bufferLock;
    private String color;

    public NewMyProducerReentrantLock(List<String> buffer, ReentrantLock bufferLock, String color) {
        this.buffer = buffer;
        this.bufferLock = bufferLock;
        this.color = color;
    }

    @Override
    public void run() {
        String[] inputs = {"Paris", "Helsinki", "Cisino", "Lisbone", "Amsterdam"};

        for (String city : inputs) {
            System.out.println(color + "Adding " + city);
            try {
                bufferLock.lock();
                buffer.add(city);
            }finally {
                bufferLock.unlock();
            }
        }
        System.out.println(color + "Adding EOF and exiting ...");
        try {
            bufferLock.lock();
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
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

class MyBetterConsumerReentrantLock implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyBetterConsumerReentrantLock(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        while (true) {
            try {
                bufferLock.lock();
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals("EOF")) {
                    System.out.println(color + " Enf of file");
                    break;
                }
                System.out.println(color + " consuming " + buffer.get(0));

            } finally {
                bufferLock.unlock();
            }

        }

    }
}

class MyConsumerTryLock implements Runnable {
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
                    System.out.println(color + " consuming " + buffer.get(0));
                } finally {
                    bufferLock.unlock();
                }
            } else {
                counter++;
            }
        }
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
