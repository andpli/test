import main.UIMain;
import storage.PersonStorage;

public class TestFiles {
    public static void main(String[] args) throws Exception {

        UIMain myUI =  new UIMain();
        myUI.sort();
    //    myUI.find();
     //   myUI.compare("Toyota","Corolla");

       PersonStorage my =  new PersonStorage();
       System.out.println(my.getPersons());
    }
}
