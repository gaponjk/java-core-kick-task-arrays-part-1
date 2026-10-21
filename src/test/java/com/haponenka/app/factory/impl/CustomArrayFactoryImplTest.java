package com.haponenka.app.factory.impl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.haponenka.app.entity.CustomArray;
import com.haponenka.app.exception.CustomArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class CustomArrayFactoryImplTest {

  private CustomArrayFactoryImpl factory;

  @BeforeEach
  void setUp() {
    factory = new CustomArrayFactoryImpl();
  }

  @Test
  void createCustomArrayShouldReturnCustomArrayWhenArrayIsValid() throws CustomArrayException {
    // given
    int[] elements = {1, 2, 3};

    // when
    CustomArray actual = factory.createCustomArray(elements);

    // then
    assertNotNull(actual);
    assertArrayEquals(elements, actual.getElements());
  }

  @Test
  void createCustomArrayShouldThrowExceptionWhenArrayIsNull() {
    // given
    int[] nullElements = null;

    // when
    Executable executable = () -> factory.createCustomArray(nullElements);

    // then
    assertThrows(CustomArrayException.class, executable);
  }
}
