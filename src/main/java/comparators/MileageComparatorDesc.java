package comparators;
import dto.Car;
import java.util.Comparator;

public class MileageComparatorDesc implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o2.getMileage() - o1.getMileage();
    }
}