package com.haponenka.app.reader;

import com.haponenka.app.exception.CustomArrayException;
import java.util.List;

public interface CustomFileReader {
  List<String> readLines(String relativeFilePath) throws CustomArrayException;
}
