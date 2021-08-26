package com.leretvil.executor.work;

public interface WorkItem extends Comparable {
    Work getResult() throws Exception;

    int getStatus();
}
