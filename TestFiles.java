import java.io.FileReader;
import java.util.*;
public class TestFiles {

    public static void main(String[] args) throws Exception {

        FileReader fr = new FileReader("Data.txt");
        Scanner scan1 = new Scanner(fr);

        int i = 1;

        String text;
        List<Car> cars = new ArrayList<>();
        while (scan1.hasNextLine()) {
            text = scan1.nextLine();
            String[] words = text.split(";");
            int year = Integer.parseInt(words[2]);
            int mileage = Integer.parseInt(words[3]);
            cars.add(new Car(i, words[0], words[1], year, mileage));
            i++;
           // test.show();
        }

        fr.close();

       // Collections.sort(cars);

        System.out.println("***Sort   1-BrandUp;2-BrandDown,3-YearUp;4-YearDown;5-MileageUp;6-MileageDown");
        Scanner scan2 = new Scanner(System.in);
        int number = scan2.nextInt();
        System.out.println ("Your number is " + number);

        Comparator selectComparator;
        switch (number) {
            case 1: selectComparator = new BrandComparator(); break;
            case 2: selectComparator = new BrandComparatorDesc(); break;
            case 3: selectComparator = new YearComparator(); break;
            case 4: selectComparator = new YearComparatorDesc(); break;
            case 5: selectComparator = new MileageComparator(); break;
            case 6: selectComparator = new MileageComparatorDesc(); break;
            default: System.out.println ("**** Sort by Id ****");
                     selectComparator = new BrandComparator();
        }
        if (number >= 1 && number <=6) {
          Collections.sort(cars, selectComparator);}
        System.out.println(cars);

        System.out.println("***Find   1-Brand;2-Model;3-Year;4-Mileage");
        number = scan2.nextInt();
        System.out.println ("Your number is " + number + ". Please enter value ");

        Scanner scan3 = new Scanner(System.in);
        String value = scan3.nextLine();
        for ( Car each : cars ){
            if ((each.brand.equals(value) && number == 1) || (each.model.equals(value) && number == 2) ||
                (number == 3 && each.year == Integer.parseInt(value) )  ||
                (number == 4 && each.mileage == Integer.parseInt(value) ))
            {
                System.out.println(each); }
        }
    }
}