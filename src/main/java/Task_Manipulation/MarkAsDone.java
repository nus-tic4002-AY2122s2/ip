package Task_Manipulation;

import System_output.Output_On_Screen;
import Task_Classes.Task;

import java.util.List;
import java.util.Vector;

public class MarkAsDone {

    /**
     * The method to mark the task status as done
     * If the is not format "done + Integer", system will add the entire input as Todo type task into the entire task list
     *
     * @param List the entire task list
     * @param Input_Words the string array of the user input
     * @param Input
     *
     * @return to return true
     */
    public static boolean Mark_As_Done (Vector<Task> List, String[] Input_Words, String Input){
        switch(Input_Words.length){
            case 2:
                // check whether the second string is an integer
                if(Input_Words[1].matches("\\d+")){
                    if(Integer.parseInt(Input_Words[1]) > 0){
                        List.get(Integer.parseInt(Input_Words[1]) - 1).markAsDone();
                        Output_On_Screen.MarkAsDone_Output(List, Integer.parseInt(Input_Words[1]) - 1);
                    }
                    else{
                        Add.addTask(List, Input);
                    }
                }
                else{
                    Add.addTask(List, Input);
                }

                return true;
            default:
                Add.addTask(List, Input);
                return true;
        }
    }
}
