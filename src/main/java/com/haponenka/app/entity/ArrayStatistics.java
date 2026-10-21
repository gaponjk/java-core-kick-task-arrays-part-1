package com.haponenka.app.entity;

public class ArrayStatistics {
  private final int min;
  private final int max;
  private final int sum;
  private final double average;

  public ArrayStatistics(int min, int max, int sum, double average) {
    this.min = min;
    this.max = max;
    this.sum = sum;
    this.average = average;
  }

  public int getMin() {
    return this.min;
  }

  public int getMax() {
    return this.max;
  }

  public int getSum() {
    return this.sum;
  }

  public double getAverage() {
    return this.average;
  }
}
