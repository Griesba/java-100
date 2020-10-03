package com.leretvil.sort.qsort;

import com.leretvil.sort.SortableCollection;
import com.leretvil.sort.Swapper;

import java.util.Comparator;

public class Qsort<E> {

    Comparator<E> comparator;
    Swapper swapper;

    public void qsort(SortableCollection<E> collection, int start, int end) {
        if (start < end) {
            final E pivot = collection.get(start);
            final Partitioner<E> partitioner = new Partitioner<>(comparator, swapper);
            int cutIndex = partitioner.partition(collection, start, end, pivot);
            if (cutIndex == start) {
                cutIndex++;
            }
            qsort(collection, start, cutIndex-1);
            qsort(collection, cutIndex, end);
        }
    }
}
