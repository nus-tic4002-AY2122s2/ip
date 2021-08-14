import java.util.ArrayList;
import java.util.Scanner;


public class Duke {
    private static String line = "_______________________________________\n"; // To shift to UI class
    private static ArrayList<String> list = new ArrayList<String>();
    public static void main(String[] args) {
        greet();
        while (process(read()));
        exit();
    }
    private static void greet(){                                          // To shift to UI class
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String greet = " Hello! I'm Duke \n What can I do for you?\n";
        dukeReply(logo + greet);
    }

    private static void exit(){                                                 // To shift to UI class
        String bye = "Bye. Hope to see you again soon!\n";
        dukeReply(bye);
    }



    private static String parse(String userInput){
        String command = userInput.toLowerCase();
        return command;
    }

    private static String read(){
            Scanner in = new Scanner(System.in);
            String userInput = parse(in.nextLine());
            return userInput;
    }

    private static void addToList (String userInput){
        list.add((list.size()+1) + "." + userInput + "\n");
        dukeReply("added: " + userInput + "\n");
    }

    private static void showList (){
        String taskList = new String();
        for (String task : list)
            taskList = taskList.concat(task);
        dukeReply(taskList);
    }

    private static void dukeReply (String reply){
        System.out.println(line + reply + line);
    }

    private static boolean process(String userInput){
        switch(userInput) {
            case "bye":
                return false;
            case "list":
                showList();
                return true;
            default:
                addToList(userInput);
                return true;
        }
    }
}
