package com.griesba.algo.anagramme;


public class QuickSort<T extends Comparable<T>> {

    public void sort(T[] A, int lo, int hi) {
        if (lo < hi) {
            int p = partition(A, lo, hi);
            sort(A, lo, p - 1);
            sort(A, p + 1, hi);
        }
    }

    private int partition(T[] A, int lo, int hi) {
        T pivot = A[hi];
        int i = lo;
        for (int j = i; j < hi; j++) {
            if (A[j].compareTo(pivot) < 0) {
                swapArray(A, i, j);
                i++;
            }
        }
        swapArray(A, i, hi);
        return i;
    }

    private void swapArray(T[] A, int lo, int hi) {
        T temp = A[lo];
        A[lo] = A[hi];
        A[hi] = temp;
    }
}
