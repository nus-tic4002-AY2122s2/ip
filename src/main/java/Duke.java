import ui.Ui;
import userList.UserList;
import command.Command;

import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        try {
            Ui.welcome();
            UserList list = new UserList();
            Scanner in = new Scanner(System.in);

            boolean isExit = false;

            while (!isExit) {
                String userCommand = in.nextLine().trim();
                Command command = new Command(list, userCommand);
                isExit = command.getIsExit();
            }
        } catch (Exception e) {
            Ui.print("Error: " + e.getMessage());
        }
    }
}
