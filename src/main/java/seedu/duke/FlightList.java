package seedu.duke;

import java.util.ArrayList;

public class FlightList {

    public ArrayList<Flight> list;

    public FlightList() {
        this.list = new ArrayList<Flight>();
    }

    /**
     * Get the current list size.
     *
     * @return The current list size in integer
     */
    public int getSize() {
        return list.size();
    }

    /**
     * Get the current list.
     *
     * @return The current list.
     */
    public ArrayList<Flight> getList() {
        return this.list;
    }

    /**
     * Check whether the list is empty.
     *
     * @return True if list is empty, false if list is not empty.
     */
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    /**
     * Air Rec adds a Flight.
     * version 1.0 will be saving the details as string.
     *
     * @param message Details of the Flight.
     */
    public void addFlight(String message) {
        int index = message.indexOf("/");
        list.add(new Flight(message.substring(3)));
    }

    /**
     * Air Rec deletes a Flight.
     * version 1.0 will be deleting the flight by index.
     */
    public void deleteFlight(String message) {
        String number = message.substring(7).trim();
        int index = Integer.parseInt(number);
        index = index - 1;
        list.remove(index);
    }

    /**
     * Air Rec search Flight.
     * version 2.0 will be search flight by keyword.
     */
    public ArrayList<Flight> searchFlight(String message) {
        list.indexOf(message.substring(6));
        int i = 0;
        ArrayList<Flight> tempList = new ArrayList<Flight>();
        for (Flight flight : this.list) {
            if (flight.getFlightDetails().contains(message.substring(6))) {
                i = i + 1;
                tempList.add(new Flight(flight.getFlightDetails()));
            }
        }
        return tempList;
    }
}
