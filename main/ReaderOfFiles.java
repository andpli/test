package main;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public interface ReaderOfFiles {

    String getSeparator();

    String getPath();

    default void getInfoFromFile() throws IOException{
        FileReader fr = new FileReader(getPath());
        Scanner scan1 = new Scanner(fr);
        int i = 1;
        String text;
        while (scan1.hasNextLine()) {
            text = scan1.nextLine();
            if (i == 1) {getNumberOfFields(text);}
            else { doParsing(text, i); }
            i++;
        }
        fr.close();

    }

    void getNumberOfFields(String text);

    ;
    void doParsing(String line, int lineNo);
}
