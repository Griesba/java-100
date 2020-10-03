package com.leretvil.sort;

import java.util.Comparator;

public interface Sort<E> {
    void sort(SortableCollection<E> collection);
    void setComparator(Comparator<E> comparator);
    void setSwapper(Swapper swapper);
}
