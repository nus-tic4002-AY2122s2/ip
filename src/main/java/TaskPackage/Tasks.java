package TaskPackage;

import java.util.ArrayList;
import java.util.Iterator;

public class Tasks {
    protected String description;
    protected boolean isDone;
    protected ArrayList<Task> addedList = new ArrayList<>();

    public Tasks(String description) {
        this.description = description;
        this.isDone = false;
    }


    /***
     *
     * @return done return tick else return X symbols
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String markAsDone(int doneIndex) {
        this.isDone = true;
        return ("[" + getStatusIcon() + "]" + this.addedList.get(doneIndex).desc);
    }

    public void addDone(int doneIndex) {
        int index = 0;

        Iterator itr = this.addedList.iterator();
        while (itr.hasNext()) {

            Task t = (Task)itr.next();
            if(doneIndex == index) {
                t.status = true;
            }
            ++index;
            //            System.out.println("    " + ++index + ". " + "[" + t.status + "]" + t.desc);
        }
    }

    public void getList(ArrayList<Task> addedList) {
        int index1 = 0;

        this.addedList = addedList;

        System.out.println("-------------------------------");
        System.out.println("Here are the TaskPackage.Task in your list:");
        Iterator itr = addedList.iterator();
        while (itr.hasNext()){
            Task t = (Task)itr.next();
                System.out.println("    " + ++index1 + ". " + "[" + (t.status ? "\u2713" : "\u2718") + "]" + t.desc);
        }
        System.out.println("-------------------------------");
    }

    public int getNumOfList(){
        return this.addedList.toArray().length;
    }

}


