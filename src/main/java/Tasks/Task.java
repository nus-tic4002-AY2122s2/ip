package Tasks;

import java.awt.print.Printable;
import java.util.ArrayList;

public class Task {
    protected String description;
    protected boolean isDone;
    protected ArrayList<String> taskList;
    protected char type;


    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    /**
     * Getters
     * Returns the description of the task
     *
     * @return The description of the task in string.
     */
    public String getDescription(){
        return getStatus() + getStatusIcon() + " " + this.description;
    }

    public String getStatusIcon() {
//        return (isDone ? "[" + "\u2713" + "]": "["+"\u2718"+"]"); //return tick or X symbols

        return (isDone ? "[" + "Y" + "]": "["+"N"+"]"); //return tick or X symbols

    }

    public int getIndex(String input){
        String[] num = input.split("done");
        String part1 = num[0];
        String part2 = num[1];
        return Integer.parseInt(part2);
    }

    public String getStatus(){
        return "";
    }

    //Setters
    public void setDone(boolean done) {
        isDone = done;
    }






    public void markAsDone(){
        this.isDone = true;

    }



    public void markAsUndone(){
        this.isDone = false;
    }

    //    /**
//     * Get the type of current Task, if it is a todo, event, deadline or DoAfter task.
//     * todo = 'T'
//     * event = 'E'
//     * deadline = 'D'
//     * DpAfter = 'A'
//     *
//     * @return [T/E/D/A]
//     */
//    public String getType() {
//        return "[" + this.type + "]";
//    }



    public String toString() {
        return this.getStatusIcon() + this.description;
    }

}