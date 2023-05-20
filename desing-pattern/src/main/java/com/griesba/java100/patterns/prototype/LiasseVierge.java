package com.griesba.java100.patterns.prototype;

import java.util.ArrayList;

public class LiasseVierge extends Liasse {
    private static LiasseVierge instance = new LiasseVierge();

    private LiasseVierge() {
        documents = new ArrayList<>();
    }

    public static LiasseVierge getInstance() {
        return instance;
    }

    public void add(Document doc) {
        documents.add(doc);
    }

    public void remove(Document document) {
        documents.remove(document);
    }
}
