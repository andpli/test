package storage;

import dto.Person;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class PersonStorage extends AbstractStorage<Person> {

    public List<Person> getPersons() {
        return entities;
    }
    public PersonStorage() throws IOException, NoSuchFieldException, IllegalAccessException, InstantiationException {
       getInfoFromFile(getPath());
    }
    public PersonStorage(String path) throws IOException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        getInfoFromFile(path);
    }
    public Person findByLastName(String value){
        for (Person each : entities ){
            if ((value.equals(each.getLastName()))) {
                return each;
            }
        }
        return null;
    }
    @Override
    public String getSeparator() {
        return ",";
    }

    @Override
    public String getPath() {
        return "D:\\IdeaProjects\\test\\DataPersons.txt";
    }
/*
     @Override
    public void addToStorage(Map<String,String> values) throws IllegalAccessException {

        persons.add(new Person(values.get("firstName"),
                               values.get("lastName")));

        Person pers = new Person();
        Class<? extends Person> personClass = pers.getClass();
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field :declaredFields) {
             field.setAccessible(true);
             field.set(pers,values.get(field.getName()));
         }
         entities.add(pers);
    }
*/
    @Override
    protected Person newRow(Map<String, String> values) {
        return new Person(values.get("firstName"),
                          values.get("lastName")) ;
    }

    @Override
    public List<String> getFieldsName() {
        return Arrays.asList("firstName", "lastName");
    }
}
