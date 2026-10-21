package com.haponenka.app.entity;

import com.haponenka.app.event.ArrayEvent;
import com.haponenka.app.observer.ArrayObserver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CustomArray {
  private final String id;
  private int[] elements;
  private final List<ArrayObserver> observers;

  public CustomArray(String id, int... elements) {
    this.id = id;
    this.observers = new ArrayList<>();
    if (elements != null) {
      this.elements = Arrays.copyOf(elements, elements.length);
    } else {
      this.elements = new int[0];
    }
  }
  public CustomArray( int... elements) {
    this.id = String.valueOf(UUID.randomUUID());
    this.observers = new ArrayList<>();
    if (elements != null) {
      this.elements = Arrays.copyOf(elements, elements.length);
    } else {
      this.elements = new int[0];
    }
  }

  public String  getId() {
    return this.id;
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
    notifyObservers();
  }

  public int getElement(int index) {
    return this.elements[index];
  }

  public void setElement(int index, int value) {
    this.elements[index] = value;
    notifyObservers();
  }

  public int getLength() {
    return this.elements.length;
  }

  public void attach(ArrayObserver observer) {
    if (observer != null) {
      this.observers.add(observer);
    }
  }

  public void detach(ArrayObserver observer) {
    this.observers.remove(observer);
  }

  private void notifyObservers() {
    ArrayEvent event = new ArrayEvent(this);
    for (ArrayObserver observer : this.observers) {
      observer.update(event);
    }
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
    if (!this.id.equals( that.id)) {
      return false;
    }
    return Arrays.equals(this.elements, that.elements);
  }

  @Override
  public int hashCode() {
    int result = (this.id != null) ? this.id.hashCode() : 0;
    result = 31 * result + Arrays.hashCode(this.elements);
    return result;
  }

  @Override
  public String toString() {
    return "CustomArray{id=" + this.id + ", elements=" + Arrays.toString(this.elements) + '}';
  }
}