package task_manipulation;


import exceptions.DukeTaskInputException;
import screen_output.Output_On_Screen;
import task_classes.*;
import user_input.Input_Parser;

import java.util.Vector;

public class Add {

    /**
     * To add Todo type task to the task list
     * The output (message print onto screen) will be included in this method
     *
     * @param list the entire task list
     * @param input the description of the todo task
     */
    public static void addTodoTask(Vector<Task> list, String input){
        Todo inputTask = new Todo (input);
        list.add(inputTask);

        Output_On_Screen.printTodoAddedOutput(inputTask, list.size());
    }

    /**
     * To add Deadline type task to the task list
     * The output (message print onto screen) will be included in this method after task added
     *
     * @param list the entire task list
     * @param inputWords the string array of the user input
     */
    public static void addDeadlineTask (Vector<Task> list, String[] inputWords) throws DukeTaskInputException {

        String description = Input_Parser.toExtractDescription(inputWords);

        String date = Input_Parser.toExtractDate(inputWords);

        Deadline newTask = new Deadline(description, date);

        list.add(newTask);

        Output_On_Screen.printDeadlineAddedOutput(newTask, list.size());
    }

    /**
     * To add Event type task to the task list
     * The output (message print onto screen) will be included in this method after task added
     *
     * @param list the entire task list
     * @param inputWords the string array of the user input
     */
    public static void addEventTask (Vector<Task> list, String[] inputWords) throws DukeTaskInputException {

        String description = Input_Parser.toExtractDescription(inputWords);
        String date = Input_Parser.toExtractDate(inputWords);

        Event newTask = new Event(description, date);

        list.add(newTask);

        Output_On_Screen.printEventAddedOutput(newTask, list.size());
    }
}
