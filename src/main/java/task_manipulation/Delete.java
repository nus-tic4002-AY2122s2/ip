package task_manipulation;

import exceptions.DukeTaskInputException;
import screen_output.Output_On_Screen;
import task_classes.Task;
import user_input.Input_Parser;

import java.util.Vector;

public class Delete {

    public static void deleteTask(Vector<Task> taskList, String[] inputWords) throws DukeTaskInputException {
        int taskIndex;

        taskIndex = Input_Parser.toExtractNumberForDoneAndDelete(inputWords) - 1;
        Task deletedTask = taskList.get(taskIndex);
        taskList.remove(taskIndex);

        //Output_On_Screen.printDeletedOutput(taskList, deletedTask);
    }
}
