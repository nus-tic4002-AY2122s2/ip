package user_input;


import exceptions.DukeTaskInputException;
import task_classes.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Input_Parser {

    /**
     * To extract task description information from user input
     *
     * @param inputWords all user input in String[] type
     * @return the description in String type
     */
    public static String toExtractDescription(String[] inputWords) throws DukeTaskInputException {
        ArrayList<String> bufferA = new ArrayList<String>();

        /* If the input is to add todo task, then the length of the array must greater then 1 or there is no description */
        if(inputWords.length == 2){
            throw new DukeTaskInputException(inputWords[0], "descriptionMissing");
        }

        if(inputWords[0].equals("todo")){
            bufferA.addAll(Arrays.asList(inputWords).subList(1, inputWords.length));

            return convertStringArrayToString(bufferA);
        }else if (inputWords[0].equals("deadline")){
            for(int n = inputWords.length - 1; n > 0; n--) {
                if (inputWords[n].equals("/by")) {
                    if(n == 1){
                        throw new DukeTaskInputException(inputWords[0], "descriptionMissing");
                    }
                    if (n == inputWords.length - 1) {
                        throw new DukeTaskInputException(inputWords[0], "dateTime");
                    }

                    bufferA.addAll(Arrays.asList(inputWords).subList(1, n));

                    return convertStringArrayToString(bufferA);
                }
            }
        } else if (inputWords[0].equals("event")){
            for(int n = inputWords.length - 1; n > 0; n--) {
                if (inputWords[n].equals("/at")) {
                    if(n == 1){
                        throw new DukeTaskInputException(inputWords[0], "descriptionMissing");
                    }
                    if (n == inputWords.length - 1) {
                        throw new DukeTaskInputException(inputWords[0], "dateTime");
                    }

                    bufferA.addAll(Arrays.asList(inputWords).subList(1, n));

                    return convertStringArrayToString(bufferA);
                }
            }
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

        if(inputWords[0].equals("todo")){
            bufferA.addAll(Arrays.asList(inputWords).subList(1, inputWords.length));

            return convertStringArrayToString(bufferA);
        }else if (inputWords[0].equals("deadline")){
            for(int n = inputWords.length - 1; n > 0; n--) {
                if (inputWords[n].equals("/by")) {
                    if(n == 1){
                        throw new DukeTaskInputException(inputWords[0], "descriptionMissing");
                    }
                    if (n == inputWords.length - 1) {
                        throw new DukeTaskInputException(inputWords[0], "dateTime");
                    }

                    bufferA.addAll(Arrays.asList(inputWords).subList(n + 1, inputWords.length));

                    return convertStringArrayToString(bufferA);
                }
            }
        } else if (inputWords[0].equals("event")){
            for(int n = inputWords.length - 1; n > 0; n--) {
                if (inputWords[n].equals("/at")) {
                    if(n == 1){
                        throw new DukeTaskInputException(inputWords[0], "descriptionMissing");
                    }
                    if (n == inputWords.length - 1) {
                        throw new DukeTaskInputException(inputWords[0], "dateTime");
                    }

                    bufferA.addAll(Arrays.asList(inputWords).subList(n + 1, inputWords.length));

                    return convertStringArrayToString(bufferA);
                }
            }
        }

        throw new DukeTaskInputException(inputWords[0], "dateTime");
    }

    /**
     * To convert String[] to String type
     *
     * @param strArr String[] information
     * @return String[] information in String type
     */
    private static String convertStringArrayToString(ArrayList<String> strArr) {
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
    static void Input_Length_Checking(String First_Word, String[] Input_Words) throws DukeTaskInputException {
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
                Input_Words.length == 1){
            throw new DukeTaskInputException(First_Word, "descriptionMissing");
        }
    }

    public static int toExtractNumberForDoneAndDelete(String[] inputWords, Vector<Task> taskList) throws DukeTaskInputException {
        if(inputWords.length == 2 && inputWords[1].matches("\\d+")){ // to check whether the char is integer
            int taskIndex;

            taskIndex = Integer.parseInt(inputWords[1]);

            int listSize = taskList.size();

            if(taskIndex > listSize || taskIndex <= 0){
                throw new DukeTaskInputException("taskIndexOutOfRange");
            }

            return taskIndex;
        }
        else {
            throw new DukeTaskInputException("formatWrong");
        }
    }
}
