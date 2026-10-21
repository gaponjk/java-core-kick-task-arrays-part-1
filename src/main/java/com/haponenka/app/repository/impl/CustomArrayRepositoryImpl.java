package com.haponenka.app.repository.impl;

import com.haponenka.app.entity.CustomArray;
import com.haponenka.app.repository.CustomArrayRepository;
import com.haponenka.app.repository.specification.ArraySpecification;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayRepositoryImpl implements CustomArrayRepository {
    private static final Logger LOGGER = LogManager.getLogger(CustomArrayRepositoryImpl.class);
    private static CustomArrayRepositoryImpl instance;
    private final List<CustomArray> storage;

    private CustomArrayRepositoryImpl() {
        this.storage = new ArrayList<>();
    }

    // Непотокобезопасный Singleton
    public static CustomArrayRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CustomArrayRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void add(CustomArray customArray) {
        if (customArray != null) {
            this.storage.add(customArray);
            LOGGER.info("Added array to repository: id={}", customArray.getId());
        }
    }

    @Override
    public void remove(CustomArray customArray) {
        this.storage.remove(customArray);
        LOGGER.info("Removed array from repository");
    }

    @Override
    public List<CustomArray> query(ArraySpecification specification) {
        List<CustomArray> result = new ArrayList<>();
        this.storage.stream()
                .filter(specification::specify)
                .forEach(result::add);

        LOGGER.info("Specification query found {} items", result.size());
        return result;
    }

    @Override
    public List<CustomArray> sort(Comparator<CustomArray> comparator) {
        List<CustomArray> copy = new ArrayList<>(this.storage);
        copy.sort(comparator);
        return copy;
    }

    @Override
    public List<CustomArray> getAll() {
        return Collections.unmodifiableList(this.storage);
    }
}