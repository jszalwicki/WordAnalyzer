package org.WordAnalyzer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        int input;
        String text ="", filename;
        Scanner scanner = new Scanner(System.in);
        CliHandler cliHandler = new CliHandler();
        WordAnalyzer wordAnalyzer;

        CliHandler.printInstructions();
        input = cliHandler.getOption(scanner);
        while(input != 1 && input != 2) {
            CliHandler.printInstructions();
            input = cliHandler.getOption(scanner);
        }

        if (input == 1) {
            CliHandler.askForInput();
            text = cliHandler.getText(scanner);
        }
        else {
            CliHandler.askForFilePath();
            filename = cliHandler.getText(scanner);
            FileHandler fileHandler = new FileHandler(filename);
            try {
                text = fileHandler.getFileContents();
            }
            catch(FileNotFoundException e1) {
                CliHandler.printExceptionInfo(e1);
            }
            catch(IOException e2) {
                CliHandler.printExceptionInfo(e2);
            }
            catch(Exception e3) {
                CliHandler.printExceptionInfo(e3);
            }
        }
        wordAnalyzer = new WordAnalyzer(text);
        System.out.println(wordAnalyzer.getAnalysis());
        //4 - save result to a file
    }
}