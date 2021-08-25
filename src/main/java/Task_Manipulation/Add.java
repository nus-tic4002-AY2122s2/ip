package Task_Manipulation;


import System_output.Output_On_Screen;
import Task_Classes.*;
import User_Input.Input_Parser;

import java.util.Vector;

public class Add {

    public static void addTask(Vector<Task> List, String Input){
        Todo inputTask = new Todo (Input);
        List.add(inputTask);

        Output_On_Screen.Output_TodoAdded(inputTask, List.size());
    }

    public static void addDeadlineTask (Vector<Task> List, String[] Input_Words){

        String description = Input_Parser.toGetDescription(Input_Words);
        String date = Input_Parser.toGetDate(Input_Words);

        Deadline newTask = new Deadline(description, date);

        List.add(newTask);

        Output_On_Screen.Output_DeadlineAdded(newTask, List.size());
    }

    public static void addEventTask (Vector<Task> List, String[] Input_Words){

        String description = Input_Parser.toGetDescription(Input_Words);
        String date = Input_Parser.toGetDate(Input_Words);

        Event newTask = new Event(description, date);

        List.add(newTask);

        Output_On_Screen.Output_EventAdded(newTask, List.size());
    }
}
