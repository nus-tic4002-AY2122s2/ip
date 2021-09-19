package parser;

import exception.ErrorHandler;

public abstract class Parser {
    protected String content = "";
    protected String by = "";
    protected String at = "";

    public String getContent() {
        return this.content;
    }
    public String getBy() {
        return this.by;
    }
    public String getAt() {
        return this.at;
    }

    protected abstract void parseInput(String userInput) throws ErrorHandler;
}
