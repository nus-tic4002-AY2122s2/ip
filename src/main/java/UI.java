public class UI {
    public static void printDuke() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.print("Hello! I'm Duke\n" + "What can I do for you?\n");
    }

    public static void bye() {
        System.out.println(addSpaces("%sBye. Hope to see you again soon!"));
    }

    public static void printLine() {
        System.out.println(addSpaces("%s____________________________________________________________"));
    }

    public static void printUserInput(String text) {
        System.out.println(addSpaces("%s" + text));
    }

    public static String addSpaces(String text) {
        return (String.format(text, " ".repeat(4)));
    }
}
