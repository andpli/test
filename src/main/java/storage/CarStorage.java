package storage;
import comparators.*;
import dto.Car;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class CarStorage extends AbstractStorage<Car> {

    public List<Car> getCars() {
        return entities;
    }

    public CarStorage() throws IOException, IllegalAccessException, ParseException {
        entities.add(new Car(null,null, 111, 4444));
        getInfoFromFile(getPath());
    }
    public CarStorage(String path) throws IOException, IllegalAccessException, ParseException {
        getInfoFromFile(path);
    }
    public List<Car> sortByBrand(){
        Comparator selectComparator = new BrandComparator();
        Collections.sort(entities, selectComparator);
        return entities;
    }
    public List<Car> sortByBrandDesc(){
        Comparator selectComparator = new BrandComparatorDesc();
        Collections.sort(entities, selectComparator);
        return entities;
    }
    public List<Car> sortByYear(){
        Comparator selectComparator = new YearComparator();
        Collections.sort(entities, selectComparator);
        return entities;
    }
    public List<Car> sortByYearDesc(){
        Comparator selectComparator = new YearComparatorDesc();
        Collections.sort(entities, selectComparator);
        return entities;
    }
    public List<Car> sortByMileage(){
        Comparator selectComparator = new MileageComparator();
        Collections.sort(entities, selectComparator);
        return entities;
    }
    public List<Car> sortByMileageDesc(){
        Comparator selectComparator = new MileageComparatorDesc();
        Collections.sort(entities, selectComparator);
        return entities;
    }
    public Car findByBrand(String value){
        for (Car each : entities ){
            if ((value.equals(each.getBrand()))) {
                return each;
            }
        }
        return null;
    }
    public Car findByModel(String value){
        for (Car each : entities ){
            if ((value.equals(each.getModel()))) {
                return each;
            }
        }
        return null;
    }

    public List<Car> findByYear(String value){
        List<Car> local = new ArrayList<>();
        for (Car each : entities ){
            if ((each.getYear() == Integer.parseInt(value))) {
                local.add(each);
            }
        }
        return local;
    }
    public Car findByMileage(String value){
        for (Car each : entities ){
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
        return "DataCars.txt";
    }


    @Override
    protected Car newRow(Map<String, String> values) {
        return new Car(values.get("brand"),
                values.get("model"),
                Integer.parseInt(values.get("year")),
                Integer.parseInt(values.get("mileage")));
    }

    @Override
    public List<String> getFieldNames() {
        return Arrays.asList("brand", "model", "year", "mileage");
    }
}


