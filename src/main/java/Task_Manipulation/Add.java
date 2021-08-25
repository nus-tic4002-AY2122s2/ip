package Task_Manipulation;


import System_output.Output_On_Screen;
import Task_Classes.*;
import User_Input.Input_Parser;

import java.util.Vector;

public class Add {

    /**
     * To add Todo type task to the task list
     * The ouput (message print onto screen) will be included in this method
     *
     * @param List the entire task list
     * @param Input the description of the todo task
     */
    public static void addTask(Vector<Task> List, String Input){
        Todo inputTask = new Todo (Input);
        List.add(inputTask);

        Output_On_Screen.Output_TodoAdded(inputTask, List.size());
    }

    /**
     * To add Deadline type task to the task list
     * The ouput (message print onto screen) will be included in this method after task added
     *
     * @param List the entire task list
     * @param Input_Words the string array of the user input
     */
    public static void addDeadlineTask (Vector<Task> List, String[] Input_Words){

        String description = Input_Parser.toGetDescription(Input_Words);
        String date = Input_Parser.toGetDate(Input_Words);

        Deadline newTask = new Deadline(description, date);

        List.add(newTask);

        Output_On_Screen.Output_DeadlineAdded(newTask, List.size());
    }

    /**
     * To add Event type task to the task list
     * The ouput (message print onto screen) will be included in this method after task added
     *
     * @param List the entire task list
     * @param Input_Words the string array of the user input
     */
    public static void addEventTask (Vector<Task> List, String[] Input_Words){

        String description = Input_Parser.toGetDescription(Input_Words);
        String date = Input_Parser.toGetDate(Input_Words);

        Event newTask = new Event(description, date);

        List.add(newTask);

        Output_On_Screen.Output_EventAdded(newTask, List.size());
    }
}
