import java.util.Scanner;
import Ui.Ui;

public class Duke {
    public static void main(String[] args) {
        Ui.welcome();

        boolean isExit = false;
        while (!isExit) {
            try {
                Scanner in = new Scanner(System.in);
                String userCommand = in.nextLine().trim();

                if(userCommand.equals("bye")) {
                    Ui.bye();
                    isExit = true;
                    continue;
                }

                Ui.print(userCommand);

            } catch (Exception e) {
                Ui.print("Parsing error: "+e.getMessage());
            }
        }

    }
}
