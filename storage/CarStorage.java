package storage;
import comparators.*;
import dto.Car;
import main.StorageReader;

import java.io.IOException;
import java.util.*;



public class CarStorage extends MainStorage {

    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public CarStorage() throws IOException {
      //  cars.add(new Car(99999, null,null, 111, 4444));
        getInfoFromFile("");
    }
    public CarStorage(String path) throws IOException {
        getInfoFromFile(path);
    }
    public List<Car> sortByBrand(){
        Comparator selectComparator = new BrandComparator();
        Collections.sort(cars, selectComparator);
        return cars;
    }
    public List<Car> sortByBrandDesc(){
        Comparator selectComparator = new BrandComparatorDesc();
        Collections.sort(cars, selectComparator);
        return cars;
    }
    public List<Car> sortByYear(){
        Comparator selectComparator = new YearComparator();
        Collections.sort(cars, selectComparator);
        return cars;
    }
    public List<Car> sortByYearDesc(){
        Comparator selectComparator = new YearComparatorDesc();
        Collections.sort(cars, selectComparator);
        return cars;
    }
    public List<Car> sortByMileage(){
        Comparator selectComparator = new MileageComparator();
        Collections.sort(cars, selectComparator);
        return cars;
    }
    public List<Car> sortByMileageDesc(){
        Comparator selectComparator = new MileageComparatorDesc();
        Collections.sort(cars, selectComparator);
        return cars;
    }
    public Car findByBrand(String value){
        for (Car each : cars ){
            if ((value.equals(each.getBrand()))) {
                return each;
            }
        }
        return null;
    }
    public Car findByModel(String value){
        for (Car each : cars ){
            if ((value.equals(each.getModel()))) {
                return each;
            }
        }
        return null;
    }

    public List<Car> findByYear(String value){
        List<Car> local = new ArrayList<>();
        for (Car each : cars ){
            if ((each.getYear() == Integer.parseInt(value))) {
                local.add(each);
            }
        }
        return local;
    }
    public Car findByMileage(String value){
        for (Car each : cars ){
            if ((each.getMileage() == Integer.parseInt(value))) {
               return each;
            }
        }
        return null;
    }

    @Override
    public String getSeparator() {
        return ";";
    }

    @Override
    public String getPath() {
        return "D:\\IdeaProjects\\test\\DataCars.txt";
    }

    @Override
    public void addToStorage(int lineNo, Map<Integer, String> values) {
        cars.add(new Car(lineNo, values.get(0), values.get(1),
                Integer.parseInt(values.get(2)), Integer.parseInt(values.get(3))));
    }

    @Override
    public List<String> getFieldsName() {
        return Arrays.asList("brand", "model", "year", "mileage");
    }
}


