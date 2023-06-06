package storage;

import dto.Person;
import main.StorageReader;

import java.io.IOException;
import java.util.*;

public class PersonStorage extends MainStorage implements StorageReader {
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
    public Map<Integer, String> doParsing(String line, Map<String, Integer> fields) {

        int i = 0;
        String lcValue;
        Map<Integer, String> values = new HashMap<>();
        String[] words = line.split(getSeparator());
        for (String each : getFieldsName() ){
            Integer liIndex = fields.get(each);
            lcValue = "";
            if (liIndex != null) { lcValue = words[liIndex];}

            values.put(i, lcValue);
            i++;
        }
        return values;

    }

    @Override
    public void addToStorage(int lineNo, Map<Integer, String> values) {
        persons.add(new Person(values.get(0), values.get(1)));
    }

    @Override
    public List<String> getFieldsName() {
        return Arrays.asList("lastName", "lastName");
    }
}
