package comparators;
import dto.Car;
import java.util.Comparator;

public class BrandComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        if ((o1.getBrand() == null) && (o2.getBrand() == null)) return 0;
        if (o1.getBrand() == null) return -1;
        if (o2.getBrand() == null) return 1;
        return o1.getBrand().compareTo(o2.getBrand());
    }
}
