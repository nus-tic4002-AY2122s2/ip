package task_classes;

import dateTime.DateTime;

public abstract class Task {
    String description;
    boolean isDone;
    String type;

    //For deadline task;
    String by;
    DateTime deadlineTime;

    //For event task;s
    String at;
    DateTime startingTime;
    DateTime endingTime;

    Task(String description){
        this.description = description;
        this.isDone = false;
    }

    /**
     * To get the status icon of the task
     *
     * @return status icon of the task
     */
    public abstract String getStatusIcon(); //{ return (isDone ? "X" : " ");}

    /**
     * To get the description of the task
     *
     * @return the description of the task
     */
    public abstract String getDescription(); //{ return this.description; }

    /**
     * To get the status of the task
     */
    public abstract void markAsDone(); //{ this.isDone = true; }

    /**
     * To get the type of the task
     *
     * @return the type of the task
     */
    public abstract String getType(); //{ return this.type; }

    /**
     * To get the date/Time of the deadline task
     *
     * @return the type of the task
     */
    public abstract String getBy();

    /**
     * To get the date/time of the event task
     *
     * @return the type of the task
     */
    public abstract String getAt();
}
