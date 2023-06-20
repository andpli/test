package storage;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public interface StorageReader {

    String getSeparator();

    String getPath();

    default void getInfoFromFile(String path) throws IOException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        FileReader fr = new FileReader(path);
        Scanner scan1 = new Scanner(fr);
        Map<String,Integer> fields = null;
       // Map<String,String> values;
        int i = 1;
        String text;
        while (scan1.hasNextLine()) {
            text = scan1.nextLine();
            if (i == 1) {fields = getNumberOfFields(text);}
            else { doParsing(text, fields);
                  // addToStorage(values);
            }
            i++;
        }
        fr.close();

    }

    default Map<String, Integer> getNumberOfFields(String text){
      Map<String, Integer> fields = new HashMap<>();
      String[] words = text.split(getSeparator());
      int i = 0;
      for (String each : words ){
          fields.put(each, i);
          i++;
      }
      return fields;
    }

    void doParsing(String line, Map<String, Integer> fields) throws IllegalAccessException;

   }
