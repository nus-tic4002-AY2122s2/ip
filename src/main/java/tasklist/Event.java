package tasklist;

public class Event extends Task {

    protected String time;

    public Event(String description, String time) {
        super(description);
        this.time = time;
    }

    public Event(String description, Boolean status) {
        super(description,status);
    }

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
