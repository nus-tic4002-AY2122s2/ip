package seedu.duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Flight {
    protected String from; // Departing details
    protected String to; // Destination details
    protected LocalDateTime dateAndTime; //Date & Time in LocalDateTime type
    protected String stringDateAndTime; //Date & Time in String type
    protected Integer price; // Price of the flight

    public Flight(String from, String to, String dateAndTimeDetails, String price) {
        this.from = from;
        this.to = to;
        this.price = Integer.parseInt(price);
        this.dateAndTime = processDateAndTime(dateAndTimeDetails);
        this.stringDateAndTime = dateAndTime.format(DateTimeFormatter.ofPattern("dd MMM yyyy HHmm")) + "H";
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getStringDateAndTime() {
        return stringDateAndTime;
    }

    public Integer getPrice() {
        return price;
    }

    public String getFullFlightDetails() {
        return "Traveling from " + getFrom() + "to "
                + getTo() + "on " + getStringDateAndTime() + " which cost $" + String.valueOf(getPrice() + " per pax.");
    }


    private LocalDateTime processDateAndTime(String dateAndTimeDetails) {
        String changedDate;
        int julianDate;
        int day;
        DateTimeFormatter formatter;
        LocalDateTime formattedDate = null;
        dateAndTimeDetails = dateAndTimeDetails.trim();
        int daysToAdd = getDaysToAdd(dateAndTimeDetails);
        if (daysToAdd < 0) {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
            formattedDate = LocalDateTime.parse(dateAndTimeDetails, formatter);
        } else {
            formattedDate = formattedDate.now();
            julianDate = formattedDate.getDayOfYear();
            day = julianDate % 7;
            daysToAdd = day - daysToAdd;
            if (daysToAdd == 0) {
                daysToAdd = 7;
            } else if (daysToAdd < 0) {
                daysToAdd = daysToAdd * -1;
            } else {
                daysToAdd = 7 - daysToAdd;
            }
            formattedDate = formattedDate.plusDays(daysToAdd);
        }
        changedDate = formattedDate.toString();
        return LocalDateTime.parse(changedDate);
    }

    private int getDaysToAdd(String details) {
        details = details.toLowerCase();
        if (details.contains("mon")) {
            return 0;
        }
        if (details.contains("tues")) {
            return 1;
        }
        if (details.contains("wednes")) {
            return 2;
        }
        if (details.contains("thurs")) {
            return 3;
        }
        if (details.contains("fri")) {
            return 4;
        }
        if (details.contains("satur")) {
            return 5;
        }
        if (details.contains("sun")) {
            return 6;
        }
        return -1;
    }
}
