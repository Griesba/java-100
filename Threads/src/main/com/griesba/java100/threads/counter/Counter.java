package com.griesba.java100.threads.counter;

import com.griesba.java100.threads.ThreadColors;

public class Counter {

    public static void main(String[] args) {

        CountDown countDown = new CountDown(30);
        CountDownThread cdt1 = new CountDownThread(countDown);
        cdt1.setName("Thread 1");
        CountDownThread cdt2 = new CountDownThread(countDown);
        cdt2.setName("Thread 2");
        CountDownThread cdt3 = new CountDownThread(countDown);
        cdt3.setName("Thread 3");

        cdt1.start();
        cdt2.start();
        cdt3.start();
    }
}

class CountDown {
    private int i;
    public Object lock = new Object();

    public CountDown(int i) {
        this.i = i;
    }

    public  void countDown() {
        String color;
        switch (Thread.currentThread().getName()) {
            case "Thread 1" :
                color = ThreadColors.ANSI_PURPLE;
                break;
            case "Thread 2" :
                color = ThreadColors.ANSI_BLUE;
                break;
            case "Thread 3" :
                color = ThreadColors.ANSI_CYAN;
                break;
            default:
                color = ThreadColors.ANSI_GREEN;
        }

        while (i > 0) {
            System.out.println(color + Thread.currentThread().getName() + " : i = " + i);
            i--;
        }
    }
}

class CountDownThread extends Thread {
    private CountDown counter;

    public CountDownThread(CountDown counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
       this.counter.countDown();
    }
}

