package com.haponenka.app.factory.impl;

import com.haponenka.app.entity.CustomArray;
import com.haponenka.app.exception.CustomArrayException;
import com.haponenka.app.factory.CustomArrayFactory;

public class CustomArrayFactoryImpl implements CustomArrayFactory {

  public CustomArray createCustomArray(int[] elements) throws CustomArrayException {
    if (elements != null) {
      return new CustomArray(elements);
    } else {
      throw new CustomArrayException("Cannot create CustomArray from null array");
    }
  }
}
