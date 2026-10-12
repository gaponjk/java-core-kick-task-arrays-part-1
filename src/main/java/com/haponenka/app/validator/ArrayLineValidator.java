package com.haponenka.app.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayLineValidator {

  private static final Pattern VALID_PATTERN =
      Pattern.compile("^\\s*-?\\d+(\\s*[,;\\-\\s]\\s*-?\\d+)*\\s*$");

  public boolean isValid(String line) {
    if (line != null && !line.trim().isEmpty()) {
      Matcher matcher = VALID_PATTERN.matcher(line);
      return matcher.matches();
    }
    return false;
  }
}
