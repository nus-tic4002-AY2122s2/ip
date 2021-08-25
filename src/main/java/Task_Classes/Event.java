package Task_Classes;

public class Event extends Task {

    protected String at;

    public Event (String description, String at){
        super(description);
        super.type = "E";
        this.at = at;
    }

    public String getAt(){
        return this.at;
    }
}
