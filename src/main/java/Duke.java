import java.util.Scanner;

public class Duke {
    private static String line = "_______________________________________\n"; // To shift to UI class
    public static void main(String[] args) {
        greet();
        echo();
        exit();
    }
    private static void greet(){                                          // To shift to UI class
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String greet = " Hello! I'm Duke \n What can I do for you?\n";
        System.out.println(logo + line + greet + line);
    }

    private static void exit(){                                                 // To shift to UI class
        String bye = "Bye. Hope to see you again soon!\n";
        System.out.println(line + bye + line);
    }

    private static void echo(){
        while (true) {
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();
            if (userInput.equalsIgnoreCase("bye"))
                return;
            System.out.println(line + userInput + "\n" + line);
        }
    }
}
