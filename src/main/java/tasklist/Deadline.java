package tasklist;

public class Deadline extends Task {

    protected String time;

    /****
     *
     * @param description the task description that the user input
     * @param time the task time that the user input
     */
    public Deadline(String description, String time) {
        super(description);
        this.time = time;
    }

    /****
     *
     * @param description the task description that the user input
     * @param status check if the task has already marked as done
     */
    public Deadline(String description, Boolean status) {
        super(description, status);
    }

    /****
     *
     * @param description the task description that the user input
     * @param status check if the task has already marked as done
     * @param time the task time that the user input
     */
    public Deadline(String description, Boolean status, String time) {
        super(description, status);
        this.time = time;
    }

    @Override
    public String toString() {
        return("[D]" + super.toString() + " (by: " + this.time + ")");
    }

    @Override
    public String saveFormat() {
        return ("D " + super.saveFormat() + " | " + this.time);
    }
}
