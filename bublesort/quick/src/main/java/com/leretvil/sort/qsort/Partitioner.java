package com.leretvil.sort.qsort;

import com.leretvil.sort.SortableCollection;
import com.leretvil.sort.Swapper;

import java.util.Comparator;

public class Partitioner<E> {
    private final Comparator<E> comparator;
    private final Swapper swapper;
    public Partitioner(Comparator<E> comparator, Swapper swapper) {
        this.comparator = comparator;
        this.swapper = swapper;
    }

    public int partition(SortableCollection<E> sortableCollection, int start, int end, E pivot) {
        int small = start;
        int large = end;
        while (large > small) {
            while (comparator.compare(sortableCollection.get(small), pivot) < 0 && small < large) {
                small++;
            }
            while (comparator.compare(sortableCollection.get(large), pivot) >= 0 && small < large) {
                large--;
            }
            if(small < large) {
                swapper.swap(small, large);
            }
        }
        return large;
    }


}
