package tasks;


public class Event extends Task{
    protected String time;

    public Event(String description, String at) {
        super(description);
        this.time = at;
    }

    public String getTime() {
        return this.time;
    }

    public String toString() {
        return "[E]" + super.toString() + " (at: " + getTime() + ")";
    }

}
