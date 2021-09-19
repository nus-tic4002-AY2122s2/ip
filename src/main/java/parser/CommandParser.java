package parser;

import constant.CommandKeyWords;
import constant.ErrorMessage;
import exception.ErrorHandler;

public class CommandParser extends Parser {
    private CommandKeyWords commandWord;

    public CommandParser(String userInput) throws ErrorHandler {
        this.parseInput(userInput);
    }

    public CommandKeyWords getCommandWord() { return this.commandWord;};

    @Override
    protected void parseInput (String input) throws ErrorHandler {
        String[] result = input.split(" ", 2);

        this.commandWord =  CommandKeyWords.getEnum(result[0].toUpperCase());

        switch (commandWord) {
            case DEADLINE:
                if(result.length < 2) throw new ErrorHandler("In Parser, " + ErrorMessage.EMPTY_DEADLINE);
                String[] deadlineContent = result[1].split("/by", 2);
                this.content = deadlineContent[0];

                if (deadlineContent.length < 2)
                    throw new ErrorHandler("In Parser, " + ErrorMessage.INVALID_DEADLINE);
                this.by = deadlineContent[1];
                break;
            case EVENT:
                if(result.length < 2) throw new ErrorHandler("In Parser, " + ErrorMessage.EMPTY_EVENT);

                String[] eventContent = result[1].split("/at", 2);
                this.content = eventContent[0];

                if (eventContent.length < 2)
                    throw new ErrorHandler("In Parser, " + ErrorMessage.INVALID_EVENT);
                this.by = eventContent[1];
                break;
            case TODO:
                if(result.length < 2) throw new ErrorHandler("In Parser, " + ErrorMessage.EMPTY_TODO);
                this.content = result[1];
                break;
            case DONE:
                if(result.length < 2) throw new ErrorHandler("In Parser, " + ErrorMessage.EMPTY_TASK_NUMBER);
                this.content = result[1];
                break;
            case LIST:
            case BYE:
            default:
                break;
        }
    }
}
