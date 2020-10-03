package com.leretvil.sort.qsort;

import com.leretvil.sort.SortableCollection;
import com.leretvil.sort.Swapper;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class NonRecursiveQuickSort<E> {

    private final Comparator<E> comparator;
    private final Swapper swapper;

    public NonRecursiveQuickSort(Comparator<E> comparator, Swapper swapper) {
        this.comparator = comparator;
        this.swapper = swapper;
    }

    private static class Stack {
        final int begin;
        final int fin;
        public Stack(int begin, int fin) {
            this.begin = begin;
            this.fin = fin;
        }
    }

    public void qsort(SortableCollection<E> sortable, int start, int end) {
        final List<Stack> stack = new LinkedList<>();
        final Partitioner<E> partitioner = new Partitioner<>(comparator, swapper);
        stack.add(new Stack(start, end));
        int i = 1;

        while (!stack.isEmpty()){
            Stack iter = stack.remove(0);
            if (iter.begin < iter.fin) {
                final E pivot = sortable.get(iter.begin);
                int cutIndex = partitioner.partition(sortable, iter.begin, iter.fin, pivot);
                if( cutIndex == iter.begin ){
                    cutIndex++;
                }
                stack.add(new Stack(iter.begin, cutIndex - 1));
                stack.add(new Stack(cutIndex, iter.fin));
            }
        }
    }
}
