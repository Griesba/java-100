package com.leretvil.sort;

import java.util.Comparator;

public class StringComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {

        final String f;
        final String s;
        try {
            f = (String) o1;
            s = (String) o2;
        } catch (Exception e) {
            throw new RuntimeException("there are mixed elements in the collection", e);
        }
        return f.compareTo(s);
    }
}
