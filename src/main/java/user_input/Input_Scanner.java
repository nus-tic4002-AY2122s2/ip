package user_input;

import system_output.Output_On_Screen;
import task_classes.Task;
import task_manipulation.Add;
import task_manipulation.MarkAsDone;

import java.util.Scanner;
import java.util.Vector;

public class Input_Scanner {

    /**
     * To parse the user input information type
     *
     * @param List entire task list
     * @return true or false, only "bye" input will return false
     */
    public static boolean InputStart(Vector<Task> List){

        String input;

        Scanner in = new Scanner(System.in);
        input = in.nextLine();

        String[] inputWords = input.split(" ");


        Output_On_Screen.toPrintSeparateLine();

        switch(inputWords[0].toLowerCase()) {
            case "bye":
                Output_On_Screen.printGoodbyeOutput();
                Output_On_Screen.toPrintSeparateLine();

                return false;
            case "list":
                Output_On_Screen.printOutList(List);

                return true;
            case "done":

                return MarkAsDone.markAsDone(List, inputWords, input);
            case "deadline":
                Add.addDeadlineTask(List, inputWords);

                return true;
            case "event":
                Add.addEventTask(List, inputWords);

                return true;
            default:
                Add.addTask(List, input);

                return true;
        }
    }
}
