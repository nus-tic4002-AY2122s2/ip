package task_classes;

import dateTime.DateTimeDuke;

public class Todo extends Task {

    public Todo (String description){
        super(description);
        super.type = "T";
    }

    public Todo (String description, Boolean taskStatus) {
        super(description);
        super.isDone = taskStatus;
        super.type = "T";
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

    /**
     * To get the /by time of the Deadline task
     *
     * @return null
     */
    @Override
    public String getDeadlineDateTimeString(){
        return null;
    }

    /**
     * To get staring date time in String format
     * @return null
     */
    @Override
    public String getStartingDateTime(){
        return null;
    }

    /**
     * To get ending date time in String format
     * @return null
     */
    @Override
    public String getEndingDateTime() {
        return null;
    }

    /**
     * To get the deadline time in DateTimeDuke format
     * @return null
     */
    @Override
    public DateTimeDuke getDeadlineTime() {
        return null;
    }

    /**
     * To get the starting time of event in DateTimeDuke format
     * @return null
     */
    @Override
    public DateTimeDuke getStartingTime() {
        return null;
    }

    /**
     * To get the ending time of event in DateTimeDuke format
     * @return null
     */
    @Override
    public DateTimeDuke getEndingTime() {
        return null;
    }
}
