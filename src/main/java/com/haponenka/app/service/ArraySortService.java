package com.haponenka.app.service;

import com.haponenka.app.entity.CustomArray;
import com.haponenka.app.exception.CustomArrayException;

public interface ArraySortService {
  void bubbleSort(CustomArray customArray) throws CustomArrayException;

  void insertionSort(CustomArray customArray) throws CustomArrayException;
}
