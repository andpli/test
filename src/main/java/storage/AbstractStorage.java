package storage;

import dto.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractStorage<T> implements StorageReader {
    protected List<T> entities = new ArrayList<>();
    protected abstract List<String> getFieldsName();

    protected abstract T newRow(Map<String, String> values) throws IllegalAccessException;

    public void doParsing(String line, Map<String, Integer> fields) throws IllegalAccessException {

            String lcValue;
            Map<String, String> values = new HashMap<>();
            String[] words = line.split(getSeparator());
            for (String each : getFieldsName() ){
                Integer liIndex = fields.get(each);
                lcValue = "";
                if (liIndex != null) { lcValue = words[liIndex];}

                values.put(each, lcValue);

            }
            entities.add(newRow(values));
           // return values;

        }
    };
