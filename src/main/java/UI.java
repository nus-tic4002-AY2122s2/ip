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
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void printLine() {
        System.out.println("____________________________________________________________");
    }
}
