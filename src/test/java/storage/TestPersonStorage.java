package storage;
import dto.Person;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPersonStorage {
    @Test void checkPersons() throws IOException, NoSuchFieldException, IllegalAccessException, InstantiationException, ParseException {
        PersonStorage myPersons = null;
        myPersons = new PersonStorage("src/test/resources/DataPersons.txt");
        Person findPerson = myPersons.findByLastName("Temple");
       assertEquals("Temple", findPerson.getLastName());
       assertEquals("Andy", findPerson.getFirstName());
    }
}