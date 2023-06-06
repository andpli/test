package dto;

public class Car implements Comparable<Car>{
    private int id;
    private String brand;
    private String model;
    private Integer year;
    private Integer mileage;
    public Car (int i, String a, String b, Integer y, Integer m) {
        this.id = i;
        this.brand = a;
        this.model = b;
        this.year = y;
        this.mileage = m;
    }

    @Override
    public int hashCode() {
        int result = model == null ? 0 : model.hashCode();
        result = 31 * result + (brand == null ? 0 : brand.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        if ((model == null && car.model != null) || (model != null && car.model == null) ||
            (brand == null && car.brand != null) || (brand != null && car.brand == null))
            return false;

        return  model.equals(car.model) && brand.equals(car.brand);
    }

    public int getId() {
        return id;
    }
    public String getBrand() {
        return brand;
    }

    public String getNotNullBrand() {
        return brand == null ? "" : brand;
    }

    public String getModel() { return model; }
    public String getNotNullModel() {
        return model == null ? "" : model;
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