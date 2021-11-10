package seedu.duke;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    /**
     * Main entry-point for the AirRec application.
     */
    //public static final String errorUnknown = "☹ OOPS!!! I'm sorry, but I don't know what that means :-(";

    public static void main(String[] args) {
        String logo = "    ___     ______  \n"
                + "   /   \\    |     | \n"
                + "  /  _  \\   |_____| \n"
                + " /  |_|  \\  |  \\    \n"
                + "/         \\ |   \\   \n";
        Message.getVal("GREETING",logo);
        /*System.out.println("Hi I’m AIR REC\n" + logo);
        System.out.println("I can help you save all the flight details!");
        System.out.println("How can I assist you today?");*/

        run();
    }


    public static void run() {

        try {
            FlightList flightList = new FlightList();
            String userInput;
            boolean online = true;
            Storage storage = new Storage(flightList);
            storage.readFile();

            while (online) {
                Scanner scan = new Scanner(System.in);
                userInput = scan.nextLine().trim();
                String command = new Parser().parseInput(userInput);
                switch (command) {
                case "bye":
                    Message.getVal("BYE_MESSAGE");
                    //System.out.println("Bye. Your flights have been recorded.\n Hope to see you again soon!");
                    online = false;
                    break;
                case "add":
                    flightList.addFlight(userInput);
                    storage.saveToDB(userInput);
                    Message.getVal("ADDED_SUCCESSFULLY",Integer.toString(flightList.getSize()));
                    /* System.out.println("Your flight has been added.\n" + "You have " + flightList.getSize()
                            + " flights in your record");*/
                    break;
                case "show all":
                    for (int i = 0; i < flightList.getSize(); i++) {
                        System.out.println("Flight " + (i + 1) + ": "
                                + flightList.getList().get(i).getFullFlightDetails());
                    }
                    break;

                case "delete":
                    flightList.deleteFlight(userInput);
                    storage.deleteFromDB(userInput);
                    Message.getVal("DELETE_SUCCESSFULLY",Integer.toString(flightList.getSize()));
                    /*System.out.println("Your flight has been deleted.\n" + "You have " + flightList.getSize()
                            + " flights in your record");*/
                    break;

                case "help":
                    Message.getVal("HELP_MESSAGE");
                    //System.out.println("Do email us at support@airrec.com. See you!");
                    break;
                case "search":
                    if (userInput.equals("search")) {
                        Message.getVal("SEARCH_EMPTY");
                        //System.out.println("☹ OOPS!!! There is nothing to find.");
                    } else {
                        ArrayList<Flight> tempList = flightList.searchFlight(userInput);

                        if (tempList.size() > 0) {
                            Message.getVal("SEARCH_MATCHING_START_MESSAGE");
                            //System.out.println("Here are the matching flights in your list:");
                            for (Flight flight : tempList) {
                                System.out.println(flight.getFullFlightDetails());
                            }
                        } else {
                            Message.getVal("NO_MATCH");
                            //System.out.println("There is no matching task in your list.");
                        }
                    }
                    break;

                case "show upcoming":
                    if (!flightList.isEmpty()) {
                        Flight upComingFlight = new Parser().dateCompare(flightList);
                        System.out.println("Flight : " + upComingFlight.getFullFlightDetails());
                    }
                    break;


                default:
                    Message.getVal("ERROR_UNKNOWN");
                    //System.out.println(errorUnknown);
                }
            }
        } catch (Exception e) {
            Message.getVal("ERROR_UNKNOWN");
            //System.out.println(errorUnknown);
        }
    }

}