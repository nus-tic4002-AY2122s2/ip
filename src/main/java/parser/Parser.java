package parser;

import exception.ErrorHandler;

public abstract class Parser {
    protected String content = "";
    protected String by = "";
    protected String at = "";

    /**
     * @return description of the taks
     */
    public String getContent() {
        return this.content;
    }

    /**
     * @return string representing due date of Deadline task
     */
    public String getBy() {
        return this.by;
    }

    /**
     * @return string representing due date of Event task
     */
    public String getAt() {
        return this.at;
    }

    protected abstract void parseInput(String userInput) throws ErrorHandler;
}
