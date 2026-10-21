package com.haponenka.app.repository;

import com.haponenka.app.entity.CustomArray;
import com.haponenka.app.repository.specification.ArraySpecification;
import java.util.Comparator;
import java.util.List;

public interface CustomArrayRepository {
    void add(CustomArray customArray);
    void remove(CustomArray customArray);
    List<CustomArray> query(ArraySpecification specification);
    List<CustomArray> sort(Comparator<CustomArray> comparator);
    List<CustomArray> getAll();
}