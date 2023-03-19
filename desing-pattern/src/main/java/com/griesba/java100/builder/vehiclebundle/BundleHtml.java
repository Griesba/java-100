package com.griesba.java100.builder.vehiclebundle;

public class BundleHtml extends Bundle {
    @Override
    public void addDocument(String document) {
        if (document.startsWith("<HTML>")) {
            content.add(document);
        }
    }

    @Override
    public void print() {
        System.out.println("Liasse HTML");
        for (String s : content) {
            System.out.println(s);
        }
    }
}
