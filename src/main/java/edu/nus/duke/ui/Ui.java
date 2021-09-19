package edu.nus.duke.ui;

import java.util.Scanner;

/**
 * Class that deals with interactions with the user
 */
public class Ui {
    // Variables
    private Scanner scanner;

    // Constructor
    public Ui() {
        scanner = new Scanner(System.in);
    }

    // Methods
    /**
     * Print a message and separator line to {@code System.out}.
     *
     * @param message String to be printed.
     */
    public static void printMessage(String message) {
        printMessage(message, true);
    }

    /**
     * Print a message and optional separator line to {@code System.out}.
     *
     * @param message String to be printed.
     * @param isSepLine Boolean to switch on/off seperator line.
     */
    public static void printMessage(String message, Boolean isSepLine) {
        System.out.println(message);
        if (isSepLine) {
            System.out.println("____________________________________________________________");
        }
    }

    /**
     * Print a message and exit the app.
     *
     * @param message String to be printed.
     */
    public static void printMessage_Exit(String message) {
        printMessage(message);
        System.exit(1);
    }

    /**
     * Return a string from user input.
     *
     * @return string from user input.
     */
    public String getUserInput() {
        return (scanner.nextLine());
    }
}
