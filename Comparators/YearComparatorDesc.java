package comparators;
import main.Car;
import java.util.Comparator;

public class YearComparatorDesc implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o2.getYear() - o1.getYear();
    }
}