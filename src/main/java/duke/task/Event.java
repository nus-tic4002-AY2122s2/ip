package duke.task;



import java.time.LocalDate;
import java.time.LocalTime;

/**
 * The event class which the user want to store with date and time
 */
public class Event extends Task {
    protected LocalDate taskDate;
    protected LocalTime taskTime;
    protected boolean hasTime = false;
    protected String taskDateString;


    /**
     * Constructs the Duke.Task.Event class without a time
     * @param description the description the user input
     * @param taskDate the date that the user input
     */
    public Event(String description, LocalDate taskDate) {
        super(description);
        this.taskDate = taskDate;
        taskType = TaskType.EVENT;
    }

    /**
     * Constructs the Event with a time
     * @param description the description the user input
     * @param taskDate the date the user input
     * @param taskTime the time the user input
     */
    public Event(String description, LocalDate taskDate, LocalTime taskTime) {
        this(description, taskDate);
        this.taskTime = taskTime;
        this.hasTime = true;
        taskType = TaskType.EVENT;
    }

    /**
     * Constructs the Duke.Task.Event class without a time
     * @param description the description the user input
     * @param taskDateString the date that the user input
     */
    public Event(String description, String taskDateString) {
        super(description);
        this.taskDateString = taskDateString;
        taskType = TaskType.EVENT;
    }

    public String getDateTimeString(){
        return taskDateString;
    }

    /**
     * Return the task type with the task that the user input and whether it is done or not
     * @return the task in String
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + taskDateString + ")";
    }
}
