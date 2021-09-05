package parser;

public class Parser {
    private String commandWord = "";
    private String content = "";

    public Parser(String userInput) {
        this.parseInput(userInput);
    }

    public String getCommandWord() {
        return commandWord;
    }

    public String getContent() {
        return content;
    }

    private void parseInput (String input) {
        String[] result = input.split(" ", 2);
        this.commandWord = result[0];

        if(result.length > 1) {
            this.content = result[1];
        }
    }
}
