public class Duke {
    public static void main(String[] args) {
        initialize();
    }
    private static void initialize(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        String line = "_______________________________________\n";
        String greet = " Hello! I', Duke \n What can I do for you?\n";
        String bye = "Bye. Hope to see you again soon!\n";
        System.out.println(logo + line + greet + line + bye + line);
    }
}
