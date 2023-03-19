package com.griesba.java100.builder.vehiclebundle;

import java.util.ArrayList;
import java.util.List;

public abstract class Bundle { // bundle c'est liasse en français
    protected List<String> content =
            new ArrayList<String>();

    public abstract void addDocument(String document);
    public abstract void print();
}
