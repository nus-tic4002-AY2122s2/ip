package edu.nus.duke.ui;

/**
 * Class that deals with interactions with the user
 */
public class Ui {
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
    public static void printMessageExit(String message) {
        printMessage(message);
        System.exit(1);
    }
}
