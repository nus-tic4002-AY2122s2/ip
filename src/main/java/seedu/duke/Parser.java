package seedu.duke;

public class Parser {
    /**
     * This parser will be able to parse the inputs from the user to a readable command
     * for duke to process the inputs accordingly by the user.
     *
     * @param userInput The string of words typed in by the user.
     * @return A readable command for duke to process based on the command.
     */
    public String parseInput(String userInput) {
        userInput = userInput.toLowerCase();
        String command = "unknown";
        if (userInput.contains("bye")) {
            command = "bye";
        }
        if (userInput.contains("list")) {
            command = "list";
        }
        if (userInput.contains("delete")) {
            command = "delete";
        }
        if (userInput.contains("add")) {
            command = "add";
        }
        return command;
    }

}
