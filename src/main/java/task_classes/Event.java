package task_classes;

public class Event extends Task {

    //private String at;

    public Event (String description, String at){
        super(description);
        super.type = "E";
        super.at = at;
    }

    /**
     * The method to get /at time of the Event task
     *
     * @return time/date of the Event task
     */
    public String getAt(){
        return super.at;
    }

    public String getBy(){
        return "";
    }

    /**
     * To get the status icon of the task
     *
     * @return status icon of the task
     */
    public String getStatusIcon(){
        return (isDone ? "X" : " ");
    }

    /**
     * To get the description of the task
     *
     * @return the description of the task
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * To get the status of the task
     */
    public void markAsDone(){
        this.isDone = true;
    }

    /**
     * To get the type of the task
     *
     * @return the type of the task
     */
    public String getType(){
        return this.type;
    }
}
