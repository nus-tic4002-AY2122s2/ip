package edu.nus.duke.ui;

public class Ui {
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
}
