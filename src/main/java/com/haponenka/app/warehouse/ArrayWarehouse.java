package com.haponenka.app.warehouse;

import com.haponenka.app.entity.ArrayStatistics;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayWarehouse {
    private static final Logger LOGGER = LogManager.getLogger(ArrayWarehouse.class);
    private static ArrayWarehouse instance;
    private final Map<String, ArrayStatistics> statisticsMap;

    // Приватный конструктор
    private ArrayWarehouse() {
        this.statisticsMap = new HashMap<>();
    }

    // Непотокобезопасный Singleton согласно требованию ТЗ
    public static ArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new ArrayWarehouse();
        }
        return instance;
    }

    public void put(String id, ArrayStatistics statistics) {
        this.statisticsMap.put(id, statistics);
        LOGGER.info("Saved statistics for id: {}", id);
    }

    public ArrayStatistics get(String id) {
        return this.statisticsMap.get(id);
    }

    public void remove(long id) {
        this.statisticsMap.remove(id);
        LOGGER.info("Removed statistics for id: {}", id);
    }
}