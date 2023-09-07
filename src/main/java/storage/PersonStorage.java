package storage;

import dto.Person;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PersonStorage extends AbstractStorage<Person> {

    public List<Person> getPersons() {
        return entities;
    }
    public PersonStorage() throws IOException, IllegalAccessException, ParseException {
       getInfoFromFile(getPath());
    }
    public PersonStorage(String path) throws IOException, IllegalAccessException, ParseException {
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
        return "DataPersons.txt";
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
    protected Person newRow(Map<String, String> values) throws IllegalAccessException, ParseException {
        Person pers = new Person();
        Class<? extends Person> personClass = pers.getClass();
        Field[] declaredFields = personClass.getDeclaredFields();
        String str = "java.util.Date";
        for (Field field :declaredFields) {
            field.setAccessible(true);

            if (str.equals(field.getAnnotatedType().getType().getTypeName()))


            {field.set(pers, new SimpleDateFormat("dd/mm/yyyy").parse(values.get(field.getName())));} else
            {field.set(pers,values.get(field.getName()));}
        }
        return pers;
    }

    @Override
    public List<String> getFieldNames() {
        return Arrays.asList("firstName", "lastName", "dateOfBirth");
    }
}
