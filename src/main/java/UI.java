public class UI {
    /**
     * Prints welcome message of duke.
     * */
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
    /**
     * Prints bye message of duke.
     * */
    public static void byeMessage(){
        splitLine();
        System.out.println("Bye. Hope to see you again soon!");
        splitLine();
    }
    /**
     * Prints out split line.
     * */
    public static void splitLine(){
        System.out.println("--------------------------------------------------------");
    }
}
