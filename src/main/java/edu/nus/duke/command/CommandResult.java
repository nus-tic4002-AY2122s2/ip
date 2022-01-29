package edu.nus.duke.command;

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

    public String getFeedback() {
        return feedback;
    }

    public Boolean getIsExit() {
        return isExit;
    }
}
