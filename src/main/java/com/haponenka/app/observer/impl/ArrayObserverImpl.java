package com.haponenka.app.observer.impl;

import com.haponenka.app.entity.ArrayStatistics;
import com.haponenka.app.entity.CustomArray;
import com.haponenka.app.event.ArrayEvent;
import com.haponenka.app.observer.ArrayObserver;
import com.haponenka.app.service.ArrayService;
import com.haponenka.app.service.impl.ArrayServiceImpl;
import com.haponenka.app.warehouse.ArrayWarehouse;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayObserverImpl implements ArrayObserver {
    private static final Logger LOGGER = LogManager.getLogger(ArrayObserverImpl.class);
    private final ArrayService arrayService;

    public ArrayObserverImpl() {
        this.arrayService = new ArrayServiceImpl();
    }

    @Override
    public void update(ArrayEvent event) {
        if (event != null && event.getSource() != null) {
            CustomArray array = event.getSource();
            String id = array.getId();

            OptionalInt minOpt = this.arrayService.findMin(array);
            OptionalInt maxOpt = this.arrayService.findMax(array);
            OptionalInt sumOpt = this.arrayService.calculateSum(array);
            OptionalDouble avgOpt = this.arrayService.calculateAverage(array);

            int min = minOpt.isPresent() ? minOpt.getAsInt() : 0;
            int max = maxOpt.isPresent() ? maxOpt.getAsInt() : 0;
            int sum = sumOpt.isPresent() ? sumOpt.getAsInt() : 0;
            double avg = avgOpt.isPresent() ? avgOpt.getAsDouble() : 0.0;

            ArrayStatistics statistics = new ArrayStatistics(min, max, sum, avg);
            ArrayWarehouse.getInstance().put(id, statistics);
            LOGGER.info("Warehouse statistics updated for array id: {}", id);
        } else {
            LOGGER.warn("Received empty or null array event in observer");
        }
    }
}