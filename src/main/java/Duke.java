import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        UI.printDuke();
        String line;
        Scanner in = new Scanner(System.in);

        while (true) {
            line = in.nextLine();
            UI.printLine();
            if (line.equals("bye")) {
                UI.bye();
                UI.printLine();
                break;
            } else {
                UI.printUserInput(line);
            }
            UI.printLine();
        }
    }
}