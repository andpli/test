package storage;
import comparators.*;
import dto.Car;

import java.io.IOException;
import java.util.*;


public class CarStorage implements main.ReaderOfFiles {

    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public CarStorage() throws IOException {
        cars.add(new Car(99999, null,null, 111, 4444));
        getInfoFromFile();
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
    int liYear = -1;
    int liMileage = -1;
    int liBrand= -1;
    int liModel= -1;
    @Override

    public void getNumberOfFields(String line) {
        String[] words = line.split(getSeparator());
        int li = 0;
        for (String each : words ){
            switch (each)
            {
                case "year" :    liYear    = li; break;
                case "mileage" : liMileage = li; break;
                case "brand" :   liBrand   = li; break;
                case "model" :   liModel   = li;
            }
            li++;
        }
    }

    @Override
    public void doParsing(String line, int i) {
        String[] words = line.split(getSeparator());
        int year = 0;
        int mileage = 0;
        String model = "";
        String brand = "";
        if (liYear >= 0) { year = Integer.parseInt(words[liYear]);}
        if (liMileage >= 0) { mileage = Integer.parseInt(words[liMileage]);}
        if (liModel >= 0) { model = words[liModel];}
        if (liBrand >= 0) { brand = words[liBrand];}
        cars.add(new Car(i, brand, model, year, mileage));

    }
}


