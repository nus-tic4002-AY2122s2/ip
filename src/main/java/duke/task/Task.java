package duke.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task in the taskList
 */
public abstract class Task {

    private static final String TASK_TYPE = "A";

    private String description;
    private boolean isDone;
    private LocalDateTime taskTime = LocalDateTime.of(2000, 1, 1, 0, 0);
    private LocalDateTime finishTime;

    /**
     * Constructor of the Task when create without done status and finishTime
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Constructor of the Task when create with done status and finishTime
     */
    public Task(String description, boolean isDone, LocalDateTime finishTime) {
        this.description = description;
        this.isDone = isDone;
        if (this.isDone) {
            this.finishTime = finishTime;
        }
    }

    public LocalDateTime getFinishTime() {
        return finishTime == null ? LocalDateTime.of(9999, 1, 1, 0, 0) : this.finishTime;
    }

    /**
     * Gets the displayed icon from isDone status
     *
     * @return a string icon to display the status
     */
    public String getStatusIcon() {
        //return (isDone ? "\u2714" : "\u2718"); //return tick or X symbols
        return (isDone ? "Done" + " : " + finishTime.format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm"))
                : "X"); //return tick or X symbols
    }

    /**
     * Marks a task as done status
     *
     * @param finishTime
     */
    public void markAsDone(LocalDateTime finishTime) {
        isDone = true;
        this.finishTime = finishTime;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getTaskType() {
        return TASK_TYPE;
    }

    public LocalDateTime getTaskTime() {
        return taskTime;
    }

    public void updateTask(String newValue) {
        this.description = newValue;
    }

    /**
     * update the tasktime of the task
     * @param newValue /at or /by time in Event and Deadline task
     */
    public void updateTask(LocalDateTime newValue) {
        this.taskTime = newValue;

    }


    @Override
    public boolean equals(Object obj) {

        Task otherTask = (Task) obj;
        return obj == this // short circuit if same object
                || (obj instanceof Task // instanceof handles nulls
                && otherTask.description.equals(this.description)
                && otherTask.isDone == this.isDone
                && otherTask.taskTime.equals(this.taskTime));
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + getDescription();
    }
}
