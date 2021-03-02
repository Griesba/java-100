package com.example.demo.work;

public interface WorkItem extends Comparable {
    Work getResult() throws Exception;

    int getStatus();
}
