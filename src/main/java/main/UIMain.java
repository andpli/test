package main;
    
import dto.Car;
import storage.CarStorage;
import storage.PersonStorage;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class UIMain {
    CarStorage myCar = null;
    public UIMain() throws IOException, NoSuchFieldException, IllegalAccessException, InstantiationException, ParseException {
        myCar =  new CarStorage();
        System.out.println(myCar.getCars());
        PersonStorage myPersons =  new PersonStorage();
        System.out.println(myPersons.getPersons());
    }

    public void sort(){
        System.out.println("***Sort   1-BrandUp;2-BrandDown,3-YearUp;4-YearDown;5-MileageUp;6-MileageDown");
        Scanner scan2 = new Scanner(System.in);
        int number = scan2.nextInt();
        System.out.println ("Your number is " + number);
        List<Car> listCars = myCar.getCars();
        switch (number) {
            case 1: listCars = myCar.sortByBrand(); break;
            case 2: listCars = myCar.sortByBrandDesc(); break;
            case 3: listCars = myCar.sortByYear(); break;
            case 4: listCars = myCar.sortByYearDesc(); break;
            case 5: listCars = myCar.sortByMileage(); break;
            case 6: listCars = myCar.sortByMileageDesc(); break;
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
        List<Car> carsByYear = null;
        switch (number) {
            case 1: ourCar = myCar.findByBrand(value); break;
            case 2: ourCar = myCar.findByModel(value); break;
            case 3: carsByYear = myCar.findByYear(value); break;
            case 4: ourCar = myCar.findByMileage(value); break;
        }
        if (number == 3) {new PrintCars(carsByYear);}
        else {new PrintCar(ourCar);}
    }
    public void compare(String a, String b){
        List<Car> listCars = myCar.getCars();
        Car myCar = new Car( a , b , 2030, 111111);
        System.out.println ("Comparing... ");
        for (Car each : listCars ){

            if (each.equals(myCar)) {
               System.out.println(each);
            }
        }

    }

}
