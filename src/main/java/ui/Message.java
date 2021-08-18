package ui;

public final class Message {
    private Message() {
    }

    public static void greeting() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("👋 from\n" + logo);

        System.out.println("You may spell your wish 🧞‍ \n");
    }

    /*
    echo print out the String parameter passed to it
     */
    public static void echo(String input) {
        System.out.print("\t");
        System.out.println(input);
        System.lineSeparator();
    }

    public static void exit() {
        System.out.println("\n👋 Bye, see ya ~ \n");
    }
}
