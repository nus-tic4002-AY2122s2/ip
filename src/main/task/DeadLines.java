package task;

public class DeadLines extends Task {
    String details;

    public DeadLines(String description, String details){
        super(description);
        this.details = "(by: "+ details + ")";
        this.type = 'D';
    }
    public String getFullStatus(){
        return ("[" + this.type + "]" + "[" + this.getStatusIcon() + "] " + this.getDescription() + this.details + "\n");
    }
}
