package user_input;

import exceptions.DukeTaskInputException;
import screen_output.Output_On_Screen;
import task_classes.Task;
import commands.AddCommand;
import commands.DeleteCommand;
import commands.MarkAsDoneCommand;

import java.util.Scanner;
import java.util.Vector;

public class Ui {

    /**
     * To parse the user input information type
     *
     * @param List entire task list
     */
    public static void InputStart(Vector<Task> List){

        String input;
        Scanner in = new Scanner(System.in);
        input = in.nextLine();

        try {
            String[] inputWords = input.split(" ");
            String firstWord = inputWords[0].toLowerCase();

            Parser.Input_Length_Checking(firstWord, inputWords);

            Output_On_Screen.toPrintSeparateLine();

            switch(firstWord) {
                case "bye":
                    Output_On_Screen.printGoodbyeOutput();
                    return;
                case "list":
                    Output_On_Screen.printOutList(List);
                    break;
                case "done":
                    MarkAsDoneCommand.markAsDone(List, inputWords);
                    break;
                case "deadline":
                    AddCommand.addDeadlineTask(List, inputWords);
                    break;
                case "event":
                    AddCommand.addEventTask(List, inputWords);
                    break;
                case "todo":
                    AddCommand.addTodoTask(List, input.substring(5, input.length()));
                    break;
                case "delete":
                    DeleteCommand.deleteTask(List, inputWords);
            }
        } catch (DukeTaskInputException e) {
            String errorType = DukeTaskInputException.getErrorType();

            switch(errorType){
                case "descriptionMissing":
                    String firstWord = DukeTaskInputException.getFirstWord();

                    switch(firstWord){
                        case "todo":
                        case "event":
                        case "deadline":
                            DukeTaskInputException.descriptionMissing(firstWord);
                            break;
                        default:
                            DukeTaskInputException.invalidFirstWordInput();
                            break;
                    }
                    break;
                case "dateTime":
                    DukeTaskInputException.dateTimeMissing();
                    break;
                case "markAsDoneTaskNumberMissing":
                    DukeTaskInputException.markAsDoneTaskNumberMissing();
                    break;
                case "markAsDoneTaskNumberNotInteger":
                    DukeTaskInputException.markAsDoneTaskNumberNotInteger();
                    break;
                case "markAsDoneTaskNumberNotInTaskList":
                    DukeTaskInputException.markAsDoneTaskNumberNotInTaskList();
                    break;
                case "markAsDoneFormatWrong":
                    DukeTaskInputException.markAsDoneFormatWrong();
                    break;
                case "taskIndexOutOfRange":
                    DukeTaskInputException.taskIndexOutOfRange();
                    break;
                case "listIsEmtpy":
                    DukeTaskInputException.listIsEmtpy();
                    break;
                case "formatWrong":
                    DukeTaskInputException.formatWrong();
                    break;
            }

            System.out.println("");
        }

        InputStart(List);
    }
}
