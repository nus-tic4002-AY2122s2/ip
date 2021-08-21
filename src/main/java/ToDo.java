public class ToDo extends Task {
    public ToDo (String description){
        super(description);
        this.type = 'T';
    }
    public String getFullStatus(){
        return ("[" + this.type + "]" + "[" + this.getStatusIcon() + "] " + this.getDescription() + "\n");
    }
}