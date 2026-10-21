package com.haponenka.app.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.haponenka.app.entity.CustomArray;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayServiceImplTest {

  private ArrayServiceImpl service;

  @BeforeEach
  void setUp() {
    service = new ArrayServiceImpl();
  }

  @Test
  void findMinShouldReturnMinimumValueWhenArrayIsNotEmpty() {
    // given
    CustomArray array = new CustomArray(5, -2, 10, 0);

    // when
    OptionalInt actual = service.findMin(array);

    // then
    assertTrue(actual.isPresent());
    assertEquals(-2, actual.getAsInt());
  }

  @Test
  void findMinShouldReturnEmptyWhenArrayIsEmpty() {
    // given
    CustomArray array = new CustomArray();

    // when
    OptionalInt actual = service.findMin(array);

    // then
    assertTrue(actual.isEmpty());
  }

  @Test
  void findMaxShouldReturnMaximumValueWhenArrayIsNotEmpty() {
    // given
    CustomArray array = new CustomArray(5, -2, 10, 0);

    // when
    OptionalInt actual = service.findMax(array);

    // then
    assertTrue(actual.isPresent());
    assertEquals(10, actual.getAsInt());
  }

  @Test
  void calculateSumShouldReturnCorrectSumWhenArrayIsNotEmpty() {
    // given
    CustomArray array = new CustomArray(1, 2, 3, 4);

    // when
    OptionalInt actual = service.calculateSum(array);

    // then
    assertTrue(actual.isPresent());
    assertEquals(10, actual.getAsInt());
  }

  @Test
  void calculateAverageShouldReturnCorrectAverageWhenArrayIsNotEmpty() {
    // given
    CustomArray array = new CustomArray(1, 2, 3, 4);

    // when
    OptionalDouble actual = service.calculateAverage(array);

    // then
    assertTrue(actual.isPresent());
    assertEquals(2.5, actual.getAsDouble(), 0.0001);
  }
}
