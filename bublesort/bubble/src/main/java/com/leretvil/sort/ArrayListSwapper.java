package com.leretvil.sort;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSwapper implements Swapper {

    final private List arrayList;

    public ArrayListSwapper(List arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void swap(int i, int j) {
        Object temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, temp);
    }
}
