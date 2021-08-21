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

    public static void byeMessage(){
        splitLine();
        System.out.println("Bye. Hope to see you again soon!");
        splitLine();
    }

    public static void echoMessage(String fullCommand){
        splitLine();
        System.out.println(fullCommand);
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
