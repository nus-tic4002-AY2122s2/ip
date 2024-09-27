# Main project template

This is a project template for a greenfield Java project. It's named after the Java mascot _Duke_. Given below are instructions on how to use it.

## Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project first)
1. Open the project into Intellij as follows:
    1. Click `Open`.
    1. Select the project directory, and click `OK`.
    1. If there are any further prompts, accept the defaults.
1. Configure the project to use **JDK 11** (not other versions) as explained in [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).<br>
   In the same dialog, set the **Project language level** field to the `SDK default` option.
3. After that, locate the `src/main/java/Main.java` file, right-click it, and choose `Run Main.main()` (if the code editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the below as the output:
   ```
     ____________________________________________________________
          Hello! I'm Main
          can I do for you?
     ____________________________________________________________
   ```

## Project description
This is a Java program which helps users to keep track their tasks. There are three different tasks, the program capable of keeping tack.
- Todo: A simple todo task
- Deadline: A task with specific deadline
- Event: A task with specific timing

User could also mark task as done to keep track the status of the task.

## User guide
User should interact with the software through Ui interface:
- Uer input section is for you to key in commands which are listed as follows:
  1. List - display the list of task including the status of the task status
  2. Todo - to add a todo task
  3. Deadline - to add a deadline task
  4. Event - to add an event task
  5. Done - to mark task as done
  6. Delete - to delete a task
  7. Find - to find tasks that matches the given search word
  8. Bye - exit the program
  
- System information section will display system generated information like errors, or action feedbacks. e.g. you 
  have successfully added a new task.
- Result section will show a list of task which corresponds to user command