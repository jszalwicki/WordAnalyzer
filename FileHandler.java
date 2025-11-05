package org.WordAnalyzer;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {

    private final String fileName;

    public FileHandler(String fn){
        this.fileName = fn;
    }
    public String getFileContents() throws FileNotFoundException, IOException, Exception{
        String contents;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line = bufferedReader.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
            contents = sb.toString();
            bufferedReader.close();
        }
        catch(FileNotFoundException e1) {
            throw new FileNotFoundException("File not found by FileHandler");
        }
        catch(IOException e2) {
            throw new IOException("I/O error in FileHandler");
        }
        catch(Exception e3) {
            throw new Exception("Something went wrong in FileHandler");
        }
        return contents;
    }
}
