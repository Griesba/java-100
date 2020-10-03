package com.leretvil.sort;

import java.util.ArrayList;
import java.util.List;
import com.leretvil.sort.*;

public class ArrayListSortableCollection implements SortableCollection<String> {
    final private List<String> actualNames;

    public ArrayListSortableCollection(List actualNames) {
        this.actualNames = actualNames;
    }

    @Override
    public String get(int i) {
        return actualNames.get(i);
    }

    @Override
    public int size() {
        return actualNames.size();
    }
}
