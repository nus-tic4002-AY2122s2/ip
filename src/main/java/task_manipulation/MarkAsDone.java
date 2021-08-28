package task_manipulation;

import system_output.Output_On_Screen;
import task_classes.Task;

import java.util.Vector;

public class MarkAsDone {

    /**
     * The method to mark the task status as done
     * If the is not format "done + Integer", system will add the entire input as Todo type task into the entire task list
     *
     * @param list the entire task list
     * @param inputWords the string array of the user input
     * @param input
     *
     * @return to return true
     */
    public static boolean markAsDone(Vector<Task> list, String[] inputWords, String input){
        switch(inputWords.length){
            case 2:
                // check whether the second string is an integer
                if(inputWords[1].matches("\\d+")){
                    if(Integer.parseInt(inputWords[1]) > 0){
                        list.get(Integer.parseInt(inputWords[1]) - 1).markAsDone();
                        Output_On_Screen.printMarkAsDoneOutput(list, Integer.parseInt(inputWords[1]) - 1);
                    }
                    else{
                        Add.addTask(list, input);
                    }
                }
                else{
                    Add.addTask(list, input);
                }

                return true;
            default:
                Add.addTask(list, input);
                return true;
        }
    }
}
