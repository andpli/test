package main;
import comparators.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class CarStorage  {

    private List<Car> cars = new ArrayList<>();

    public CarStorage() throws IOException {

        FileReader fr = new FileReader("D:\\IdeaProjects\\test\\Data.txt");
        Scanner scan1 = new Scanner(fr);
        int i = 1;

        String text;

        while (scan1.hasNextLine()) {
            text = scan1.nextLine();
            String[] words = text.split(";");
            int year = Integer.parseInt(words[2]);
            int mileage = Integer.parseInt(words[3]);
            cars.add(new Car(i, words[0], words[1], year, mileage));
            i++;
           }
        fr.close();
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
            if ((each.getBrand().equals(value))) {
                return each;
            }
        }
        return null;
    }
    public Car findByModel(String value){
        for (Car each : cars ){
            if ((each.getModel().equals(value))) {
                return each;
            }
        }
        return null;
    }

    public Car findByYear(String value){
        for (Car each : cars ){
            if ((each.getYear() == Integer.parseInt(value))) {
                return each;
            }
        }
        return null;
    }
    public Car findByMileage(String value){
        for (Car each : cars ){
            if ((each.getMileage() == Integer.parseInt(value))) {
               return each;
            }
        }
        return null;
    }

    public void sort(){
        System.out.println("***Sort   1-BrandUp;2-BrandDown,3-YearUp;4-YearDown;5-MileageUp;6-MileageDown");
        Scanner scan2 = new Scanner(System.in);
        int number = scan2.nextInt();
        System.out.println ("Your number is " + number);
        List<Car> listCars = null;
        switch (number) {
            case 1: listCars = sortByBrand(); break;
            case 2: listCars = sortByBrandDesc(); break;
            case 3: listCars = sortByYear(); break;
            case 4: listCars = sortByYearDesc(); break;
            case 5: listCars = sortByMileage(); break;
            case 6: listCars = sortByMileageDesc(); break;
            default: System.out.println ("**** Sort by Id ****");
        }
        new PrintCars(listCars);
    }
    public void find(){
        System.out.println("***Find   1-Brand;2-Model;3-Year;4-Mileage");
        Scanner scan2 = new Scanner(System.in);
        int number = scan2.nextInt();
        System.out.println ("Your number is " + number + ". Please enter value ");

        Scanner scan3 = new Scanner(System.in);
        String value = scan3.nextLine();
        Car ourCar = null;
        switch (number) {
            case 1: ourCar = findByBrand(value); break;
            case 2: ourCar = findByModel(value); break;
            case 3: ourCar = findByYear(value); break;
            case 4: ourCar = findByMileage(value); break;
        }
        PrintCar ourCarPrint = new PrintCar(ourCar);
    }

}


