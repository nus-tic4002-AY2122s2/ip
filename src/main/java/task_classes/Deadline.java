package task_classes;

public class Deadline extends Task {

    protected String by;

    public Deadline (String description, String by){
        super(description);
        super.type = "D";
        this.by = by;
    }

    /**
     * To get the /by time of the Deadline task
     *
     * @return the time/date of the Deadline task
     */
    public String getBy(){
        return this.by;
    }
}
