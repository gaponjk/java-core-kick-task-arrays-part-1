package com.haponenka.app.service.impl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.haponenka.app.entity.CustomArray;
import com.haponenka.app.exception.CustomArrayException;
import com.haponenka.app.service.ArraySortService;
import org.junit.jupiter.api.Test;

class ArraySortServiceImplTest {

  private static final int[] UNSORTED_NUMBERS = {9, 2, -5, 7, 1};
  private static final int[] EXPECTED_SORTED = {-5, 1, 2, 7, 9};

  @Test
  void testBubbleSortShouldSortArrayAscending() throws CustomArrayException {
    // given
    ArraySortService service = new ArraySortServiceImpl();
    CustomArray customArray = new CustomArray(UNSORTED_NUMBERS);

    // when
    service.bubbleSort(customArray);

    // then
    int[] actual = customArray.getElements();
    assertArrayEquals(EXPECTED_SORTED, actual);
  }

  @Test
  void testInsertionSortShouldSortArrayAscending() throws CustomArrayException {
    // given
    ArraySortService service = new ArraySortServiceImpl();
    CustomArray customArray = new CustomArray(UNSORTED_NUMBERS);

    // when
    service.insertionSort(customArray);

    // then
    int[] actual = customArray.getElements();
    assertArrayEquals(EXPECTED_SORTED, actual);
  }
}
