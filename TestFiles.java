import main.Car;
import main.CarStorage;

public class TestFiles {
    public static void main(String[] args) throws Exception {
        CarStorage myCars =  new CarStorage();
        myCars.sort();
        myCars.find();
    }
}