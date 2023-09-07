package storage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractStorage<T> implements StorageReader {
    protected List<T> entities = new ArrayList<>();
    protected abstract List<String> getFieldNames();

    protected abstract T newRow(Map<String, String> values) throws IllegalAccessException, ParseException;

    public void doParsing(String line, Map<String, Integer> fields) throws IllegalAccessException, ParseException {

            String lcValue;
            Map<String, String> values = new HashMap<>();
            String[] words = line.split(getSeparator());
            for (String each : getFieldNames() ){
                Integer liIndex = fields.get(each);
                lcValue = "";
                if (liIndex != null) { lcValue = words[liIndex];}

                values.put(each, lcValue);
            }
            entities.add(newRow(values));
        }
    };
