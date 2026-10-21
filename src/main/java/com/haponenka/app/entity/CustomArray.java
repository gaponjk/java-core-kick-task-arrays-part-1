package com.haponenka.app.entity;

import java.util.Arrays;

public class CustomArray {

  private int[] elements;

  public CustomArray(int... elements) {
    if (elements != null) {
      this.elements = Arrays.copyOf(elements, elements.length);
    } else {
      this.elements = new int[0];
    }
  }

  public int[] getElements() {
    return Arrays.copyOf(this.elements, this.elements.length);
  }

  public void setElements(int[] elements) {
    if (elements != null) {
      this.elements = Arrays.copyOf(elements, elements.length);
    } else {
      this.elements = new int[0];
    }
  }

  public int getElement(int index) {
    return this.elements[index];
  }

  public void setElement(int index, int value) {
    this.elements[index] = value;
  }

  public int getLength() {
    return this.elements.length;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomArray that = (CustomArray) o;
    return Arrays.equals(this.elements, that.elements);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(this.elements);
  }

  @Override
  public String toString() {
    return "CustomArray{elements=" + Arrays.toString(this.elements) + '}';
  }
}
