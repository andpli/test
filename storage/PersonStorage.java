package storage;

import dto.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonStorage implements main.ReaderOfFiles {
    private List<Person> persons = new ArrayList<>();
    public List<Person> getPersons() {
        return persons;
    }
    public PersonStorage() throws IOException {
        getInfoFromFile();
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
    public void doParsing(String line, int lineNo, Map<String, Integer> fields) {
        int liFirst = fields.getOrDefault("firstName",-1);
        int liLast = fields.getOrDefault("lastName",-1);
        String firstName = "";
        String lastName = "";
        String[] words = line.split(getSeparator());
        if (liFirst >= 0) { firstName = words[liFirst];}
        if (liLast >= 0) { lastName = words[liLast];}
        persons.add(new Person(firstName, lastName));
    }

}
