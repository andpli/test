package main;

import java.util.List;

public class PrintCars {

    public PrintCars(List<Car> ourCar) {
        for (Car each : ourCar ){
            System.out.println(each);
        }
    }
}
