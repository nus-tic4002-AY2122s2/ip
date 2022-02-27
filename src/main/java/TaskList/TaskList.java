package TaskList;

import Parser.myMethods;
import Tasks.Deadlines;
import Tasks.Events;
import Tasks.Task;
import Tasks.toDos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TaskList {

    /**
     * Private Variable for Storing list of Tasks.
     */
    private ArrayList<Task> tasklist = new ArrayList<>();


    /**
     * Empty Constructor
     */
    public TaskList(){

    }


    /**
     * Constructor take in a list of user inputs and store in array
     * @param commands
     */
    public TaskList(ArrayList<String> commands) throws ParseException {
        for(String each : commands){
            parsingTxtFile(each);
        }
    }


    /**
     * Getter for the size of the TaskList
     * @return the size of the TaskList
     */
    public int getSize(){
        return tasklist.size();
    }

    /**
     * Getter for Object reference in TaskList Array
     */
    public Task getTask(int idx){
        return tasklist.get(idx);
    }

    /**
     * Adding new task to the TaskList
     * @param item item is a task to be added
     */
    public void addTask(Task item){
        this.tasklist.add(item);
    }

    /**
     * Returns all the task in ArrayList format.
     * @return tasklist which is all the task in an arraylist format
     */
    public ArrayList<Task> getAllTasks(){
        return tasklist;
    }

    /**
     * Delete existing task in the ArrayList
     * @param index the index in which the task is located at
     * @return deleted task returns a task to show the deleted task
     * @throws IndexOutOfBoundsException (In case of when number key isn't within range)
     */
    public Task deleteTask(int index) throws IndexOutOfBoundsException {
        Task to_be_Removed = tasklist.remove(index);
        return to_be_Removed;
    }

    /**
     * This method will take in the List of String inputs from the Loaded text file.
     * Parse each string and process which Type of command is it.
     * Add the task to the current list of tasks based on processed String.
     * @param command process individual command from the text file
     */
    public void parsingTxtFile(String command) throws ParseException {
        String[] words = command.split("\\|");
        System.out.println("reached here1");
        Task result;
        System.out.println("reached here2");
        for (int i = 0; i < words.length; i ++){
            System.out.println(words[i]);
        }
        System.out.println(words[0]);
        switch(words[0]){

            case "T" :
                System.out.println("reached here3");

                assert words[2].equals("1") || words[2].equals("0") : "It should be a 1 or 0 for status else please check your task status in the text file.";
                System.out.println("reached here3.1");
                result = new toDos(words[2]);
                System.out.println("reached here3.2");
                String a = "1";
                System.out.println("reached here3");
                if(Integer.parseInt(words[1].trim()) == 1){
                    tasklist.add(result);
                    tasklist.get(tasklist.size()-1).markAsDone();
                }else {
                    tasklist.add(result);
                }
                System.out.println("reached here3.4");
                break;
            case "D" :
                System.out.println("reached here4");

                SimpleDateFormat frmt = new SimpleDateFormat("E, dd MMM yyyy HH:mm");
                System.out.println("reached here4.1");

                Date dte = frmt.parse(words[3].trim());
                System.out.println("reached here4.2");

                result = new Deadlines(words[2], dte);
                System.out.println("reached here4.3");

                if(Integer.parseInt(words[1].trim()) == 1){
                    tasklist.add(result);
                    tasklist.get(tasklist.size()-1).markAsDone();
                }else {
                    tasklist.add(result);
                }
                System.out.println("reached here4.4");

                break;
            case "E" :
                System.out.println("reached here5");

                result = new Events(words[2], words[3]);
                if(Integer.parseInt(words[1].trim()) == 1){

                    tasklist.add(result);

                    tasklist.get(tasklist.size()-1).markAsDone();
                }else {
                    tasklist.add(result);
                }
                break;
            default:
                break;
        }
    }
}