package constant;

import exception.ErrorHandler;

public enum CommandKeyWords {
    DONE("DONE"), TODO("TODO"), DEADLINE("DEADLINE"), LIST("LIST"), EVENT("EVENT"), BYE("BYE");

    public static String getSerializedString() { return "DONE, TODO, DEADLINE, EVENT, LIST, BYE"; }
    private String value;

    CommandKeyWords(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static CommandKeyWords getEnum(String value) throws ErrorHandler {
        for(CommandKeyWords v : values())
            if(v.getValue().equalsIgnoreCase(value)) return v;
        throw new ErrorHandler("Invalid command key word, Please make sure, your command start with "
                + getSerializedString()
                + " (case insensitive)");
    }

}

