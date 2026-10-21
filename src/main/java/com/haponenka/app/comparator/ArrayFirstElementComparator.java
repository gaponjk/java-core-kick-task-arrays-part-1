package com.haponenka.app.comparator;

import com.haponenka.app.entity.CustomArray;

import java.util.Comparator;

public class ArrayFirstElementComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        int first1 = (o1.getLength() > 0) ? o1.getElement(0) : 0;
        int first2 = (o2.getLength() > 0) ? o2.getElement(0) : 0;
        return Integer.compare(first1, first2);
    }
}