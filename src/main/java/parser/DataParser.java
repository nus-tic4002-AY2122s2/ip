package parser;

import constant.ErrorMessage;
import exception.ErrorHandler;


public class DataParser extends Parser{
    private String taskType;

    public  DataParser(String input) throws ErrorHandler {
        this.parseInput(input);
    }

    @Override
    protected void parseInput (String input) throws ErrorHandler {
        String [] data = input.split("|");
        if(data.length < 1) return;

        try {
            this.taskType = data[0];
            this.content = data[1];
            switch (this.taskType.toUpperCase()) {
                case "D":
                    this.by = data[2];
                    break;
                case "E":
                    this.at = data[2];
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            throw new ErrorHandler("In data parser, data is in wrong format");
        }
    }

    public String getTaskType() {return  this.taskType;}
}
