package Task_Classes;

public class Event extends Task {

    protected String at;

    public Event (String description, String at){
        super(description);
        super.type = "E";
        this.at = at;
    }

    /**
     * The method to get /at time of the Event task
     *
     * @return time/date of the Event task
     */
    public String getAt(){
        return this.at;
    }
}
