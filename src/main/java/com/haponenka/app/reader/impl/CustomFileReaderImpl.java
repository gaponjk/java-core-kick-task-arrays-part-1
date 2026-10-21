package com.haponenka.app.reader.impl;

import com.haponenka.app.exception.CustomFileException;
import com.haponenka.app.reader.CustomFileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomFileReaderImpl implements CustomFileReader {

  private static final Logger LOGGER = LogManager.getLogger(CustomFileReaderImpl.class);

  @Override
  public List<String> readLines(String relativeFilePath) throws CustomFileException {
    if (relativeFilePath != null && !relativeFilePath.isBlank()) {
      Path path = Path.of(relativeFilePath);
      if (path.isAbsolute() || relativeFilePath.contains("src/")) {
        throw new CustomFileException(
            "File path must be relative and cannot contain 'src': " + relativeFilePath);
      }
      if (Files.exists(path)) {
        try {
          List<String> lines = Files.readAllLines(path);
          LOGGER.info("File successfully read: {}", relativeFilePath);
          return lines;
        } catch (IOException e) {
          LOGGER.error("Error reading file: {}", relativeFilePath, e);
          throw new CustomFileException("Error during file reading", e);
        }
      } else {
        LOGGER.error("File does not exist: {}", relativeFilePath);
        throw new CustomFileException("File not found: " + relativeFilePath);
      }
    } else {
      LOGGER.error("Provided path is null or empty");
      throw new CustomFileException("Invalid file path argument");
    }
  }
}
