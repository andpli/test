package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonStorage implements main.FileReader {
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
    public void doParsing(String line, int lineNo) {
        String[] words = line.split(getSeparator());
        persons.add(new Person(words[0], words[1]));
    }
}
