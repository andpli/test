package storage;
import dto.Person;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPersonStorage {
    @Test void checkPersons() throws IOException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        PersonStorage myPersons = null;
        myPersons = new PersonStorage("D:\\IdeaProjects\\test\\src\\test\\java\\resources\\DataPersons.txt");
        Person findPerson = myPersons.findByLastName("Temple");
        assertEquals("Temple", findPerson.getLastName());
        assertEquals("Andy", findPerson.getFirstName());
    }
}