public class Car implements Comparable<Car>{
    public int id;
    public String brand;
    public String model;
    public int year;
    public int mileage;
    Car (int i, String a, String b, int y, int m) {
        this.id = i;
        this.brand = a;
        this.model = b;
        this.year = y;
        this.mileage = m;
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