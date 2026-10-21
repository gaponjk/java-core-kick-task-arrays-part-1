package com.haponenka.app.service;

import com.haponenka.app.entity.CustomArray;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayService {
  OptionalInt findMin(CustomArray customArray);

  OptionalInt findMax(CustomArray customArray);

  OptionalInt calculateSum(CustomArray customArray);

  OptionalDouble calculateAverage(CustomArray customArray);
}
