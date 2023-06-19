package storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractStorage<T> implements StorageReader {
    public List<T> entity = new ArrayList<>();
    public abstract List<String> getFieldsName();



    public Map<String,String> doParsing(String line, Map<String, Integer> fields) {

            String lcValue;
            Map<String, String> values = new HashMap<>();
            String[] words = line.split(getSeparator());
            for (String each : getFieldsName() ){
                Integer liIndex = fields.get(each);
                lcValue = "";
                if (liIndex != null) { lcValue = words[liIndex];}

                values.put(each, lcValue);

            }
            return values;

        }
    };
