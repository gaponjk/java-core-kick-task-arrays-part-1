package com.haponenka.app.service.impl;

import com.haponenka.app.entity.CustomArray;
import com.haponenka.app.service.ArrayService;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayServiceImpl implements ArrayService {

  private static final Logger LOGGER = LogManager.getLogger(ArrayServiceImpl.class);

  @Override
  public OptionalInt findMin(CustomArray customArray) {
    if (customArray != null && customArray.getLength() > 0) {
      int[] array = customArray.getElements();
      int min = array[0];
      for (int i = 1; i < array.length; i++) {
        if (array[i] < min) {
          min = array[i];
        }
      }
      LOGGER.info("Min value found: {}", min);
      return OptionalInt.of(min);
    }
    LOGGER.warn("CustomArray is null or empty, min cannot be determined");
    return OptionalInt.empty();
  }

  @Override
  public OptionalInt findMax(CustomArray customArray) {
    if (customArray != null && customArray.getLength() > 0) {
      int[] array = customArray.getElements();
      int max = array[0];
      for (int i = 1; i < array.length; i++) {
        if (array[i] > max) {
          max = array[i];
        }
      }
      LOGGER.info("Max value found: {}", max);
      return OptionalInt.of(max);
    }
    LOGGER.warn("CustomArray is null or empty, max cannot be determined");
    return OptionalInt.empty();
  }

  @Override
  public OptionalInt calculateSum(CustomArray customArray) {
    if (customArray != null && customArray.getLength() > 0) {
      int[] array = customArray.getElements();
      int sum = 0;
      for (int value : array) {
        sum += value;
      }
      LOGGER.info("Sum calculated: {}", sum);
      return OptionalInt.of(sum);
    }
    LOGGER.warn("CustomArray is null or empty, sum cannot be calculated");
    return OptionalInt.empty();
  }

  @Override
  public OptionalDouble calculateAverage(CustomArray customArray) {
    if (customArray != null && customArray.getLength() > 0) {
      OptionalInt sumOptional = calculateSum(customArray);
      if (sumOptional.isPresent()) {
        int sum = sumOptional.getAsInt();
        double average = (double) sum / customArray.getLength();
        LOGGER.info("Average calculated: {}", average);
        return OptionalDouble.of(average);
      }
    }
    LOGGER.warn("CustomArray is null or empty, average cannot be calculated");
    return OptionalDouble.empty();
  }
}
