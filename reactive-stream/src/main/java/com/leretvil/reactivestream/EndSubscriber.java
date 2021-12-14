package main.java.com.leretvil.reactivestream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class EndSubscriber<T> implements Flow.Subscriber<T> {
    private Flow.Subscription subscription;
    private List<T> consumedElement = new ArrayList<>();

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        System.out.println("Received "+ item);
        consumedElement.add(item);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }

    public List<T> getConsumedElement() {
        return consumedElement;
    }

    public void setConsumedElement(List<T> consumedElement) {
        this.consumedElement = consumedElement;
    }
}
