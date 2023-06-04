package main;

import dto.Car;
import storage.CarStorage;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UIMain extends CarStorage {

    public UIMain() throws IOException {

    }

    public void sort(){
        System.out.println("***Sort   1-BrandUp;2-BrandDown,3-YearUp;4-YearDown;5-MileageUp;6-MileageDown");
        Scanner scan2 = new Scanner(System.in);
        int number = scan2.nextInt();
        System.out.println ("Your number is " + number);
        List<Car> listCars = getCars();
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
        List<Car> carsByYear = null;
        switch (number) {
            case 1: ourCar = findByBrand(value); break;
            case 2: ourCar = findByModel(value); break;
            case 3: carsByYear = findByYear(value); break;
            case 4: ourCar = findByMileage(value); break;
        }
        if (number == 3) {new PrintCars(carsByYear);}
        else {new PrintCar(ourCar);}
    }
    public void compare(String a, String b){
        List<Car> listCars = getCars();
        Car myCar = new Car(10000, a , b , 2030, 111111);
        System.out.println ("Comparing... ");
        for (Car each : listCars ){

            if (each.equals(myCar)) {
               System.out.println(each);
            }
        }

    }

}
