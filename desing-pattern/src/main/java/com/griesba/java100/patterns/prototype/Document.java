package com.griesba.java100.patterns.prototype;

public abstract class Document implements Cloneable {
    protected String content;

    public Document duplicate() {
        Document result;
        try {
            result = (Document) this.clone();
        } catch (CloneNotSupportedException e) {
           return null;
        }
        return result;
    }

    public void fill(String content) {
        this.content = content;
    }

    public abstract void print();

    public abstract void show();
}
