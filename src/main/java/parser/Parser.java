package parser;
import constant.CommandKeyWords;

import exception.ErrorHandler;

public class Parser {
    private CommandKeyWords commandWord;
    private String content = "";
    private String by = "";
    private String at = "";

    public Parser(String userInput)throws ErrorHandler  {
        this.parseInput(userInput);
    }

    public CommandKeyWords getCommandWord() {
        return commandWord;
    }

    public String getContent() {
        return this.content;
    }
    public String getBy() {
        return this.by;
    }
    public String getAt() {
        return this.at;
    }

    private void parseInput (String input) throws ErrorHandler{
        String[] result = input.split(" ", 2);

            this.commandWord =  CommandKeyWords.getEnum(result[0].toUpperCase());

            if (this.commandWord != CommandKeyWords.LIST && this.commandWord != CommandKeyWords.BYE && result.length < 2) throw new ErrorHandler("In Parser, task number is not given.");

            switch (commandWord) {
                case DEADLINE:
                    String[] deadlineContent = result[1].split("/by", 2);
                    this.content = deadlineContent[0];

                    if (deadlineContent.length < 2)
                        throw new ErrorHandler("In Parser, invalid deadline command, missing '/by'.");
                    this.by = deadlineContent[1];
                    break;
                case EVENT:
                    String[] eventContent = result[1].split("/at", 2);
                    this.content = eventContent[0];

                    if (eventContent.length < 2)
                        throw new ErrorHandler("In Parser, invalid event command, missing '/at'.");
                    this.by = eventContent[1];
                    break;
                case TODO:
                case DONE:
                    this.content = result[1];
                    break;
                default:
                    break;
            }
    }
}
