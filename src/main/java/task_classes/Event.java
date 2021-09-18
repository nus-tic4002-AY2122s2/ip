package task_classes;

import dateTime.DateTimeDuke;

public class Event extends Task {

    public Event (String description, Boolean taskStatus, String startingDateTime, String endingDateTime) {
        super(description);
        super.isDone = taskStatus;
        super.type = "E";
        super.startingTime = new DateTimeDuke(startingDateTime);
        super.endingTime = new DateTimeDuke(endingDateTime);
    }

    @Override
    public DateTimeDuke getDeadlineTime() {
        return null;
    }

    @Override
    public DateTimeDuke getStartingTime() {
        return super.startingTime;
    }

    @Override
    public DateTimeDuke getEndingTime() {
        return super.endingTime;
    }

    /**
     * To get the status icon of the task
     *
     * @return status icon of the task
     */
    public String getStatusIcon(){
        return (isDone ? "X" : " ");
    }

    /**
     * To get the description of the task
     *
     * @return the description of the task
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * To get the status of the task
     */
    public void markAsDone(){
        this.isDone = true;
    }

    /**
     * To get the type of the task
     *
     * @return the type of the task
     */
    public String getType(){
        return this.type;
    }

    @Override
    public String getStartingDateTime(){
        DateTimeDuke dateTimeDuke = super.startingTime;

        return dateTimeDuke.convertToStringTypeI();
    }

    @Override
    public String getEndingDateTime() {
        DateTimeDuke dateTimeDuke = super.endingTime;

        return dateTimeDuke.convertToStringTypeI();
    }

    @Override
    public String getDeadlineDateTimeString(){
        return null;
    }
}
