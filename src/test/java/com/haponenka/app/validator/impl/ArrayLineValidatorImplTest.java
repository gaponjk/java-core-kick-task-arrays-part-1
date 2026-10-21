package com.haponenka.app.validator.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.haponenka.app.validator.ArrayLineValidator;
import org.junit.jupiter.api.Test;

class ArrayLineValidatorImplTest {

  private static final String VALID_COMMA_LINE = "1, 2, 3, 4";
  private static final String VALID_SEMICOLON_LINE = "10; -20; 30";
  private static final String VALID_SPACE_LINE = "5  12  -9";
  private static final String INVALID_CHAR_LINE = "1, 2, x3, 6";
  private static final String EMPTY_LINE = "   ";

  @Test
  void testIsValidShouldReturnTrueForCommaSeparatedNumbers() {
    // given
    ArrayLineValidator validator = new ArrayLineValidatorImpl();

    // when
    boolean actual = validator.isValid(VALID_COMMA_LINE);

    // then
    assertTrue(actual);
  }

  @Test
  void testIsValidShouldReturnTrueForSemicolonSeparatedNumbers() {
    // given
    ArrayLineValidator validator = new ArrayLineValidatorImpl();

    // when
    boolean actual = validator.isValid(VALID_SEMICOLON_LINE);

    // then
    assertTrue(actual);
  }

  @Test
  void testIsValidShouldReturnTrueForSpaceSeparatedNumbers() {
    // given
    ArrayLineValidator validator = new ArrayLineValidatorImpl();

    // when
    boolean actual = validator.isValid(VALID_SPACE_LINE);

    // then
    assertTrue(actual);
  }

  @Test
  void testIsValidShouldReturnFalseForInvalidCharacters() {
    // given
    ArrayLineValidator validator = new ArrayLineValidatorImpl();

    // when
    boolean actual = validator.isValid(INVALID_CHAR_LINE);

    // then
    assertFalse(actual);
  }

  @Test
  void testIsValidShouldReturnFalseForEmptyString() {
    // given
    ArrayLineValidator validator = new ArrayLineValidatorImpl();

    // when
    boolean actual = validator.isValid(EMPTY_LINE);

    // then
    assertFalse(actual);
  }
}
