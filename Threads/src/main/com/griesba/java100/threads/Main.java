package com.griesba.java100.threads;

import static java.lang.Thread.currentThread;

public class Main {

    public static void main(String[] args) {

        SpikeMethodGeneric spikeMethodGeneric = new SpikeMethodGeneric();

        spikeMethodGeneric.uneMethode("bladfa", 1);
        spikeMethodGeneric.uneMethode(5, 2);
        System.out.println(ThreadColors.ANSI_RED + "Hello from main thread");

        new Thread() {
            public void run() {
                System.out.println(ThreadColors.ANSI_GREEN + "Hello from anonymous thread");
            }
        }.start();

        new Thread(() -> System.out.println("Hello from the lambda thread")).start();


        Thread anotherThread =  new AnotherThread();
        anotherThread.setName("====== Another thread =====");
        anotherThread.start();

        // calling the run method is not right.
        // By doing this, the run method is not executed by a new thread
        // but by the main thread
        /* Thread anotherThread1 =  new AnotherThread();
        anotherThread1.setName("====== AnotherThread =====");
        anotherThread1.run();*/

        Thread runnableThread = new Thread(new RunnableTread(){
            @Override
            public void run() {
                try {
                    anotherThread.join(3000);
                    System.out.println(ThreadColors.ANSI_PURPLE + "AnotherThread terminated, or timeout of three seconds passed");
                    super.run();
                } catch (InterruptedException e) {
                    System.out.println(ThreadColors.ANSI_PURPLE + "I was interrupted by another thread" + currentThread().getName());
                }

            }
        });
        runnableThread.setName("Anonymous thread");
        runnableThread.start();

        Thread runnableThreadI = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(ThreadColors.ANSI_BLACK + "Waiting anotherTread before I great");
                    anotherThread.join();
                    System.out.println(ThreadColors.ANSI_BLACK + "Hello from Runnable thread Interface, anotherThread finished after 5 seconds");
                } catch (InterruptedException e) {

                }

            }
        });
        runnableThreadI.start();




    }
}


class SpikeMethodGeneric {


    <T> void uneMethode(T in, int type) {
        if (type == 1) {
            System.out.println("cest une String " + in);;
        } else if (type == 2) {
            System.out.println("c'est un entier " + in);
        }
    }

    <T> void uneAutreMethod (T in) {
        System.out.println(in);
    }
}

class Detailed {
    String name;

    public String getName() {
        return name;
    }

    public Detailed(String name) {
        this.name = name;
    }
}

class Gategorized {
    String name;

    public String getName() {
        return name;
    }

    public Gategorized(String name) {
        this.name = name;
    }
}