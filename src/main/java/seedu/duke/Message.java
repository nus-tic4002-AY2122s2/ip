package seedu.duke;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Message {

    public static final Map<String,String> myMessage;

    static {
        Map<String,String> message = new HashMap<>();
        message.put("HELP_MESSAGE", "Do email us at support@airrec.com. See you!");
        message.put("BYE_MESSAGE", "Bye. Your flights have been recorded.\n Hope to see you again soon!");
        message.put("SEARCH_EMPTY","☹ OOPS!!! There is nothing to find.");
        message.put("NO_MATCH","There is no matching flight in your list.");
        message.put("ERROR_UNKNOWN","☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        message.put("GREETING","Hi I’m AIR REC\n[input]\nI can help you save all the flight details!"
                + "\nHow can I assist you today?");
        message.put("ADDED_SUCCESSFULLY","Your flight has been added.\nYou have [input] flights in your record");
        message.put("DELETE_SUCCESSFULLY","Your flight has been deleted.\nYou have [input] flights in your record");
        message.put("SEARCH_MATCHING_START_MESSAGE","Here are the matching flights in your list:");

        myMessage = Collections.unmodifiableMap(message);
    }

    public static void getVal(String key) {
        System.out.println(myMessage.get(key));
    }

    public static void getVal(String key, String input) {
        //replace [input] with input
        System.out.println(myMessage.get(key).replace("[input]",input));
    }

    public static String get(String key) {
        return myMessage.get(key);
    }

}
