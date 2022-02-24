import java.util.Scanner;

public class Ui {
    private Scanner in;

    public Ui() {
        this.in = new Scanner(System.in);
    }

    public String readCommand() throws DukeException {
        String input = this.in.nextLine();
        if (input.isEmpty()) {
            throw new DukeException();
        }
        return input;
    }

    /**
     * Shows the line for the chatbot's box.
     *
     * @return A straight line for the chatbox
     */

    public String showLine() {
        return "\t________________________________________________________________\n\t";
    }

    /**
     * Shows welcome message with logo.
     */
    public String showWelcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String welcome = "Hello! I'm Duke\n\tWhat can i do for you?\n";
        return logo + showLine() + welcome + showLine();
    }

    /**
     * Display the latest task added to the list along with the current Task list size.
     *
     * @param taskDetails A String of details of the current task added.
     * @param listSize    The current size of the list.
     */
    public String showTaskAdded(String taskDetails, int listSize) {
        String currentTask = "Got it. I've added this task:\n\t\t" + taskDetails;
        String numberOfTask = "\n\tNow you have " + listSize + " tasks in the list.\n";
        return ( currentTask + numberOfTask );
    }

    /**
     * Display the latest task deleted from the list along with the new updated Task List size after deleting.
     *
     * @param deletedTask A String of details of the current deleted task.
     * @param tasklist    The current tasklist.
     */
    public String showDeletedTask(String deletedTask, TaskLists tasklist) {
        String deletedTaskMessage = "Noted. I've removed this task: \n\t\t" + deletedTask;
        String deletedTaskMessage2 = "\tNow you have " + tasklist.getSize() + " tasks in the list.\n";
        return ( deletedTaskMessage + deletedTaskMessage2 );
    }

    /**
     * Display the current task set to done & update the status of the task.
     *
     * @param doneTask A string of the description of the task.
     */
    public String showDoneTask(String doneTask) {
        String doneMessage = "Nice! I've marked this task as done: \n\t" + doneTask;
        return doneMessage;
    }

    /**
     * Display the whole list to user.
     *
     * @param list String of current task list.
     */
    public String showList(String list) {
        String listTask = "Here are the Tasks in your list:\n\t" + list + "\n";
        return listTask;
    }

    /**
     * Displays the matching result from the keyword search by user.
     *
     * @param list String of matching result list.
     */
    public String showFindResult(String list) {
        String listResult = "Here are the matching tasks in your list:\n\t" + list + "\n";
        return listResult;
    }

    /**
     * Displays goodbye message to users when they type in "bye".
     */
    public String showOffline() {
        String goodbye = "Bye. Hope to see you again soon!\n";
        return goodbye;
    }

    /**
     * When user inputs a file that is not in the correct format or erroneous file.
     */
    public String showFileInputError() { //can be for files input
        String errorMessage = "There is something wrong with the previous file, please check the content\n\tof the file. I'm unable to load the past task list.\n";
        return errorMessage;
    }

    /**
     * When user inputs a ToDO task yet not stating the description of the task.
     */
    public String showToDoEmptyError() {
        String errorMessage = "\u2639 OOPS!!! The description of a todo cannot be empty.\n";
        return errorMessage;
    }

    /**
     * When user inputs an unknown command for duke to understand and process.
     */
    public String showUnknownInputError() {
        String errorMessage = ":( OOPS!!! I'm sorry, but I don't know what that means :-(\n";
        return errorMessage;
    }

    /**
     * When user inputs a Deadlines task yet not stating the description of the task.
     */
    public String showDeadlineEmptyError() {
        String errorMessage = "\u2639 OOPS!!! The description of the deadline cannot be empty.\n";
        return errorMessage;
    }

    /**
     * When user inputs a Events task yet not stating the description of the task.
     */
    public String showEventEmptyError() {
        String errorMessage = "\u2639 OOPS!!! The description of the event cannot be empty.\n";
        return errorMessage;
    }

    /**
     * When duke access an empty list.
     */
    public String showListEmptyError() {
        String errorMessage = "\u2639 You have an empty list.\n";
        return errorMessage;
    }

    /**
     * When user inputs an invalid task format.
     */
    public String showInvalidTaskFormatError() {
        String errorMessage = "You've entered an invalid format of Task, please check your input format again.\n";
        return errorMessage;
    }

    /**
     * When user inputs a task numnber which is not in the index of the current list size.
     */
    public String showInvalidTaskNumberError() {
        String errorMessage = "You've entered an invalid value for Task, please key in valid task number.\n";
        return errorMessage;
    }

    /**
     * Error while duke is reading the file. Maybe the content of the file or the filepath error.
     */
    public String showFileError() {
        String errorMessage = "Duke is unable to read your file, please check your input filepath again.\n";
        return errorMessage;
    }
    /**
     * Error while duke is reading the file. Maybe the content of the file or the filepath error.
     */
    public String showDateTimeError() {
        String errorMessage = "Please check your date and time format and re-enter it according to the stated format\n";
        return errorMessage;
    }

    /**
     * When the find command is activated, duke is unable to find the relating task with the user's input.
     */
    public String showFindNoResult() {
        String errorMessage = "Sorry, I am unable to find any task like that.\n";
        return errorMessage;
    }

}