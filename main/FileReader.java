package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public interface FileReader {

    String getSeparator();

    String getPath();

    default void getInfoFromFile() throws IOException{
        java.io.FileReader fr = new java.io.FileReader(getPath());
        Scanner scan1 = new Scanner(fr);
        int i = 1;
        String text;
        while (scan1.hasNextLine()) {
            text = scan1.nextLine();
            doParsing(text, i);
            i++;
        }
        fr.close();

    };
    void doParsing(String line, int lineNo);
}
