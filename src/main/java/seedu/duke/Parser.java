package seedu.duke;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Parser {
    /**
     * This parser will be able to parse the inputs from the user to a readable command
     * for duke to process the inputs accordingly by the user.
     *
     * @param userInput The string of words typed in by the user.
     * @return A readable command for duke to process based on the command.
     */
    public String parseInput(String userInput) {
        userInput = userInput.toLowerCase();
        String command = "unknown";
        if (userInput.contains("bye")) {
            command = "bye";
        }
        if (userInput.contains("list")) {
            command = "list";
        }
        if (userInput.contains("delete")) {
            command = "delete";
        }
        if (userInput.contains("add")) {
            command = "add";
        }
        if (userInput.contains("show all") || userInput.contains("show All")) {
            command = "show all";
        }
        if (userInput.contains("edit")) {
            command = "edit";
        }
        if (userInput.contains("help")) {
            command = "help";
        }
        if (userInput.contains("search")) {
            command = "search";
        }

        if (userInput.contains("show upcoming") || userInput.contains("show Upcoming")) {
            command = "show upcoming";
        }
        return command;
    }

    // To parse Integer value for deletion
    public Integer parseIntValue(String userInput) {
        return Integer.parseInt(userInput.substring(7));
    }

    // To parse and compare dates.
    public Flight dateCompare(FlightList flights) {
        LocalDateTime currentTime = LocalDateTime.now();
        List<Flight> listOfFlights = new ArrayList<>();
        for (int i = 0; i < flights.getSize(); i++){
            if(flights.getList().get(i).dateAndTime.isAfter(currentTime)){
                listOfFlights.add(flights.getList().get(i));
            }
        }
        Comparator<Flight> dateComparator = Comparator.comparing(Flight::getLocalDateTime);

        Flight upComingFlight = listOfFlights.stream().min(dateComparator).get();
        return upComingFlight;


    }
}
