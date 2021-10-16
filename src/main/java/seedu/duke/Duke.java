package seedu.duke;

import java.util.ArrayList;
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
                        System.out.println(flightList.getList().get(i).flightDetails);
                    }
                    break;
                case "delete":
                    flightList.deleteFlight(userInput);
                    System.out.println("Your flight has been deleted.\n" + "You have " + flightList.getSize()
                                + " flights in your record");
                    break;
                case "help":
                    System.out.println("Do email us at support@airrec.com. See you!");
                    break;
                case "search":
                    if (userInput.equals("search")) {
                        System.out.println("☹ OOPS!!! There is nothing to find.");
                    } else {
                        ArrayList<Flight> tempList = flightList.searchFlight(userInput);

                        if (tempList.size() > 0) {
                            System.out.println("Here are the matching flights in your list:");
                            for (Flight flight : tempList) {
                                System.out.println(flight.getFlightDetails());
                            }
                        } else {
                            System.out.println("There is no matching task in your list.");
                        }
                    }
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