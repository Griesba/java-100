package main.java.com.leretvil.reactivestream;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class Main {

    public static void main(String[] args) {

        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        EndSubscriber<String> endSubscriber = new EndSubscriber<>();
        publisher.subscribe(endSubscriber);
        List<String> items = List.of("1", "x", "2", "x", "3", "x");

        System.out.println("Number of subscriber: " + publisher.getNumberOfSubscribers());
        items.forEach(publisher::submit);
        publisher.close();

        while (endSubscriber.getConsumedElement().size() < items.size()) {
            System.out.println(endSubscriber.getConsumedElement().size());
        }
        System.out.println("End");
    }
}
