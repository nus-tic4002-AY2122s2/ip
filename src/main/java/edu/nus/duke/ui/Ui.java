package edu.nus.duke.ui;

import java.util.Scanner;

public class Ui {
    // Variables
    private Scanner scanner;

    // Constructor
    public Ui() {
        scanner = new Scanner(System.in);
    }

    // Methods
    public static void printMessage(String message) {
        printMessage(message, true);
    }

    public static void printMessage(String message, Boolean isSepLine) {
        System.out.println(message);
        if (isSepLine) {
            System.out.println("____________________________________________________________");
        }
    }

    public static void printMessage_Exit(String message) {
        printMessage(message);
        System.exit(1);
    }

    public String getUserInput() {
        return (scanner.nextLine());
    }
}
