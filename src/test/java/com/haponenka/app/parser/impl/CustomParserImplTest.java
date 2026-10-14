package com.haponenka.app.parser.impl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.haponenka.app.exception.CustomArrayException;
import com.haponenka.app.validator.ArrayLineValidator;
import com.haponenka.app.validator.impl.ArrayLineValidatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class CustomParserImplTest {

  private CustomParserImpl parser;

  @BeforeEach
  void setUp() {
    ArrayLineValidator validator = new ArrayLineValidatorImpl();
    parser = new CustomParserImpl(validator);
  }

  @Test
  void parseLineToIntArrayShouldReturnParsedArrayWhenLineIsValid() throws CustomArrayException {
    // given
    String line = " 10, -5; 20 30 ";
    int[] expected = {10, -5, 20, 30};

    // when
    int[] actual = parser.parseLineToIntArray(line);

    // then
    assertArrayEquals(expected, actual);
  }

  @Test
  void parseLineToIntArrayShouldThrowExceptionWhenLineIsInvalid() {
    // given
    String invalidLine = "10, abc, 30";

    // when
    Executable executable = () -> parser.parseLineToIntArray(invalidLine);

    // then
    assertThrows(CustomArrayException.class, executable);
  }
}
