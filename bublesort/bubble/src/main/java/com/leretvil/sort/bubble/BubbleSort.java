package com.leretvil.sort.bubble;

import com.leretvil.sort.Sort;
import com.leretvil.sort.SortableCollection;
import com.leretvil.sort.Swapper;

import java.util.Comparator;


public class BubbleSort<E> implements Sort<E> {

    private Comparator comparator;

    private Swapper swapper;


    @Override
    public void sort(SortableCollection collection) {
        int n = collection.size();
        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                if(comparator.compare(collection.get(i), collection.get(i+1)) > 0){
                    swapper.swap(i, i+1);
                }
            }
            n--;
        }
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
