package com.example.demo;

import java.io.Serializable;

public class ValueChangeEvent <V extends Serializable> implements Event {
    private V newValue;
    private V oldValue;

    public ValueChangeEvent(V newValue, V oldValue) {
        this.newValue = newValue;
        this.oldValue = oldValue;
    }

    public V getNewValue() {
        return newValue;
    }

    public void setNewValue(V newValue) {
        this.newValue = newValue;
    }

    public V getOldValue() {
        return oldValue;
    }

    public void setOldValue(V oldValue) {
        this.oldValue = oldValue;
    }
}
