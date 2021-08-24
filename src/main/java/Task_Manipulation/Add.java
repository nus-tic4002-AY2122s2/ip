package Task_Manipulation;


import System_output.Output_On_Screen;
import Task_Classes.Task;

import java.util.List;

public class Add {

    public static void addTask(List<Task> List, String Input){
        Task inputTask = new Task(Input);
        List.add(inputTask);

        System.out.println("     added:" + Input);
        Output_On_Screen.Separated_Line();
    }
}
