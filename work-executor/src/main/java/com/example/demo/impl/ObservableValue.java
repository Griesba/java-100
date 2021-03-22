package com.example.demo.impl;

import com.example.demo.Callback;
import com.example.demo.Observable;
import com.example.demo.ObservableException;
import com.example.demo.ValueChangeEvent;
import com.example.demo.work.WorkExecutor;
import commonj.work.Work;

import java.io.Serializable;

public class ObservableValue<V extends Serializable> implements Observable<V, ValueChangeEvent<V>> {

    private final WorkExecutor executor = new DefaultWorkExecutor(5, null);

    @Override
    public void observe(Callback callback, String observerName, Serializable previousValue, long timeout) throws ObservableException {

    }

    @Override
    public void define(V value) {

    }

    @Override
    public V get() {
        return null;
    }
}
