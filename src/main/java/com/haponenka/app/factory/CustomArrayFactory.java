package com.haponenka.app.factory;

import com.haponenka.app.entity.CustomArray;
import com.haponenka.app.exception.CustomArrayException;

public interface CustomArrayFactory {

  CustomArray createCustomArray(int[] elements) throws CustomArrayException;
}
