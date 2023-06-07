package storage;

import main.StorageReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MainStorage implements StorageReader {
    public abstract List<String> getFieldsName();


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
    };
