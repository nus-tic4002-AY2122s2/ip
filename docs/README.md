## User Guide

Duke is an interactive desktop app for managing your day to day tasking list, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, duke can get your contact management tasks done faster than traditional GUI apps.

1. Quick start
1. Features
	1. Adding a to-do task: todo
	1. Adding an event task: event
	1. Adding a task with deadline: deadline 
	1. Listing all available task : list
	1. Marking/unmarking tasks as done: done
	1. Deleting a task: delete
	1. Finding a task: find
	2. Tag a task: tag
	3. Exiting duke: bye
	4. Saving the data
1. FAQ
1. Command summary

## Quick Start
### CLI interface:

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
### GUI: 

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Ensure you have Java 11 or above installed in your computer.
2. Download the latest DukeV2.2.jar from here.
3. Copy the file to the folder you want to use as the home folder for your Duke.
4. Double-click the file to start the app. The GUI will pop out.

<img src="Ui.png" width="1080px" alt="Ui" />
6. Type the command in the command box and press Enter to execute it. e.g. typing list and pressing Enter will display all task that you have saved so far in the window.
Some example commands you can try:

	1. list : Lists all tasks available in the list.

	1. todo homework1 : Adds a todo task named homework to the list.

	1. event Birthday party /at John’s house : Adds an event task named Birthday party  with the location at John's house

	1. deadline project task 1 /by Tuesday: Adds a deadline task named project task 1 with a deadline by the upcoming Tuesday.

	1. delete3 : Deletes the 3rd task shown in the current task list.

	1. find work : Find a task by searching for the keyword work
  
  1. tag 2 #birthday : Tag task index 2 within the tasklist with a unique label.

	1. bye : Exits the application.

6. Duke has auto-save and auto-load function. The list is being save as a text file named "Duke.txt" which is auto created and overwritten in the root folder.

7. Refer to the Features below for details of each command.

## Features

<b>Notes about the command format:</b>

	1. This application is case INSENSITIVE. All commands are readable regardless upper or lower case.
	2. Date and time format are as shown: yyyy-mm-dd HHMM

### Adding a to-do task: todo

Adds a todo task to the list.

Format: [todo] [description]

Example: 

todo homework

ToDo HomeWork 2

### Adding an event task: event

Adds an event task to the list.

Format: [event] [description] [/at] [Location]

Example:

event Birthday party /at John’s house

EvEnT Birthday Party 2 /at sam’s house

### Adding a task with deadline: deadline 

Adds a task with deadline to the list.

Format: [deadline] [description] [/by] [yyyy-mm-dd HHMM]

Example: 

Deadline Project 2 /by 2019-12-12 0900

DeaDLine Project 3 /by Tuesday

### Listing all available task : list

Shows a list of all tasks in the task list.

Format: [list]

Example:

list

### Marking/unmarking tasks as done: done

Updates a selected task's status as done in the list.

Format: [done] [Task’s index in list]

Example:

done 1

done 2

### Deleting a task: delete

Deletes a task from the list. After deleting a task, all task list’s index will all be updated accordingly.

Format: [delete] [Task’s index in list]

Example:

delete1

delete 2

### Finding a task: find

Finds a task by searching for the keyword. The keyword need not be word for word, duke is smart enough to find the closest result to add into the found result and display for the user.

Format: [find] [keyword]

Example:

find work

find p

find party

### Tagging a task: tag

Tags a selected task with a unique label as input by user.

Format: [done] [Task’s index in list] [#uniquelabel]

Example:

tag 1 #birthday

tag 2 #homework

tag 3 #project

### Exiting duke: bye

This will exit the application.

Format: [bye]

Example:

bye

Bye


## FAQ

<b>Q</b>: How do I save multiple trip?

<b>A</b>: You only can save one trip at a time.

### Saving the data

Duke's task list are saved in the root folder automatically after any command that changes the data. There is no need to save manually.

## FAQ

<b>Q</b>: How do I transfer my task list to another Computer?
<b>A</b>: Install the app in the other computer and copy the current "Duke.txt" that contains the data of your previous Duke root folder to the new computer's duke's root folder.

## Command summary

Action | Format, Examples
------------ | -------------
<b>todo</b> | Format: [todo] [description] Example: todo homework
<b>event</b> | Format: [event] [description] [/at] [Location] Example: event Birthday party /at John’s house
<b>deadline</b> | Format: [deadline] [description] [/by] [yyyy-mm-dd HHMM] Example: Deadline Project 2 /by 2019-12-12 0900
<b>list</b> | Format: [list]
<b>done</b> | Format: [done] [Task’s index in list] Example: delete1
<b>find</b> | Format: [find] [keyword] Example: find work
<b>tag</b> | Format: [tag] [Task’s index in list] [#uniquelabel] Example: tag 2 #homework
<b>bye</b> | Format: [bye]
