import java.util.Comparator;

public class BrandComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.brand.compareTo(o2.brand);
    }
}
