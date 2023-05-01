package com.griesba.java100.patterns.builder.vehiclebundle;

public class BundlePdf extends Bundle {
    @Override
    public void addDocument(String document) {
        if (document.startsWith("<PDF>")) {
            content.add(document);
        }
    }

    @Override
    public void print() {
        System.out.println("Liasse PDF");
        for (String s : content) {
            System.out.println(s);
        }
    }
}
