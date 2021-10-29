package seedu.duke;

import java.util.Scanner;

public class Duke {
    /**
     * Main entry-point for the AirRec application.
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

        run();
    }


    public static void run() {

        try {
            FlightList flightList = new FlightList();
            String userInput;
            boolean online = true;

            while (online) {
                Scanner scan = new Scanner(System.in);
                userInput = scan.nextLine().trim();
                String command = new Parser().parseInput(userInput);
                switch (command) {
                case "bye":
                    System.out.println("Bye. Your flights have been recorded.\n Hope to see you again soon!");
                    online = false;
                    break;
                case "add":
                    flightList.addFlight(userInput);
                    System.out.println("Your flight has been added.\n" + "You have " + flightList.getSize()
                                + " flights in your record");
                    break;
                case "show all":
                    for (int i = 0; i < flightList.getSize(); i++) {
                        System.out.println("Flight " + (i + 1) + ": "
                                + flightList.getList().get(i).getFullFlightDetails());
                    }
                    break;
                case "delete":
                    flightList.deleteFlight(userInput);
                    System.out.println("Your flight has been deleted.\n" + "You have " + flightList.getSize()
                                + " flights in your record");
                    break;
                default:
                    System.out.println(errorUnknown);
                }
            }
        } catch (Exception e) {
            System.out.println(errorUnknown);
        }
    }

}