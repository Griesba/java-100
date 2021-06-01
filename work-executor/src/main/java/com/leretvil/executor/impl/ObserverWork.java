package com.griesba.executor.impl;

import com.griesba.executor.Callback;
import com.griesba.executor.work.GenericWork;
import com.griesba.executor.ValueChangeEvent;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class ObserverWork <V extends Serializable> extends GenericWork {
    private final ObservableValue<V> observed;
    private final Callback<ValueChangeEvent<V>> callback;
    private final V previousValue;
    private final long timeout;

    ObserverWork(String name, ObservableValue<V> observed, Callback<ValueChangeEvent<V>> callback, V previousValue, long timeout) {
        super(name);
        this.observed = observed;
        this.callback = callback;
        this.previousValue = previousValue;
        this.timeout = Instant.now().toEpochMilli() + timeout;
    }

    @Override
    public void concreteRun() {
        if (Objects.equals(previousValue, observed.get())) {
            synchronized (observed) {
                long waitDuration = timeout - Instant.now().toEpochMilli();
                while (waitDuration > 0 && Objects.equals(previousValue, observed.get())){
                    try {
                        observed.wait(waitDuration);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    waitDuration = timeout - Instant.now().toEpochMilli();
                }
            }
        }
        if (Objects.equals(previousValue, observed.get())){
            callback.onTimeout();
        } else {
            callback.onEvent(new ValueChangeEvent<>(observed.get(), previousValue));
        }
    }

    @Override
    public boolean isDaemon() {
        return false;
    }
}
