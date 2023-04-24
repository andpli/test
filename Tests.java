import main.Car;

public class Tests {
    public  Tests() {

   Car my001 = new Car(1,null, null, 1,1);
   Car my002 = new Car(2,null, "", 1,1);
   Car my003 = new Car(3,"", null, 1,1);
   Car my004 = new Car(4,"", "", 1,1);
   Car my005 = new Car(5,"A1", "A2", 1,1);
   Car my006 = new Car(6,"A1", "A2", 1,1);
   Car my007 = new Car(7,"A1", "A2", 1,1);
   Car my008 = new Car(8,"A1", "B2", 1,1);
   Car my009 = new Car(9,"B1", "A2", 1,1);
   Car my010 = new Car(10,"B1", "B2", 1,1);

    System.out.println("Reflexive ...");
    System.out.println(my001.equals(my001));
    System.out.println(my002.equals(my002));
    System.out.println(my003.equals(my003));
    System.out.println(my004.equals(my004));
    System.out.println(my005.equals(my005));
    System.out.println(my006.equals(my006));

    System.out.println("");
    System.out.println("Symmetric  ...");
    System.out.println(my001.equals(my002));
    System.out.println(my002.equals(my001));
    System.out.println(my003.equals(my004));
    System.out.println(my004.equals(my003));
    System.out.println(my005.equals(my006));
    System.out.println(my006.equals(my005));
    System.out.println(my007.equals(my008));
    System.out.println(my008.equals(my007));

    System.out.println("");
    System.out.println("Transitive  ...");
    System.out.println(my005.equals(my006));
    System.out.println(my006.equals(my007));
    System.out.println(my005.equals(my007));

    System.out.println("");
    System.out.println("Consistent  ...");
    System.out.println(my005.equals(my006));
    System.out.println(my005.equals(my006));
    System.out.println(my005.equals(my006));
    System.out.println(my005.equals(my006));
    System.out.println(my005.equals(my006));

    System.out.println(my003.equals(my004));
    System.out.println(my003.equals(my004));
    System.out.println(my003.equals(my004));
    System.out.println(my003.equals(my004));
    System.out.println(my003.equals(my004));


    System.out.println("");
    System.out.println("Non-nullity  ...");
    System.out.println(my001.equals(null));
    System.out.println(my002.equals(null));
    System.out.println(my003.equals(null));
    System.out.println(my004.equals(null));
    System.out.println(my009.equals(null));
    System.out.println(my0010.equals(null));

    }
}