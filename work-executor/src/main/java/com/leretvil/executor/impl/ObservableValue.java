package com.griesba.executor.impl;

import com.griesba.executor.Callback;
import com.griesba.executor.ObservableException;
import com.griesba.executor.work.WorkExecutor;
import com.griesba.executor.work.WorkExecutorException;
import com.griesba.executor.Observable;
import com.griesba.executor.ValueChangeEvent;

import java.io.Serializable;

public class ObservableValue<V extends Serializable> implements Observable<V, ValueChangeEvent<V>> {

    private final WorkExecutor executor = new DefaultWorkExecutor(5, null);
    private V value;

    public ObservableValue(V initialValue) {
        this.value = initialValue;
    }

    @Override
    public void observe(Callback<ValueChangeEvent<V>> callback, String observerName, V previousValue, long timeout) throws ObservableException {
        try{
            executor.executeWork(new ObserverWork<>(observerName, this, callback, previousValue, timeout), "ObserverWorkManager");
        } catch (WorkExecutorException e) {
            throw new ObservableException("could not start observing change", e);
        }
    }

    @Override
    public void define(V newValue) {
        synchronized (this) {
            value = newValue;
            this.notifyAll();
        }
    }

    @Override
    public V get() {
        return value;
    }
}
