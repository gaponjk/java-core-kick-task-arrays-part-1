package com.haponenka.app;

import com.haponenka.app.entity.ArrayStatistics;
import com.haponenka.app.entity.CustomArray;
import com.haponenka.app.event.ArrayEvent;
import com.haponenka.app.exception.CustomArrayException;
import com.haponenka.app.factory.CustomArrayFactory;
import com.haponenka.app.factory.impl.CustomArrayFactoryImpl;
import com.haponenka.app.observer.ArrayObserver;
import com.haponenka.app.observer.impl.ArrayObserverImpl;
import com.haponenka.app.parser.CustomParser;
import com.haponenka.app.parser.impl.CustomParserImpl;
import com.haponenka.app.reader.CustomFileReader;
import com.haponenka.app.reader.impl.CustomFileReaderImpl;
import com.haponenka.app.repository.CustomArrayRepository;
import com.haponenka.app.repository.impl.CustomArrayRepositoryImpl;
import com.haponenka.app.service.ArrayService;
import com.haponenka.app.service.ArraySortService;
import com.haponenka.app.service.impl.ArrayServiceImpl;
import com.haponenka.app.service.impl.ArraySortServiceImpl;
import com.haponenka.app.validator.ArrayLineValidator;
import com.haponenka.app.validator.impl.ArrayLineValidatorImpl;
import com.haponenka.app.warehouse.ArrayWarehouse;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayApp {

  private static final Logger LOGGER = LogManager.getLogger(ArrayApp.class);
  private static final String DATA_FILE_PATH = "data/arrays.txt";

  public static void main(String[] args) {
    LOGGER.info("Application started");

    CustomFileReader fileReader = new CustomFileReaderImpl();
    ArrayLineValidator validator = new ArrayLineValidatorImpl();
    CustomParser parser = new CustomParserImpl(validator);
    CustomArrayFactory factory = new CustomArrayFactoryImpl();
    ArrayService arrayService = new ArrayServiceImpl();
    ArraySortService sortService = new ArraySortServiceImpl();

    List<String> lines;
    try {
      lines = fileReader.readLines(DATA_FILE_PATH);
    } catch (CustomArrayException e) {
      LOGGER.error("Failed to read input data file: {}", DATA_FILE_PATH, e);
      return;
    }

    for (String line : lines) {
      boolean isValid = validator.isValid(line);
      if (isValid) {
        try {
          int[] elements = parser.parseLineToIntArray(line);
          CustomArray customArray = factory.createCustomArray(elements);
          LOGGER.info("Successfully processed array: {}", customArray);

          OptionalInt minOptional = arrayService.findMin(customArray);
          if (minOptional.isPresent()) {
            int min = minOptional.getAsInt();
            LOGGER.info("Min: {}", min);
          }

          OptionalInt maxOptional = arrayService.findMax(customArray);
          if (maxOptional.isPresent()) {
            int max = maxOptional.getAsInt();
            LOGGER.info("Max: {}", max);
          }

          OptionalInt sumOptional = arrayService.calculateSum(customArray);
          if (sumOptional.isPresent()) {
            int sum = sumOptional.getAsInt();
            LOGGER.info("Sum: {}", sum);
          }

          OptionalDouble averageOptional = arrayService.calculateAverage(customArray);
          if (averageOptional.isPresent()) {
            double avg = averageOptional.getAsDouble();
            LOGGER.info("Average: {}", avg);
          }

          sortService.bubbleSort(customArray);
          LOGGER.info("After bubble sort: {}", customArray);
        } catch (CustomArrayException e) {
          LOGGER.error("Error creating or processing array for line: {}", line, e);
        }
      } else {
        LOGGER.warn("Skipping invalid line: {}", line);
      }
    }
    LOGGER.info("Application completed successfully");
    ArrayObserver observer = new ArrayObserverImpl();

    // 2. Создание массива с регистрацией в Observer
    CustomArray array1 = new CustomArray("1", 10, 20, 30);
    array1.attach(observer);

    // 3. Первичная инициализация в Warehouse
    observer.update(new ArrayEvent(array1));

    // 4. Добавление в репозиторий
    CustomArrayRepository repository = CustomArrayRepositoryImpl.getInstance();
    repository.add(array1);

    // 5. Любое изменение элемента автоматически пересчитает Warehouse
    array1.setElement(0, 100);

    // 6. Проверка обновленных значений из Warehouse
    ArrayStatistics stats = ArrayWarehouse.getInstance().get("1");
    LOGGER.info("New max in Warehouse: {}", stats.getMax()); // Будет 100
  }
}
