package storage;

import dto.Person;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class PersonStorage extends MainStorage {
    private List<Person> persons = new ArrayList<>();
    public List<Person> getPersons() {
        return persons;
    }
    public PersonStorage() throws IOException, NoSuchFieldException, IllegalAccessException, InstantiationException {
       getInfoFromFile(getPath());
    }
    public PersonStorage(String path) throws IOException, NoSuchFieldException, IllegalAccessException, InstantiationException {
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
    public void addToStorage(Map<String,String> values) throws IllegalAccessException {

     //   persons.add(new Person(values.get("firstName"),
     //                          values.get("lastName")));

        Person pers = new Person();
        Class<? extends Person> personClass = pers.getClass();
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field :declaredFields) {
             field.setAccessible(true);
             field.set(pers,values.get(field.getName()));
         }
         persons.add(pers);
    }

    @Override
    public List<String> getFieldsName() {
        return Arrays.asList("firstName", "lastName");
    }
}
