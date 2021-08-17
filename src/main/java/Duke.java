import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Duke {
    //
    public static ArrayList<String> list = new ArrayList<>();
    public static ArrayList<Boolean> mark = new ArrayList<>();

    public static void main(String[] args) {

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke\nWhat can I do for you?");

        while (echo()) ;
    }

    public static boolean echo() {

        String userInput;
        Scanner scan = new Scanner(System.in);
        userInput = scan.nextLine();

        String[] splitStr = userInput.split("\\s+");

        switch (splitStr[0]) {
            case "bye":
                System.out.println("Bye. Hope to see you again soon!");
                return false;
            case "list":
                printList();
                return true;
            case "done":
                int index = Integer.valueOf(splitStr[1]) - 1;
                System.out.println("Nice! I've marked this task as done: \n" +
                        "       [X] " + list.get(index));
                mark.set(index, true);
                return true;
            default:
                list.add(userInput);
                mark.add(false);
                System.out.println("added: " + userInput);
                return true;
        }
    }

    public static void printList(){
        String markToString;
        for(int i = 0; i < list.size(); i++){
            if(mark.get(i)){
                markToString = "X";
            }
            else {
                markToString = "";
            }
            System.out.println(i+1 + ". [" + markToString + "] " + list.get(i));
        }
    }
}