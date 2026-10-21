package com.haponenka.app.comparator;

import com.haponenka.app.entity.CustomArray;

import java.util.Comparator;

public class ArrayLengthComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        return Integer.compare(o1.getLength(), o2.getLength());
    }
}
