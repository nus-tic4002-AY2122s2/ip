import java.util.Scanner;
import Ui.Ui;
import UserList.UserList;

public class Duke {
    public static void main(String[] args) {
        Ui.welcome();
        UserList list = new UserList();

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

                if(userCommand.equals("list")) {
                    Ui.printList(list.getList());
                    continue;
                }

                Ui.print(userCommand);
                list.addItem(userCommand);

            } catch (Exception e) {
                Ui.print("Parsing error: "+e.getMessage());
            }
        }

    }
}
