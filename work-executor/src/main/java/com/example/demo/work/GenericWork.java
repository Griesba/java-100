package com.example.demo.work;

import com.example.demo.utils.ThreadContextManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.Future;

import static java.lang.System.currentTimeMillis;

public abstract class GenericWork implements Work {
    private static final Logger LOG = LoggerFactory.getLogger(GenericWork.class);

    private ThreadContextManager threadContextManager;

    private volatile Future<?> future;
    private volatile WorkItem workItem;

    private final String name;

    public abstract void concreteRun();

    public boolean idDaemon() {
        return false;
    }

    public String getName() {
        return name;
    }

    public void release() {}

    public GenericWork(String name) {
        this.name = name;
    }

    public Future<?> getFuture() {
        return future;
    }

    public void setFuture(Future<?> future) {
        this.future = future;
    }

    public WorkItem getWorkItem() {
        return workItem;
    }

    public void setWorkItem(WorkItem workItem) {
        this.workItem = workItem;
    }

    @Override
    public void run() {
        String uuid = UUID.randomUUID().toString();

        try {
            if (threadContextManager != null) {
                threadContextManager.startFunction();
            }
            long startStep = currentTimeMillis();
            concreteRun();
            long elapsed = currentTimeMillis() - startStep;

        } catch (Exception e) {
            LOG.error("name {} uuid {}", getName(), uuid, e);
        } finally {
            if (threadContextManager != null) {
                threadContextManager.endFunction();
            }
        }
    }
}
