import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    public static void welcome(){
        splitLine();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|";
        System.out.println("Hello from\n" + logo);
        splitLine();
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        splitLine();
    }
    public static void listMessage(ArrayList<Task> tasks) {
        splitLine();
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + 1 + "." + tasks.get(i).toString());
        }
        splitLine();
    }

    public static void byeMessage(){
        splitLine();
        System.out.println("Bye. Hope to see you again soon!");
        splitLine();
    }

    public static void addMessage(String fullCommand){
        splitLine();
        System.out.println("added: " + fullCommand);
        splitLine();
    }

    public static void splitLine(){
        System.out.println("--------------------------------------------------------");
    }

    public static String readCommand() {
        Scanner in = new Scanner(System.in);
        String fullCommand = in.nextLine();
        assert fullCommand.length() > 0: "The command can't be empty!";
        return fullCommand;
    }
}
