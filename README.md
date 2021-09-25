# Duke project template

This is a project template for a greenfield Java project. It's named after the Java mascot _Duke_. Given below are instructions on how to use it.

## User Guide

Duke is an interactive desktop app for managing your day to day tasking list, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, duke can get your contact management tasks done faster than traditional GUI apps.

Quick start
Features
Adding a to-do task: todo
Adding an event task: event
Adding a task with deadline: deadline 
Listing all available task : list
Marking/unmarking tasks as done: done
Deleting a task: delete
Finding a task: find
Exiting duke: bye
Saving the data
FAQ
Command summary


## Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project first)
2. Open the project into Intellij as follows:
   1. Click `Open`.
   1. Select the project directory, and click `OK`.
   1. If there are any further prompts, accept the defaults.
3. Configure the project to use **JDK 11** (not other versions) as explained in [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).<br>
   In the same dialog, set the **Project language level** field to the `SDK default` option.
4. After that, locate the `src/main/java/Duke.java` file, right-click it, and choose `Run Duke.main()` (if the code editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the below as the output:
   ```
 ____        _        
|  _ \ _   _| | _____ 
| | | | | | | |/ / _ \
| |_| | |_| |   <  __/
|____/ \__,_|_|\_\___|
	________________________________________________________________
	Hello! I'm Duke
	What can i do for you?
	________________________________________________________________
	
   ```
 5. Type the command in the command box and press Enter to execute it. e.g. typing list and pressing Enter will display all task that you have saved so far in the window.
Some example commands you can try:

list : Lists all tasks available in the list.

todo homework1 : Adds a todo task named homework to the list.

event Birthday party /at John’s house : Adds an event task named Birthday party  with the location at John's house

deadline project task 1 /by Tuesday: Adds a deadline task named project task 1 with a deadline by the upcoming Tuesday.

delete3 : Deletes the 3rd task shown in the current task list.

find work : Find a task by searching for the keyword work

bye : Exits the application.

6. Duke has auto-save and auto-load function. The list is being save as a text file named "Duke.txt" which is auto created and overwritten in the root folder.

7. Refer to the Features below for details of each command.

Notes about the command format:

	1. This application is case INSENSITIVE. All commands are readable regardless upper or lower case.
	2. Date and time format are as shown: yyyy-mm-dd HHMM

Adding a to-do task: todo
Adds a todo task to the list.
Format: [todo] [description]
Example: 
todo homework
ToDo HomeWork 2

Adding an event task: event
Adds an event task to the list.
Format: [event] [description] [/at] [Location]
Example: 
event Birthday party /at John’s house
EvEnT Birthday Party 2 /at sam’s house

Adding a task with deadline: deadline 
Adds a task with deadline to the list.
Format: [deadline] [description] [/by] [yyyy-mm-dd HHMM]
Example: 
Deadline Project 2 /by 2019-12-12 0900
DeaDLine Project 3 /by Tuesday

Listing all available task : list
Shows a list of all tasks in the task list.
Format: [list]
Example:
list

Marking/unmarking tasks as done: done
Updates a selected task's status as done in the list.
Format: [done] [Task’s index in list]
Example:
done 1
done 2

Deleting a task: delete
Deletes a task from the list.
After deleting a task, all task list’s index will all be updated accordingly
Format: [delete] [Task’s index in list]
Example:
delete1
delete 2

Finding a task: find
Finds a task by searching for the keyword. The keyword need not be word for word, duke is smart enough to find the closest result to add into the found result and display for the user.
Format: [find] [keyword]
Example:
find work
find p
find party

Exiting duke: bye
This will exit the application.
Format: [bye]
Example:
bye
Bye

Saving the data
Duke's task list are saved in the root folder automatically after any command that changes the data. There is no need to save manually.

FAQ
Q: How do I transfer my task list to another Computer?
A: Install the app in the other computer and copy the current "Duke.txt" that contains the data of your previous Duke root folder to the new computer's duke's root folder.

Command summary

