package com.haponenka.app.repository.specification.impl;

import com.haponenka.app.entity.CustomArray;
import com.haponenka.app.repository.specification.ArraySpecification;
import com.haponenka.app.service.ArrayService;
import com.haponenka.app.service.impl.ArrayServiceImpl;
import java.util.OptionalInt;

public class SumGreaterThanSpecification implements ArraySpecification {
    private final int threshold;
    private final ArrayService arrayService;

    public SumGreaterThanSpecification(int threshold) {
        this.threshold = threshold;
        this.arrayService = new ArrayServiceImpl();
    }

    @Override
    public boolean specify(CustomArray customArray) {
        OptionalInt sum = this.arrayService.calculateSum(customArray);
        if (sum.isPresent()) {
            return sum.getAsInt() > this.threshold;
        } else {
            return false;
        }
    }
}