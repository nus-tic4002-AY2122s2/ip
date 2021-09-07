package task_manipulation;

import exceptions.DukeTaskInputException;
import screen_output.Output_On_Screen;
import task_classes.Task;

import java.util.Vector;

public class MarkAsDone {

    /**
     * The method to mark the task status as done
     * If the is not format "done + Integer", system will add the entire input as Todo type task into the entire task list
     *
     * @param list the entire task list
     * @param inputWords the string array of the user input
     */
    public static void markAsDone(Vector<Task> list, String[] inputWords) throws DukeTaskInputException {
        if(list.isEmpty()){
            throw new DukeTaskInputException(inputWords[0], "listIsEmtpy");
        }

        if (inputWords.length == 2) {
            if (inputWords[1].matches("\\d+")) {// check whether the second string is an integer
                if (Integer.parseInt(inputWords[1]) > 0) {
                    if (Integer.parseInt(inputWords[1]) > list.size() || Integer.parseInt(inputWords[1]) <= 0) {
                        throw new DukeTaskInputException(inputWords[0], "taskIndexOutOfRange");
                    }
                    Task currentTask = list.get(Integer.parseInt(inputWords[1]) - 1);
                    currentTask.markAsDone();
                    String taskType = currentTask.getType();

                    Output_On_Screen.printMarkAsDoneOutput(list, Integer.parseInt(inputWords[1]) - 1, taskType);

                    return;
                } else {
                    throw new DukeTaskInputException(inputWords[0], "markAsDoneTaskNumberNotInTaskList");
                }
            } else {
                throw new DukeTaskInputException(inputWords[0], "taskIndexOutOfRange");
            }
        }

        throw new DukeTaskInputException(inputWords[0], "markAsDoneFormatWrong");
    }
}
