import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

	while(true) {
		System.out.println("Input Test\n");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		System.out.println("You Entered : " + input );
	}
    }
}
