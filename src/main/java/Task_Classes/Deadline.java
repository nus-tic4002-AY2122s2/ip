package Task_Classes;

public class Deadline extends Task {

    protected String by;

    public Deadline (String description, String by){
        super(description);
        super.type = "D";
        this.by = by;
    }

    public String getBy(){
        return this.by;
    }
}
