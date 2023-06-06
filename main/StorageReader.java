package main;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public interface StorageReader {

    String getSeparator();

    String getPath();

    default void getInfoFromFile(String path) throws IOException{
        if (path.equals("")) {path = getPath();}
        FileReader fr = new FileReader(path);
        Scanner scan1 = new Scanner(fr);
        Map<String,Integer> fields = null;
        Map<Integer,String> values;
        int i = 1;
        String text;
        while (scan1.hasNextLine()) {
            text = scan1.nextLine();
            if (i == 1) {fields = getNumberOfFields(text);}
            else { values = doParsing(text, fields);
                   addToStorage(i, values);}
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

    Map<Integer, String> doParsing(String line, Map<String, Integer> fields);


    void addToStorage(int lineNo, Map<Integer, String> values);
}
