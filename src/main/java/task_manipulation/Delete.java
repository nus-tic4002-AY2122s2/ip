package task_manipulation;

import exceptions.DukeTaskInputException;
import screen_output.Output_On_Screen;
import task_classes.Task;
import user_input.Input_Parser;

import java.util.Vector;

public class Delete {

    public static void deleteTask(Vector<Task> taskList, String[] inputWords) throws DukeTaskInputException {

        int taskIndex;

        taskIndex = Input_Parser.toExtractNumberForDoneAndDelete(inputWords, taskList) - 1;
        Task deletedTask = taskList.get(taskIndex);
        taskList.remove(taskIndex);

        String taskType = deletedTask.getType();

        switch(taskType){
            case "E":
                Output_On_Screen.printDeletedEvent(taskList, deletedTask);
                break;
            case "D":
                Output_On_Screen.printDeletedDeadline(taskList, deletedTask);
                break;
            default:
                Output_On_Screen.printDeletedTodo(taskList, deletedTask);
        }
    }
}
