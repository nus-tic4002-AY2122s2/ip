## User Guide

Duke is a desktop app for tasks, optimized for use via a Command Line Interface (CLI). User will not have to remember task details and it can be found easily with commands.

1. Quick start
2. Features
    1. Adding a todo task: `todo`
    2. Adding a task with deadline: `deadline`
    3. Adding a event: `event`
    4. Showing all tasks: `list`
    5. Search a task: `find`
    6. Mark a task as done: `done`
    7. Delete a task: `delete`
    8. Help: `help`
    9. Exiting the program : `bye`

3. FAQ
4. Command summary





## Quick Start

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Ensure you have Java 11 or above installed in your computer.
2. Download the latest duke.jar from here.
3. Copy the file to the folder you want to use as the home folder.
4. Double-click the file to start the app. The GUI will greet you with:

```
    
Hi I’m Duke
  ____        _        
 |  _ \\ _   _| | _____ 
 | | | | | | | |/ / _ \\
 | |_| | |_| |   <  __/
 |____/ \\__,_|_|\\_\\__
How can I assist you today?
	
   ```
 5. Type the command in the command box and press Enter to execute it. e.g. typing list and pressing Enter will display all task that you have saved so far in the window.
Some example commands you can try:

    1. todo feed zhuzhu: Add a task to feed zhuzhu

    2. deadline return book /by Sunday: Add a task return book and the deadline for the task is Sunday.
    
    3. event dinner /at Mon 7pm: Add a dinner event that happens on Mon 7pm.

    4. list: List out all tasks details

    5. find dinner: List out all task that contain the word "dinner"
    
    6. done 1: Mark the 1st task as done.
    
    7. delete 3 : Deletes the 3rd task shown in the current list.
    
    8. help: Support details will be shown. 

    9. bye : Exit the application.

 6. Duke has auto-save and auto-load function. The list is being save as a text file named "Duke.txt" which is auto created and overwritten in the root folder.

 7. Refer to the Features below for details of each command.



## Features

### Adding a todo task: `todo`

Add a new task to the list.

Format: [todo] [task name]

Example: 

todo wash toilet


### Adding a task with deadline: `deadline`

Add a new task to the list.

Format: [deadline] [task name] [/by] [deadline]

Example:

deadline return book /by Sunday


### Adding a event task: `event`

Add a new task to the list.

Format: [event] [task name] [/at] [when the task happens]

Example:

event dinner /at Mon 7pm


### Showing all tasks: `list`

List out all tasks

Format: [list]

Example:

list


### Search for a task: `find`

List out the tasks based on the keyword

Format: [find] [keyword]

Example: 

find dinner


### Mark a task as done: `done`

Mark a task as done using task index

Format: [done] [index]

Example:

done 1


### Delete a task: `delete`

Delete a task from the list

Format: [delete] [index] 

Example: 

delete 3


### Help: `help`

Get Support

Format: [help]


### Exiting the program : `bye`

Exits the application.

Format: [bye]

Example:

bye
