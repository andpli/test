package storage;

import dto.Person;
import main.StorageReader;

import java.io.IOException;
import java.util.*;

public class PersonStorage extends MainStorage {
    private List<Person> persons = new ArrayList<>();
    public List<Person> getPersons() {
        return persons;
    }
    public PersonStorage() throws IOException {
        getInfoFromFile("");
    }
    public PersonStorage(String path) throws IOException {
        getInfoFromFile(path);
    }
    @Override
    public String getSeparator() {
        return ",";
    }

    @Override
    public String getPath() {
        return "D:\\IdeaProjects\\test\\DataPersons.txt";
    }

     @Override
    public void addToStorage(int lineNo, Map<Integer, String> values) {
        persons.add(new Person(values.get(0), values.get(1)));
    }

    @Override
    public List<String> getFieldsName() {
        return Arrays.asList("firstName", "lastName");
    }
}
