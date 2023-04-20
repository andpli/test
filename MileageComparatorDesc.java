import java.util.Comparator;

public class MileageComparatorDesc implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o2.mileage - o1.mileage;
    }
}