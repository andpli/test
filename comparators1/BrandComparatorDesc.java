package comparators;
import main.Car;
import java.util.Comparator;

public class BrandComparatorDesc implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o2.getBrand().compareTo(o1.getBrand());
    }
}
