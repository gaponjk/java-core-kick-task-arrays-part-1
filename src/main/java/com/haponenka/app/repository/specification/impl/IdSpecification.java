package com.haponenka.app.repository.specification.impl;

import com.haponenka.app.entity.CustomArray;
import com.haponenka.app.repository.specification.ArraySpecification;

public class IdSpecification implements ArraySpecification {
  private final String expectedId;

  public IdSpecification(String expectedId) {
    this.expectedId = expectedId;
  }

  @Override
  public boolean specify(CustomArray customArray) {
    if (customArray == null) {
      return false;
    }
    return customArray.getId().equals(this.expectedId);
  }
}
