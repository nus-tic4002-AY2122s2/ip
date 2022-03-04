package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Represents the Ui. It is meant to scan for new input and
 * print the various Strings.
 */
public class Ui {
    public String input;
    Scanner scan;
    List<String> messages;

    /**
     * This is the constructor for Ui. It initialises the scan and input objects.
     */

    public Ui() {

        this.input = "";
        scan = new Scanner(System.in);
        messages = new ArrayList<String>();
    }

    /**
     * This prints the intro logo of Duke.
     */
    public String printIntro() {
        String intro = "Hello from Duke! Type \"/help\" for help with commands! \n";
        return intro;
    }

    /**
     * This prints the dashed line used to separate printed lines/sections.
     */
    public void showLine() {
        System.out.println("___________________________________________________");
    }

    /**
     * This prints the farewell message when the user types "bye".
     */
    public String printBye() {
        return ("\n" + "Bye. Hope to see you again soon!");
    }

    /**
     * This prints the request message for input from user and scans for the input.
     *
     * @return the input scanned from user
     */
    public String scanForInput() {
        System.out.println("\n" + "What can I do for you? For help, type \"/help\". ");
        return this.scan.nextLine();
    }

    /**
     * Print the error passage that is in parameters.
     *
     * @param errorMessage This is the error message that is received.
     */
    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }

    /**
     * This prints the specific loading error when the Task List
     * did not load from storage.
     */
    public String showLoadingError() {
        return ("Did not load Task List from Filepath");
    }

    public void storeMessage(String message) {
        messages.add(message);
    }

    public void clearMessages() {
        messages.clear();
    }

    public String getMessages() {
        String reply = "";

        for (int i = 0; i < messages.size(); i++) {
            reply = reply + messages.get(i) + "\n";
        }
        return reply;
    }

}
