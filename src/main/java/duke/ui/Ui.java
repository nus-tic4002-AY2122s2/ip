package duke.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Ui {

    private static final String SEPARATE_LINE = "_________________________________________________";
    private static final String LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    private static final String ERROR_LOADING_MSG = "Failed to load this Duke Application from storage file.";

    private final Scanner in;
    private final PrintStream out;

    public Ui() {
        this(System.in, System.out);
    }

    /**
     * Constructor of Ui
     */
    public Ui(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }


    /**
     * Prints the welcome message upon the start of the application.
     */
    public String showWelcome() {
        return "Hello from\n" + LOGO + SEPARATE_LINE
                + "Hello! I am Duke\nWhat can I do for you?" + SEPARATE_LINE;
    }

    /**
     * read command from the userInput
     *
     * @return the string of user input
     */
    public String readCommand() {
        out.print("Enter Command: ");
        String line = in.nextLine();
        return line;
    }

    public void showResponse(String commandResult) {
        out.println(commandResult);
    }

    /**
     * show the divider line.
     */
    public void showLine() {
        out.println(SEPARATE_LINE);
    }

    /**
     * show the error message
     *
     * @param message the passed message to show
     */
    public void showError(String message) {
        out.println(message);
    }

    /**
     * show the loading error message to the user.
     */
    public void showLoadingError() {
        out.print(ERROR_LOADING_MSG);
    }
}
