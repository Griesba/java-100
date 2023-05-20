package com.griesba.java100.patterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class LiasseClient extends Liasse {

    public LiasseClient(String content) {
        documents = new ArrayList<>();
        LiasseVierge liasseVierge = LiasseVierge.getInstance();
        List<Document> documentVierges = liasseVierge.getDocuments();
        for (Document document : documentVierges) {
            Document documentCopy = document.duplicate();
            documentCopy.fill(content);
            documents.add(documentCopy);
        }
    }

    public void showDocument() {
        for (Document document : documents) {
            document.show();
        }
    }

    public void printDocument() {
        documents.stream().peek(Document::print);
    }


}
