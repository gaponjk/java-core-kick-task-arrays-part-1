package com.haponenka.app.comparator;

import com.haponenka.app.entity.CustomArray;
import java.util.Comparator;

public class ArrayIdComparator implements Comparator<CustomArray> {
  @Override
  public int compare(CustomArray o1, CustomArray o2) {
    return CharSequence.compare(o1.getId(), o2.getId());
  }
}
