package task_classes;

import dateTime.DateTimeDuke;

public class Deadline extends Task {

    public Deadline (String description, Boolean taskStatus, String dateTime) {
        super(description);
        super.isDone = taskStatus;
        super.type = "D";
        super.deadlineTime = new DateTimeDuke(dateTime);
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
    @Override
    public String getType(){
        return this.type;
    }

    @Override
    public DateTimeDuke getDeadlineTime() {
        return super.deadlineTime;
    }

    @Override
    public DateTimeDuke getStartingTime() {
        return null;
    }

    @Override
    public DateTimeDuke getEndingTime() {
        return null;
    }

    /**
     * To get the /by time of the Deadline task
     *
     * @return the time/date of the Deadline task
     */
    @Override
    public String getDeadlineDateTimeString(){
        DateTimeDuke deadlineDateTime = super.deadlineTime;

        return deadlineDateTime.convertToStringTypeI();
    }

    @Override
    public String getStartingDateTime() {
        return null;
    }

    @Override
    public String getEndingDateTime() {
        return null;
    }
}
