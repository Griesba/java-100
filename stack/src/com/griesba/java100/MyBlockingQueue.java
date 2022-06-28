package com.griesba.java100;

import java.util.LinkedList;
import java.util.List;

public class MyBlockingQueue <T> {

    private List<T> list;
    private final int size;

    public MyBlockingQueue(int size) {
        this.list = new LinkedList<>();
        this.size = size;
    }

    public synchronized void push (T val) {
        if (list.size() >= size) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        notifyAll();
        list.add(val);
    }

    public T take() {
        if (list.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
            notify();
        }
        return list.get(list.size()-1);
    }
}
