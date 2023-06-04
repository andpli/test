package storage;

import dto.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public void doParsing(String line, int lineNo) {
        String firstName = "";
        String lastName = "";
        String[] words = line.split(getSeparator());
        if (liFirst >= 0) { firstName = words[liFirst];}
        if (liLast >= 0) { lastName = words[liLast];}
        persons.add(new Person(firstName, lastName));
    }
    int liFirst = -1;
    int liLast = -1;
    @Override
    public void getNumberOfFields(String line) {
        String[] words = line.split(getSeparator());
        int li = 0;
        for (String each : words ){
            switch (each)
            {
                case "firstName" : liFirst = li; break;
                case "lastName" : liLast  = li;
            }
            li++;
        }
    }
}
