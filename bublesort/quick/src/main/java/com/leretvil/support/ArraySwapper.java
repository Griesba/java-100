package com.leretvil.support;

import com.leretvil.sort.Swapper;

public class ArraySwapper<E> implements Swapper {

    private final E[] array;

    public ArraySwapper(E[] array) {
        this.array = array;
    }

    @Override
    public void swap(int i, int j) {
        final E tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
