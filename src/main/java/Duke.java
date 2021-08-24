public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        Greeting.Separated_Line();
        Greeting.Greeting_Output();
        Greeting.Separated_Line();
        System.out.println("");

        int n = 0;
        while(n!=2){
            n = Echo.Chat_Echo();
            System.out.println("");
        }
    }
}
