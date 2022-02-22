package tasklist;

import java.util.Date;

public class ToDo extends Task {

    /****
     *
     * @param description the task description that the user input
     */
    public ToDo(String description) {
        super(description);
    }

    /****
     *
     * @param description the task description that the user input
     * @param status check if the task has already marked as done
     */
    public ToDo(String description, Boolean status) {
        super(description, status);
    }

    @Override
    public String toString() {
        return("[T]" + super.toString());
    }

    @Override
    public String saveFormat(){
        return("T " + super.saveFormat());
    }

    /****
     *
     * @param dateSearch the date that user input
     * @param taskType the task type of the object
     */
    @Override
    public boolean findDate(Date dateSearch, String taskType) {
        return false;
    }

    /****
     *
     * @param dateSearch the date that user input
     * @param taskType the task type of the object
     */
    @Override
    public boolean findFromDateRange(Date dateSearch, String taskType) {
        return false;
    }

    /****
     *
     * @param fromDate the start date that user input
     * @param endDate the end date that user input
     * @param taskType the task type of the object
     */
    @Override
    public boolean findBetweenDateRange(Date fromDate, Date endDate, String taskType) {
        return false;
    }

    /****
     *
     * @param taskType the task type of the object
     */
    @Override
    public boolean taskType(String taskType){
        return taskType.equals("todo");
    }
}