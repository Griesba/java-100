package com.example.demo;

import java.io.Serializable;

public class ValueChangeEvent <V extends Serializable> implements Event {
    private V newValue;
    private V orldValue;

    public ValueChangeEvent(V newValue, V oldValue) {
        this.newValue = newValue;
        this.orldValue = oldValue;
    }

    public V getNewValue() {
        return newValue;
    }

    public void setNewValue(V newValue) {
        this.newValue = newValue;
    }

    public V getOrldValue() {
        return orldValue;
    }

    public void setOrldValue(V orldValue) {
        this.orldValue = orldValue;
    }
}
