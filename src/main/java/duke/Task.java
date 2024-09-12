package duke;

/*
 *  Task.java
 *  Defines task.
 */

abstract class Task {
    private String description;
    protected boolean isDone;

    /*
     * Constructs Task object
     * @param description Task description.
     */
    public Task(String description) {
        this.setDescription(description);
        this.isDone = false;
    }

    /*
     * Constructs Task object
     * @param description Task description.
     * @param isDone Task's completion status.
     */
    public Task(String description,boolean isDone) {
        this.setDescription(description);
        this.isDone = isDone;
    }

    /*
     * Return Task's completion status in tick or cross symbol.
     * @return Task's completion status in tick or cross symbol.
     */
    public String getStatusIcon() {
        return "[" + (isDone ? "\u2713" : "\u2718") + "]"; //return tick or X symbols
    }

    /*
     * Get Task's completion status.
     */
    public boolean getStatus() {
        return isDone;
    }


    /*
     * Set Task's completion status.
     */
    public void setStatus(String status) {
        this.isDone = status.equals("1");
    }

    /*
     * Set Task's completion status as completed or done.
     */
    public String markAsDone() {
        this.isDone = true;
        return (getStatusIcon()); //return tick or X symbols
    }

    /*
     * Returns default task
     * @return 'n' task.
     */
    public char getTaskType() {
        return 'n';
    }

    /*
     * Returns task details
     * @return details of task.
     */
    @Override
    public String toString() {
        return getStatusIcon() + " " + this.getDescription();
    }

    /*
     * Returns task description
     * @return description of task.
     */
    public String getDescription() {
        return description;
    }

    /*
     * Set Task's description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}