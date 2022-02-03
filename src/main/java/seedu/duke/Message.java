package seedu.duke;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Message {

    public static final Map<String,String> myMessage;

    static {
        Map<String,String> message = new HashMap<>();
        message.put("GREETING","Hi I’m Duke\n[input]\nHow can I assist you today?");
        message.put("HELP_MESSAGE", "Please refer to the user guide for a quick reference.\n"
                + "If you have any other question, do drop us an email at support@duke.com. See you!");
        message.put("BYE_MESSAGE", "Bye. Your tasks have been recorded.\n Hope to see you again soon!");
        message.put("SEARCH_EMPTY","OOPS!!! There is nothing to find.");
        message.put("NO_MATCH","There is no matching task in your list.");
        message.put("ERROR_UNKNOWN","OOPS!!! I'm sorry, but I don't know what that means :-(");
        message.put("ADDED_SUCCESSFULLY","Your task has been added.\nYou have [input] tasks in the list.");
        message.put("DELETE_SUCCESSFULLY","Your task has been deleted.\nYou have [input] tasks in the list.");
        message.put("SEARCH_MATCHING_START_MESSAGE","Here are the matching tasks in your list:");
        message.put("MARK_SUCCESSFULLY","Nice! I've marked this task as done.");

        myMessage = Collections.unmodifiableMap(message);
    }

    /*public static void getVal(String key) {
        System.out.println(myMessage.get(key));
    }*/

    public static String getVal(String key) {
        return(myMessage.get(key));
    }

    /*public static void getVal(String key, String input) {
        //replace [input] with input
        System.out.println(myMessage.get(key).replace("[input]",input));
    }*/

    public static String getVal(String key, String input) {
        return(myMessage.get(key).replace("[input]",input));
    }

    public static String get(String key) {
        return myMessage.get(key);
    }

}
