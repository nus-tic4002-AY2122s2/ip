package seedu.duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Task {
    protected String description;
    protected Boolean mark = false;
    //protected String additionalDetails;
    //protected LocalDateTime deadline;

    public Task() {

    }

    public Task(String description, boolean mark) {
        this.description = description;
        this.mark = mark;
    }

    public Boolean getMark() {
        return mark;
    }

    public String getMarkSymbol() {
        if (mark) {
            return ("[X]");
        } else {
            return ("[ ]");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMark(Boolean mark) {
        this.mark = mark;
    }

    public String getTaskDetails() {
        return  getMarkSymbol() + " "  + getDescription();
    }

    /*private LocalDateTime processDateAndTime(String dateAndTimeDetails) {
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
    }*/

}
