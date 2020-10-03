package com.leretvil.sort.qsort;

import com.leretvil.sort.Sort;
import com.leretvil.sort.SortableCollection;
import com.leretvil.sort.Swapper;

import java.util.Comparator;

public class QuickSort<E> implements Sort<E> {
    private Comparator<E> comparator;
    private Swapper swapper;

    @Override
    public void sort(SortableCollection<E> collection) {
        int n = collection.size();
        Qsort<E> qsort = new Qsort<>();
        qsort.qsort(collection,0, n-1);
    }

    @Override
    public void setComparator(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void setSwapper(Swapper swapper) {
        this.swapper = swapper;
    }
}
