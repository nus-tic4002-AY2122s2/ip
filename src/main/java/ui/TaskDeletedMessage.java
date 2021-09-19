package ui;

import task_classes.Task;

class TaskDeletedMessage {
    private String taskType;
    private int remainingTaskListSize;
    private String taskDescription;
    private String taskStatus;
    private Task deletedTask;

    /**
     * The method to initialize TaskDeletedMessage
     * @param deletedTask deletedTask
     * @param remainingTaskListSize remaining task list size
     */
    TaskDeletedMessage(Task deletedTask, int remainingTaskListSize) {
        this.taskType = deletedTask.getType();
        this.remainingTaskListSize = remainingTaskListSize;
        this.taskDescription = deletedTask.getDescription();
        this.taskStatus = deletedTask.getStatusIcon();
        this.deletedTask = deletedTask;
    }

    /**
     * To print deleted message after task deleted successfully
     */
    void printTaskDeletedMessage() {
        switch (taskType) {
            case "E":
                printDeletedEvent();
                break;
            case "D":
                printDeletedDeadline();
                break;
            case "T":
                printDeletedTodo();
                break;
        }
    }

    /**
     * To print message after user deleted a deadline task successfully
     */
    private void printDeletedDeadline(){

        String dateTime = deletedTask.getDeadlineDateTimeString();

        System.out.println("     Noted. I've removed this task:");
        System.out.println("       [" + taskType + "][" + taskStatus + "] " + taskDescription + "(by: " + dateTime + ")");
        System.out.println("     Now you have " + remainingTaskListSize + " task(s) in the list.");
    }

    /**
     * To print message after user deleted a event task successfully
     */
    private void printDeletedEvent(){

        String dateTime = deletedTask.getStartingDateTime();

        System.out.println("     Noted. I've removed this task:");
        System.out.println("       [" + taskType + "][" + taskStatus + "] " + taskDescription + "(at: " + dateTime + ")");
        System.out.println("     Now you have " + remainingTaskListSize + " task(s) in the list.");
    }

    /**
     * To print message after user deleted a todo task successfully
     */
    public void printDeletedTodo(){

        System.out.println("     Noted. I've removed this task:");
        System.out.println("       [" + taskType + "][" + taskStatus + "] " + taskDescription);
        System.out.println("     Now you have " + remainingTaskListSize + " task(s) in the list.");

    }
}
