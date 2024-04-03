package com.griesba.algo.concurrency;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurrentCollectionsTest {

    @Test
    void shouldConcurrentlyAddDataToList () {
        // Création d'une liste non synchronisée
        List<String> list = new ArrayList<>();

        // Utilisation de Collections.synchronizedList() pour créer une liste synchronisée
        List<String> synchronizedList = Collections.synchronizedList(list);

        // Création de plusieurs threads pour ajouter des éléments à la liste synchronisée
        Runnable addTask = () -> {
            for (int i = 0; i < 5; i++) {
                synchronizedList.add(Thread.currentThread().getName() + "-" + i);
            }
        };
        Counter counter = new Counter(10);
        Runnable countTask = () -> {
            while (counter.getCount() < 10) {
                synchronizedList.add(Thread.currentThread().getName() + "-" + counter.count());
            }
        };

        Thread thread1 = new Thread(countTask, "Thread 1");
        Thread thread2 = new Thread(countTask, "Thread 2");

        // Démarrage des threads
        thread1.start();
        thread2.start();

        // Attendre la fin des threads
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Affichage de la liste synchronisée
        System.out.println("Synchronized List: " + synchronizedList);
    }

    class Counter {
        private int i;
       private final int max;

        public Counter(int max) {
            this.max = max;
        }
        public synchronized int count() {
            return i++;
        }

        public int getCount() {
            return i;
        }
    }
}
