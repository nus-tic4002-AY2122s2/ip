import ui.Ui;
import userList.UserList;
import command.Command;

import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Ui.welcome();
        UserList list = new UserList();

        boolean isExit = false;

        while (!isExit) {
            try {
                Scanner in = new Scanner(System.in);
                String userCommand = in.nextLine().trim();
                Command command = new Command(list, userCommand);
                isExit = command.getIsExit();
            } catch (Exception e) {
                Ui.print("Error: " + e.getMessage());
            }
        }
    }
}
