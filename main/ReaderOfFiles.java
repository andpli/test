package main;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public interface ReaderOfFiles {

    String getSeparator();

    String getPath();

    default void getInfoFromFile() throws IOException{
        FileReader fr = new FileReader(getPath());
        Scanner scan1 = new Scanner(fr);
        Map<String,Integer> fields = null;
        int i = 1;
        String text;
        while (scan1.hasNextLine()) {
            text = scan1.nextLine();
            if (i == 1) {fields = getNumberOfFields(text);}
            else { doParsing(text, i, fields); }
            i++;
        }
        fr.close();

    }

    default Map getNumberOfFields(String text){
      Map<String, Integer> fields = new HashMap<>();
      String[] words = text.split(getSeparator());
      int i = 0;
      for (String each : words ){
          fields.put(each, i);
          i++;
      }
      return fields;
    }

    void doParsing(String line, int lineNo, Map<String, Integer> fields);
}
