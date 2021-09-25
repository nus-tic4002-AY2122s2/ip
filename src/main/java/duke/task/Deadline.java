package duke.task;



import java.time.LocalDate;
import java.time.LocalTime;

/**
 * The Deadline class which the user want to store with date and time
 */
public class Deadline extends Task {
    protected LocalDate taskDate;
    protected LocalTime taskTime;
    protected boolean hasTime = false;
    protected String taskDateString;

    /**
     * Constructs the Deadlines class without a time
     * @param description the description the user input
     * @param taskDate the date the user input
     */
    public Deadline(String description, LocalDate taskDate) {
        super(description);
        this.taskDate = taskDate;
        taskType = TaskType.DEADLINE;
    }

    /**
     * Constructs the Deadlines class without a time
     * @param description the description the user input
     * @param stringDate the date the user input
     */
    public Deadline(String description, String stringDate) {
        super(description);
        this.taskDateString = stringDate;
        taskType = TaskType.DEADLINE;
    }

    /**
     * Constructs the Event class with a time
     * @param description the description the user input
     * @param taskDate the date the user input
     * @param taskTime the time the user input
     */
    public Deadline(String description, LocalDate taskDate, LocalTime taskTime) {
        this(description, taskDate);
        this.taskTime = taskTime;
        this.hasTime = true;
        taskType = TaskType.DEADLINE;
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
        return "[D]" + super.toString() + " (by: " + taskDateString + ")";
    }
}
