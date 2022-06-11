package com.griesba.java100.threads;

import static com.griesba.java100.threads.ThreadColors.ANSI_PURPLE;

public class RunnableTread implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_PURPLE + "Hello from runnable thread");
    }
}
