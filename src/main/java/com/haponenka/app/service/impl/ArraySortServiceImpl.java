package com.haponenka.app.service.impl;

import com.haponenka.app.entity.CustomArray;
import com.haponenka.app.exception.CustomArrayException;
import com.haponenka.app.service.ArraySortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraySortServiceImpl implements ArraySortService {

  private static final Logger LOGGER = LogManager.getLogger(ArraySortServiceImpl.class);

  @Override
  public void bubbleSort(CustomArray customArray) throws CustomArrayException {
    if (customArray != null) {
      int[] array = customArray.getElements();
      int n = array.length;
      for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
          if (array[j] > array[j + 1]) {
            int temp = array[j];
            array[j] = array[j + 1];
            array[j + 1] = temp;
          }
        }
      }
      customArray.setElements(array);
      LOGGER.info("Array sorted with bubble sort");
    } else {
      LOGGER.error("CustomArray is null for bubble sort");
      throw new CustomArrayException("Cannot sort null CustomArray");
    }
  }

  @Override
  public void insertionSort(CustomArray customArray) throws CustomArrayException {
    if (customArray != null) {
      int[] array = customArray.getElements();
      int n = array.length;
      for (int i = 1; i < n; i++) {
        int key = array[i];
        int j = i - 1;
        while (j >= 0 && array[j] > key) {
          array[j + 1] = array[j];
          j = j - 1;
        }
        array[j + 1] = key;
      }
      customArray.setElements(array);
      LOGGER.info("Array sorted with insertion sort");
    } else {
      LOGGER.error("CustomArray is null for insertion sort");
      throw new CustomArrayException("Cannot sort null CustomArray");
    }
  }
}
