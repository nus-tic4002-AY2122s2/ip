package seedu.duke;

import java.util.Scanner;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static final String errorUnknown = "☹ OOPS!!! I'm sorry, but I don't know what that means :-(";

    public static void main(String[] args) {
        String logo = "    ___     ______  \n"
                + "   /   \\    |     | \n"
                + "  /  _  \\   |_____| \n"
                + " /  |_|  \\  |  \\    \n"
                + "/         \\ |   \\   \n";
        System.out.println("Hi I’m AIR REC\n" + logo);
        System.out.println("I can help you save all the flight details!");
        System.out.println("How can I assist you today?");

        //Scanner in = new Scanner(System.in);
        //System.out.println("Hello " + in.nextLine());

        while (echo()) {
        }
    }


    public static boolean echo() {

        String userInput;
        Scanner scan = new Scanner(System.in);
        userInput = scan.nextLine();

        switch (userInput) {
        case "bye":
            System.out.println("Bye. Your tasks has been saved.\n Hope to see you again soon!");
            return false;
        default:
            System.out.println(errorUnknown);
            return false;
        }
    }
}