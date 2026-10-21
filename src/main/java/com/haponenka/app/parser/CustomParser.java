package com.haponenka.app.parser;

import com.haponenka.app.exception.CustomArrayException;

public interface CustomParser {
  int[] parseLineToIntArray(String line) throws CustomArrayException;
}
