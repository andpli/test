package main;

public class Car implements Comparable<Car>{
    private int id;
    private String brand;
    private String model;
    private int year;
    private int mileage;
    public Car (int i, String a, String b, int y, int m) {
        this.id = i;
        this.brand = a;
        this.model = b;
        this.year = y;
        this.mileage = m;
    }

    public int getId() {
        return id;
    }
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }


    @Override
    public String toString() {
        return "(" + this.id + "-" + this.brand + "-" +
                this.model + "-" + this.year + "-" + this.mileage + ")";
    }

    public void show(){
        System.out.println(this.id + "-" + this.brand + "-" +
                this.model + "-" + this.year + "-" + this.mileage);
    }
    public int compareTo(Car o) {
        return -(this.id - o.id);
    }

}