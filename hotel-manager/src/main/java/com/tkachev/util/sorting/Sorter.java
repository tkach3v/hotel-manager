package com.tkachev.util.sorting;

import javax.swing.SortOrder;
import java.util.Comparator;
import java.util.List;

public final class Sorter {

    private Sorter() {
    }

    public static <T> List<T> sort(List<T> list, Comparator<T> comparator, SortOrder sortOrder) {
        if (sortOrder == SortOrder.ASCENDING) {
            return list.stream()
                    .sorted(comparator)
                    .toList();
        } else if (sortOrder == SortOrder.DESCENDING) {
            return list.stream()
                    .sorted(comparator.reversed())
                    .toList();
        }

        return list;
    }
}
