package com.haponenka.app.reader.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.haponenka.app.exception.CustomFileException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.io.TempDir;

class CustomFileReaderImplTest {

  private CustomFileReaderImpl reader;

  @BeforeEach
  void setUp() {
    reader = new CustomFileReaderImpl();
  }

  @Test
  void readLinesShouldReturnLinesWhenFileExists(@TempDir Path tempDir)
      throws IOException, CustomFileException {
    // given
    Path testFile = tempDir.resolve("test_arrays.txt");
    List<String> expectedLines = List.of("1 2 3", "4 5 6");
    Files.write(testFile, expectedLines);

    // when
    List<String> actualLines = reader.readLines(testFile.toString());

    // then
    assertEquals(expectedLines, actualLines);
  }

  @Test
  void readLinesShouldThrowExceptionWhenFileDoesNotExist() {
    // given
    String nonExistentPath = "non_existent_dir/random_file.txt";

    // when
    Executable executable = () -> reader.readLines(nonExistentPath);

    // then
    assertThrows(CustomFileException.class, executable);
  }

  @Test
  void readLinesShouldThrowExceptionWhenPathIsNull() {
    // given
    String nullPath = null;

    // when
    Executable executable = () -> reader.readLines(nullPath);

    // then
    assertThrows(CustomFileException.class, executable);
  }
}
