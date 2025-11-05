package org.WordAnalyzer;

import java.util.Scanner;

public class CliHandler {

    public String getText(Scanner scanner){
        return scanner.nextLine() + scanner.nextLine(); //somehow works, while single scanner.nextLine() fails, possibly because of nextInt used before this.
    }
    public int getOption(Scanner scanner){
        return scanner.nextInt();
    }
    public static void printInstructions() {
        System.out.println("Choose an option: \n1 - Command line input\n2 - Input from .txt file");
    }
    public static void askForFilePath() {
        System.out.println("Enter the file path:\n");
    }
    public static void askForInput() {
        System.out.println("Type your input and press enter:\n");
    }
    public static void printExceptionInfo(Exception e){
        System.out.println(e.getMessage());
    }
}
