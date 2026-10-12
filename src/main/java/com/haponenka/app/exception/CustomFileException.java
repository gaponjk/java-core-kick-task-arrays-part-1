package com.haponenka.app.exception;

public class CustomFileException extends RuntimeException {
  public CustomFileException(String message) {
    super(message);
  }

  public CustomFileException(String message, Throwable cause) {
    super(message, cause);
  }

  public CustomFileException(Throwable cause) {
    super(cause);
  }

  public CustomFileException() {}
}
