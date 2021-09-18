package parser;


import commands.*;
import exceptions.DukeTaskInputException;
import storage.Storage;
import task_classes.Task;
import task_classes.TaskList;
import task_classes.Todo;
import ui.Output_On_Screen;
import ui.Ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Parser {

    /**
     * To extract task description information from user input
     *
     * @param inputWords all user input in String[] type
     * @return the description in String type
     */
    public static String toExtractDescription(String[] inputWords) throws DukeTaskInputException {
        ArrayList<String> bufferA = new ArrayList<String>();

        /* If the input is to add todo task, then the length of the array must greater then 1 or there is no description */
        if(inputWords.length < 2){
            throw new DukeTaskInputException(inputWords[0], "descriptionMissing");
        }

        switch (inputWords[0]) {
            case "todo":
                bufferA.addAll(Arrays.asList(inputWords).subList(1, inputWords.length));

                return convertStringArrayToString(bufferA);
            case "deadline":
                for (int n = inputWords.length - 1; n > 0; n--) {
                    if (inputWords[n].equals("/by")) {
                        if (n == 1) {
                            throw new DukeTaskInputException(inputWords[0], "descriptionMissing");
                        }
                        if (n == inputWords.length - 1) {
                            throw new DukeTaskInputException(inputWords[0], "dateTime");
                        }

                        bufferA.addAll(Arrays.asList(inputWords).subList(1, n));

                        return convertStringArrayToString(bufferA);
                    }
                }
                break;
            case "event":
                for (int n = inputWords.length - 1; n > 0; n--) {
                    if (inputWords[n].equals("/at")) {
                        if (n == 1) {
                            throw new DukeTaskInputException(inputWords[0], "descriptionMissing");
                        }
                        if (n == inputWords.length - 1) {
                            throw new DukeTaskInputException(inputWords[0], "dateTime");
                        }

                        bufferA.addAll(Arrays.asList(inputWords).subList(1, n));

                        return convertStringArrayToString(bufferA);
                    }
                }
                break;
        }

        throw new DukeTaskInputException(inputWords[0], "dateTime");
    }

    /**
     * To extract time/date information from user input
     *
     * @param inputWords all user input in String[] type
     * @return the time/date information in String type
     */
    public static String toExtractDate(String[] inputWords) throws DukeTaskInputException {
        ArrayList<String> bufferA = new ArrayList<String>();

        /* If the input is to add todo task, then the length of the array must greater then 1 or there is no description */
        if(inputWords.length == 2){
            throw new DukeTaskInputException(inputWords[0], "descriptionMissing");
        }

        switch (inputWords[0]) {
            case "todo":
                bufferA.addAll(Arrays.asList(inputWords).subList(1, inputWords.length));

                return convertStringArrayToString(bufferA);
            case "deadline":
                for (int n = inputWords.length - 1; n > 0; n--) {
                    if (inputWords[n].equals("/by")) {
                        if (n == 1) {
                            throw new DukeTaskInputException(inputWords[0], "descriptionMissing");
                        }
                        if (n == inputWords.length - 1) {
                            throw new DukeTaskInputException(inputWords[0], "dateTime");
                        }

                        bufferA.addAll(Arrays.asList(inputWords).subList(n + 1, inputWords.length));

                        return convertStringArrayToString(bufferA);
                    }
                }
                break;
            case "event":
                for (int n = inputWords.length - 1; n > 0; n--) {
                    if (inputWords[n].equals("/at")) {
                        if (n == 1) {
                            throw new DukeTaskInputException(inputWords[0], "descriptionMissing");
                        }
                        if (n == inputWords.length - 1) {
                            throw new DukeTaskInputException(inputWords[0], "dateTime");
                        }

                        bufferA.addAll(Arrays.asList(inputWords).subList(n + 1, inputWords.length));

                        return convertStringArrayToString(bufferA);
                    }
                }
                break;
        }

        throw new DukeTaskInputException(inputWords[0], "dateTime");
    }

    /**
     * To convert String[] to String type
     *
     * @param strArr String[] information
     * @return String[] information in String type
     */
    public static String convertStringArrayToString(ArrayList<String> strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr)
            sb.append(str).append(" ");
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * To check customer input String. If the input only has one word and not "list" and "bye".
     * This function will throw an error which will tell user that the input in incorrect and please try again;
     * @param First_Word The first word of the customer input which used to compare the condition;
     * @param Input_Words The customer input which used to check length;
     * @throws DukeTaskInputException The error which the input is not correct.
     */
    private static void Input_Length_Checking(String First_Word, String[] Input_Words) throws DukeTaskInputException {
        if(!First_Word.equals("list") &&
                !First_Word.equals("bye") &&
                !First_Word.equals("help") &&
                !First_Word.equals("update") &&
                !First_Word.equals("search") &&
                !First_Word.equals("datetype") &&
                !First_Word.equals("timetype") &&
                !First_Word.equals("find") &&
                !First_Word.equals("todoafter") &&
                !First_Word.equals("processing") &&
                !First_Word.equals("delete") &&
                !First_Word.equals("todo") &&
                !First_Word.equals("event") &&
                !First_Word.equals("deadline") &&
                Input_Words.length == 1){
            throw new DukeTaskInputException("cannotUnderstand");
        }
    }

    /**
     * The method to extract task index from the user input for done and delete input
     *
     * @param inputWords user input int String[] type
     * @return task index
     * @throws DukeTaskInputException all error handler
     */
    private static int toExtractNumberForDoneAndDelete(String[] inputWords) throws DukeTaskInputException {
        if(inputWords.length == 2 && inputWords[1].matches("\\d+")){ // to check whether the char is integer
            int taskIndex;

            taskIndex = Integer.parseInt(inputWords[1]);

            return taskIndex;
        }
        else {
            throw new DukeTaskInputException("formatWrong");
        }
    }

    public static Command parse(String fullCommand) throws DukeTaskInputException {

        String[] inputWords = fullCommand.split(" ");
        String firstWord = inputWords[0].toLowerCase();

        Parser.Input_Length_Checking(firstWord, inputWords);

        switch (firstWord) {
            case "bye":
                return new ExitCommand();
            case "delete":
                return createDeleteCommand(inputWords);
            case "done":
                return createMarkAsDoneCommand(inputWords);
            case "list":
                return new ListCommand();
            case "todo":
            case "deadline":
            case "event":
                return createAddCommand(firstWord, inputWords);
        }

        throw new DukeTaskInputException("commandCreateError");
    }

    private static DeleteCommand createDeleteCommand(String[] inputWords) throws DukeTaskInputException {
        int taskIndex = toExtractNumberForDoneAndDelete(inputWords);
        return new DeleteCommand(taskIndex);
    }

    private static MarkAsDoneCommand createMarkAsDoneCommand(String[] inputWords) throws DukeTaskInputException {
        int taskIndex = toExtractNumberForDoneAndDelete(inputWords);

        return new MarkAsDoneCommand(taskIndex);
    }

    private static AddCommand createAddCommand(String firstWord, String[] inputWords) throws DukeTaskInputException {
        return new AddCommand(firstWord, inputWords);
    }
}
