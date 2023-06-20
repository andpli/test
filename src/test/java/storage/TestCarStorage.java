package storage;
import dto.Car;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCarStorage {
    @Test void checkCars() throws IOException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        CarStorage myCar = null;
        myCar = new CarStorage("D:\\IdeaProjects\\test\\src\\test\\java\\resources\\DataCars.txt");
        Car findCar = myCar.findByBrand("BMW");
        assertEquals("BMW", findCar.getBrand());
        assertEquals("X6M", findCar.getModel());

    }
}