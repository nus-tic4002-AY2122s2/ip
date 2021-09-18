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

    public String getDeadlineDateTimeString(){
        return null;
    }

    public String getStartingDateTime(){
        return null;
    }

    @Override
    public String getEndingDateTime() {
        return null;
    }

    @Override
    public DateTimeDuke getDeadlineTime() {
        return null;
    }

    @Override
    public DateTimeDuke getStartingTime() {
        return null;
    }

    @Override
    public DateTimeDuke getEndingTime() {
        return null;
    }
}
