package edu.nus.duke.command;

/**
 * Data structure for used by the Command class.
 */
public class CommandResult {
    private String feedback;
    private boolean isExit;

    /**
     * Constructor of CommandResult class.
     *
     * @param outputToUser String to be displayed to user.
     * @param isExit Boolean to indicate application exit.
     */
    public CommandResult(String outputToUser, boolean isExit) {
        this.feedback = outputToUser;
        this.isExit = isExit;
    }

    /**
     * Return the String feedback to the user.
     *
     * @return String feedback.
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * Return a boolean which signals if the app should exit.
     *
     * @return Exit boolean.
     */
    public Boolean getIsExit() {
        return isExit;
    }
}
