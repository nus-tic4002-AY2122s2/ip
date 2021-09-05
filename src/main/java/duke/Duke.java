import duke.dukeTask.*;
import java.util.Scanner;


public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("what can i do for you?\n");
        getMsg();
    }

    private static void getMsg(){
        String line;
        Scanner sc = new Scanner(System.in);
        Task[] taskList = new Task[100];
        int counter = 1;

        // user input loops
        while (true) {
            line = sc.nextLine().trim();
            // exit program
            if (line.equals("bye")){
                System.out.println("Bye.Hope to see you again soon!");
                sc.close();
                break;
            }else{
                // any other user input
                String[] userInput = null;
                String command;
                String input;
                String description = "";
                String date = "";
                // check for user command and input
                if(line.indexOf(" ") > 0){
                    userInput = line.split(" ",2);
                    command = userInput[0].trim();
                    input = userInput[1].trim();
                    if(command.equals("todo")){
                        todoFunction(taskList, input , counter);
                        addTaskPrint(taskList,counter);
                        counter++;
                    }else if(command.equals("done")){
                        int listLocation = Integer.valueOf(input);
                        doneFunction(taskList, listLocation);
                        donePrint();
                    }else if(command.equals("deadline")){
                        description = input.substring(0, input.indexOf("/by")-1);
                        date = input.substring(input.indexOf("/by")+3, input.length());
                        deadlineFunction(taskList, description, date, counter);
                        addTaskPrint(taskList,counter);
                        counter++;
                    }else if(command.contains("event")) {
                        description = input.substring(0, input.indexOf("/at") - 1);
                        date = input.substring(input.indexOf("/at") + 3, input.length());
                        eventFunction(taskList, description, date, counter);
                        addTaskPrint(taskList,counter);
                        counter++;
                    }else{
                        wrongCommand();
                    }
                }else if(line.isEmpty()) {
                    // empty user input
                    emptyInput();
                }else if(line.equals("list")) {
                    System.out.println("Here are the tasks in your list:\n");
                    printListFunction(taskList, counter);
                }else{
                    wrongInput();
                }
            }
        }
    }

    private static void printListFunction(Task[] taskList, int counter){
        for(int i = 1; i < counter; i++){
            System.out.println(i + "." +  taskList[i].toString());
        }
    }

    private static void doneFunction(Task[] taskList, int listLocation){
        Task t = taskList[listLocation];
        t.markAsDone();
        System.out.println("    " + taskList[listLocation].toString()) ;
    }

    private static Task[] todoFunction(Task[] taskList, String description, int counter){
        Task newTask = new Todo(description);
        //newTask.description = description;
        taskList[counter] = newTask;
        return taskList;
    }

    private static Task[] eventFunction(Task[] taskList, String description, String date, int counter){
        Task newTask = new Event(description, date);
        //newTask.description = description;
        taskList[counter] = newTask;
        return taskList;
    }

    private static Task[] deadlineFunction(Task[] taskList, String description, String date, int counter){
        Task newTask = new Deadline(description, date);
        //newTask.description = description;
        taskList[counter] = newTask;
        return taskList;
    }

    private static void emptyInput() {
        System.out.println("You have enter an empty string!!!");
    }

    private static void wrongCommand(){
        System.out.print("You have enter an invalid command!!!");
    }

    private static void wrongInput(){
        System.out.println("You have enter an invalid input!!!");
    }

    private static void donePrint(){
        System.out.println("Nice! I've marked this task as done:");
    }

    private static void addTaskPrint(Task[] taskList, int counter){
        System.out.println("Got it. I've added this task:");
        System.out.println("    " + taskList[counter].toString());
        System.out.println("Now you have " + counter + " tasks in the list.\n");
    }
}
