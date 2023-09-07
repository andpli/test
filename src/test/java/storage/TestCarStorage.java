package storage;
import dto.Car;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCarStorage {
    @Test void checkCars() throws IOException, IllegalAccessException, ParseException {

       CarStorage myCar = new CarStorage("src/test/resources/DataCars.txt");
       Car findCar = myCar.findByBrand("BMW");
       assertEquals("BMW", findCar.getBrand());
       assertEquals("X6M", findCar.getModel());
      // Car noCar = myCar.findByBrand("Test");
      // assertEquals("", noCar.getNotNullBrand());
    }
}