package com.haponenka.app.parser.impl;

import com.haponenka.app.exception.CustomArrayException;
import com.haponenka.app.parser.CustomParser;
import com.haponenka.app.validator.ArrayLineValidator;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomParserImpl implements CustomParser {

  private static final Logger LOGGER = LogManager.getLogger(CustomParserImpl.class);
  private static final Pattern DELIMITER_PATTERN = Pattern.compile("[,;\\s]+");

  private final ArrayLineValidator validator;

  public CustomParserImpl(ArrayLineValidator validator) {
    this.validator = validator;
  }

  @Override
  public int[] parseLineToIntArray(String line) throws CustomArrayException {
    boolean isValid = this.validator.isValid(line);
    if (isValid) {
      String strippedLine = line.strip();
      String[] stringNumbers = DELIMITER_PATTERN.split(strippedLine);
      int length = stringNumbers.length;
      int[] numbers = new int[length];
      for (int i = 0; i < length; i++) {
        numbers[i] = Integer.parseInt(stringNumbers[i]);
      }
      return numbers;
    } else {
      LOGGER.warn("Line failed validation: {}", line);
      throw new CustomArrayException("Invalid line content for parsing: " + line);
    }
  }
}
