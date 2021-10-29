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
     * version 2.0 will be able to process string into data.
     * All index are there to extract the exact data for each parameter.
     *
     * @param message Details of the Flight.
     */
    public void addFlight(String message) {
        int fromIndex = message.indexOf("/from");
        int toIndex = message.indexOf("/to");
        int dateIndex = message.indexOf("/date");
        int priceIndex = message.indexOf("/price");
        String from = message.substring(fromIndex + 6, toIndex);
        String to = message.substring(toIndex + 4, dateIndex);
        String date = message.substring(dateIndex + 6, priceIndex);
        String price = message.substring(priceIndex + 7);
        list.add(new Flight(from, to, date, price));
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
}
