package tasklist;

public class Event extends Task {

    protected String time;

    /****
     *
     * @param description the task description that the user input
     * @param time the task time that the user input
     */
    public Event(String description, String time) {
        super(description);
        this.time = time;
    }

    /****
     *
     * @param description the task description that the user input
     * @param status check if the task has already marked as done
     */
    public Event(String description, Boolean status) {
        super(description,status);
    }

    /****
     *
     * @param description the task description that the user input
     * @param status check if the task has already marked as done
     * @param time the task time that the user input
     */
    public Event(String description,Boolean status, String time) {
        super(description,status);
        this.time = time;
    }

    @Override
    public String toString() {
        return("[E]" + super.toString() + " (at: " + this.time + ")");
    }

    @Override
    public String saveFormat() {
        return ("E " + super.saveFormat() + " | " + this.time);
    }
}
