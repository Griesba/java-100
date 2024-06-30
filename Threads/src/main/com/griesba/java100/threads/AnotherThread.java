package com.griesba.java100.threads;

import static com.griesba.java100.threads.ThreadColors.ANSI_BLUE;

public class AnotherThread extends Thread{

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());
        short time = 5000;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another thread wake me up");
            return;
        }

        System.out.println(ANSI_BLUE + "I am awake after "+ time/1000 +" seconds");
    }
}
