package parser;

import constant.ErrorMessage;
import exception.ErrorHandler;


public class DataParser extends Parser{
    private String taskType;
    private boolean status;

    public  DataParser(String input) throws ErrorHandler {
        this.parseInput(input);
    }

    /**
     * @param input string which is read from a text file, in the format of 'D|1|return book|June 6th'
     * @throws ErrorHandler customized error
     */
    protected void parseInput (String input) throws ErrorHandler {
        String [] data = input.split("\\|");
        if(data.length < 1) return;

        try {
            this.taskType = data[0];
            this.status = data[1].equals("1");
            this.content = data[2];

            if(this.taskType.equals("D")){
                this.by = data[3];
                return;
            }

            if(this.taskType.equals("E")) {
                this.at = data[3];
            }
        } catch (Exception e) {
            throw new ErrorHandler("In data parser, data is in wrong format");
        }
    }

    /**
     * @return string, which is a key work indicating different task
     * e.g. D - Deadline
     *      E - Event
     */
    public String getTaskType() {return  this.taskType;}

    /**
     * @return boolean value indicating if the task is finished.
     */
    public boolean getStatus() { return this.status; }
}
